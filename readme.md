# 很多函数求导器

字面意思, 这是一个能给很多函数求导的工具.

目前支持:

加减乘除, 三角函数, ln, 指数函数, 复合函数.

## Examples and Usage

```java
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
        System.out.println(e.derivative());


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
        System.out.println(e.derivative());

        e = new Mul(
                new X(),
                new Constant(2)
        );

        // x * 2
        System.out.println(e);

        // 2
        System.out.println(e.derivative());

        // Wrap it with a function
        Function f = new Function(e);

        // Will replace any X with a X**2!
        f.substitute(new Pow(new X(), new Constant(2)));
        
        // 4*x
        System.out.println(f.derivative());
    }
}
```

## TODO

- [x] 除法支持
- [ ] 字符串parser
- [ ] 化简算法
