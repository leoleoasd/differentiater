
public abstract class Element{

    /**
     * 求导
     * @return Element
     */
    abstract public Element diff();

    /**
     * 代入, 用参数X替代自己的 X类 的元素 来支持复合函数
     * @param x 要代入的元素
     * @return Element
     */
    abstract public Element substitute(Element x);

    public Element trim(){
        return this;
    }

    public boolean equals(Element b){
        return this == b;
    }
}
