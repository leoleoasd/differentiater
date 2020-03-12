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
}
