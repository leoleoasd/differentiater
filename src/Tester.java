import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Element e = new Ln(
                new Pow(
                        new X(),
                        new Constant(5)
                )
        );
        System.out.println(e);
        System.out.println(e.derivative());
    }

    public static Element prase(String str){
        Scanner scanner = new Scanner(str);
        Stack<Element> stack = new Stack<>();
        // Todo: write a parser.
        return new X();
    }
}
