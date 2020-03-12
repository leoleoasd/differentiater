public class Function extends Element {

    private Element inner;

    private Element inde;

    Function(){}

    Function(Element inner){
        if(inner instanceof Function){
            this.inner = ((Function) inner).getInner();
        }else {
            this.inner = inner;
        }
        this.inde = new X();
    }

    public Element substitute(Element inde){
        if(inde instanceof Function){
            this.inde = ((Function) inde).getInner();
        }else {
            this.inde = inde;
        }
        return this;
    }

    public Element derivative(){
        return new Mul(
                inner.derivative().substitute(inde),
                inde.derivative()
        ).trim();
    }

    public String toString(){
        return "Function: "+inner.toString();
    }

    public Element getInner(){
        return inner;
    }
}
