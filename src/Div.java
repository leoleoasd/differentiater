public class Div extends Element {
    private Element a;
    private Element b;

    Div(Element a, Element b){
        this.a = a;
        this.b = b;
    }

    public Element diff(){
        Element da = a.diff();
        Element db = b.diff();

        return new Div(
                new Add(
                        new Mul(
                                da,
                                b
                        ),
                        new Mul(
                                db,
                                a
                        )
                ),
                new Pow(
                        b,
                        new Constant(2)
                )
        );
    }

    public Element trim(){
        a = a.trim();
        b = b.trim();
        if(this.a.equals(new Constant(0))){
            return new Constant(0);
        }
        if(this.b.equals(new Constant(1))){
            return a.trim();
        }
        return this;
    }

    public Element substitute(Element x){
        a.substitute(x);
        b.substitute(x);
        if(this.a instanceof X){
            this.a = x;
        }
        if(this.b instanceof X){
            this.b = x;
        }
        return this;
    }

    public String toString(){
        return "(" + a.toString() + " / " + b.toString() + ")";
    }
}
