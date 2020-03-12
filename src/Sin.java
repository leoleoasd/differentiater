public class Sin extends Element {
    private Element inner;
    Sin(Element inner){
        this.inner = inner;
    }

    public Element derivative(){
        return new Mul(
                new Cos(inner),
                inner.derivative()
        );
    }

    public String toString(){
        return "sin("+inner+")";
    }
}
