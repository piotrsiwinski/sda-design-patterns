package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.List;

public class LambdaPlayground {

  public static void foo(Calc calc, int a, int b) {
    System.out.println(calc.calculate(a, b));
  }

  public static void main(String[] args) {

    foo((a, b) -> a - b, 10, 3);

    Calc calc = (a, b) -> a + b;

    System.out.println(calc.calculate(5, 10));
    System.out.println(calc.calculate(20, 25));
    System.out.println(calc.calculate(200, 250));

    Calc multiply = (a, b) -> a * b;
    System.out.println(multiply.calculate(2, 4));
////////////////////////////////////////////////////////////

    List<Integer> lst = Arrays.asList(1, 3, 4, 5, 8, 10);
    lst.stream().filter(x -> x > 5);

//    void accept (T t);
    lst.forEach(System.out::println);




  }
}
