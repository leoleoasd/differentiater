public class Ln extends Element {
    private Element inner;

    Ln(Element inner){
        this.inner = inner;
    }

    public Element derivative(){
        return new Div(
                inner.derivative(),
                inner
        );
    }

    public String toString(){
        return "ln("+inner+")";
    }

    public boolean equals(Element another){
        if(another instanceof Ln){
            return this.inner.equals(((Ln) another).inner);
        }
        return false;
    }
}
