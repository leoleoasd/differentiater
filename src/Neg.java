public class Neg extends Element {
    private Element inner;

    Neg(Element inner){
        this.inner = inner;
    }

    public Element derivative(){
        return new Neg(inner.derivative());
    }

    public String toString(){
        return "-"+inner;
    }
}
