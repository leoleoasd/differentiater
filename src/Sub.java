public class Sub extends Element {
    private Element a;
    private Element b;

    Sub(Element a, Element b){
        this.a = a;
        this.b = b;
    }

    public Element diff(){
        Element da = a.diff();
        Element db = b.diff();
        return new Sub(da,db).trim();
    }

    public Element trim(){
        if(this.a.equals(new Constant(0))){
            return this.b;
        }
        if(this.b.equals(new Constant(0))){
            return this.a;
        }
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
        return "(" + a.toString() + " - " + b.toString() + ")";
    }
}
