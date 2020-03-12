public class Mul extends Element {
    private Element a;
    private Element b;

    Mul(Element a, Element b){
        this.a = a;
        this.b = b;
    }

    public Element derivative(){
        Element da = a.derivative();
        Element db = b.derivative();

        return new Add(
                new Mul(db,a),
                new Mul(da,b)
        ).trim();
    }

    public Element trim(){
        if(this.a.equals(new Constant(0))){
            return new Constant(0);
        }
        if(this.b.equals(new Constant(0))){
            return new Constant(0);
        }
        if(this.a.equals(new Constant(1))){
            return b.trim();
        }
        if(this.b.equals(new Constant(1))){
            return a.trim();
        }
        a = a.trim();
        b = b.trim();
        return this;
    }

    public Element substitute(Element x){
        if(this.a instanceof X){
            this.a = x;
        }
        if(this.b instanceof X){
            this.b = x;
        }
        a.substitute(x);
        b.substitute(x);
        return this;
    }

    public String toString(){
        return "(" + a.toString() + " * " + b.toString() + ")";
    }
}
