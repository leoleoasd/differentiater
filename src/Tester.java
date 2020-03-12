public class Tester{
    public static void main(String[] args){

        // x**2+1
        Element e = new Add(
                new Mul(
                        new X(),
                        new Constant(2)
                ),
                new Constant(1)
        );

        // x ** 2 + 1
        System.out.println(e);

        // Simple like this!
        // 2 * x
        System.out.println(e.diff());


        // Any layers are supported!
        e = new Add(
                new Mul(
                        new X(),
                        new Sin(
                                new Mul(
                                        new Sin(
                                                new X()
                                        ),
                                        new X()
                                )
                        )
                ),
                new Constant(1)
        );

        // ((x * sin((sin(x) * x))) + 1)
        System.out.println(e);

        // Simple like this!
        // (((cos((sin(x) * x)) * (sin(x) + (cos(x) * x))) * x) + sin((sin(x) * x)))
        System.out.println(e.diff());

        e = new Mul(
                new X(),
                new Constant(2)
        );

        // x * 2
        System.out.println(e);

        // 2
        System.out.println(e.diff());

        // Will replace any X with a X**2!
        e.substitute(new Pow(new X(), new Constant(2)));

        // 4*x
        System.out.println(e.diff());
    }
}