public class Cos extends Element {
    private Element inner;

    Cos(Element inner){
        this.inner = inner;
    }

    public Element derivative(){
        return new Mul(
                new Neg(
                        new Sin(inner)
                ),
                inner.derivative()
        );
    }

    public String toString(){
        return "cos("+inner+")";
    }

    public boolean equals(Element another){
        if(another instanceof Cos){
            return this.inner.equals(((Cos) another).inner);
        }
        return false;
    }
}