public class Sin extends Element {
    private Element inner;
    Sin(Element inner){
        this.inner = inner;
    }

    public Element diff(){
        return new Mul(
                new Cos(inner),
                inner.diff()
        );
    }

    public String toString(){
        return "sin("+inner+")";
    }

    public Element substitute(Element x){
        inner.substitute(x);
        if(this.inner instanceof X){
            this.inner = x;
        }
        return this;
    }
}
