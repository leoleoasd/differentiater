public class Neg extends Element {
    private Element inner;

    Neg(Element inner){
        this.inner = inner;
    }

    public Element diff(){
        return new Neg(inner.diff());
    }

    public String toString(){
        return "-"+inner;
    }

    public Element substitute(Element x){
        inner.substitute(x);
        if(this.inner instanceof X){
            this.inner = x;
        }
        return this;
    }
}
