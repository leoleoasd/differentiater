public class Add extends Element {
    private Element a;
    private Element b;

    Add(Element a, Element b){
        this.a = a;
        this.b = b;
    }

    public Element diff(){
        Element da = a.diff();
        Element db = b.diff();
        return new Add(da,db).trim();
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

    public Element trim(){
        this.a = this.a.trim();
        this.b = this.b.trim();
        if(this.a.equals(new Constant(0))){
            return this.b.trim();
        }
        if(this.b.equals(new Constant(0))){
            return this.a.trim();
        }
        return this;
    }

    public String toString(){
        return "(" + a.toString() + " + " + b.toString() + ")";
    }

    public boolean equals(Element another){
        if(another instanceof Add){
            return this.a.equals(((Add) another).a) && this.b.equals(((Add) another).b);
        }
        return false;
    }
}
