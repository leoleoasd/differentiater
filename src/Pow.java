public class Pow extends Element {
    private Element a;
    private Constant b;

    Pow(Element a, Constant b){
        this.a = a;
        this.b = b;
    }

    public Element derivative(){
        return new Mul(
                new Mul(
                        new Pow(a, new Constant(b.inner-1)),
                        b
                ),
                a.derivative()
        ).trim();
    }

    public Element trim(){
        this.a = this.a.trim();
        if(this.a.equals(new Constant(0))){
            return new Constant(0);
        }
        if(this.b.equals(new Constant(0))){
            return new Constant(1);
        }
        if(this.a.equals(new Constant(1))){
            return new Constant(1);
        }
        if(this.b.equals(new Constant(1))){
            return a.trim();
        }
        return this;
    }

    public Element substitute(Element x){
        if(this.a instanceof X){
            this.a = x;
        }
        a.substitute(x);
        return this;
    }

    public String toString(){
        return "(" + a.toString() + " ** " + b.toString() + ")";
    }
}
