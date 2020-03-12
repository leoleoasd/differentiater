public class Constant extends Element {
    public Integer inner;

    Constant(int in){
        this.inner = in;
    }

    public Constant diff(){
        return new Constant(0);
    }

    public String toString(){
        return String.valueOf(this.inner);
    }

    public boolean equals(Element b){
        if(b instanceof Constant){
            return inner.equals(((Constant) b).inner);
        }else{
            return false;
        }
    }
}
