package pl.sda.poznan.coll;

@FunctionalInterface
public interface Calc {

  int calculate(int a, int b);

  default void foo() {
    System.out.println(calculate(2, 3));
  }

}
