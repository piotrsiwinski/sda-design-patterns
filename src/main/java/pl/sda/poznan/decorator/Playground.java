package pl.sda.poznan.decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import pl.sda.poznan.decorator.shapedecorator.Circle;
import pl.sda.poznan.decorator.shapedecorator.ColoredCircle;
import pl.sda.poznan.decorator.shapedecorator.Shape;
import pl.sda.poznan.decorator.shapedecorator.TransparentCircle;

public class Playground {

  public static void main(String[] args) throws Exception {

    FileReader fileReader = new FileReader("plik.txt");
    fileReader.read();
    BufferedReader bufferedReader = new BufferedReader(new FileReader("plik.txt"));

    Circle circle = new Circle(4);
    System.out.println(circle.info());

    ColoredCircle coloredCircle = new ColoredCircle(circle, "red");
    System.out.println(coloredCircle.info());

    // Obiekt koła ktory ma kolor
    ColoredCircle cc = new ColoredCircle(new Circle(10), "green");

    // Koło ktore ma przezroczystosc
    TransparentCircle transparentCircle = new TransparentCircle(new Circle(14), 60);

    // Kolo ktore ma kolor i przezroczystosc
    Shape mostDecoratedShape = new TransparentCircle(new ColoredCircle(new Circle(20), "red"), 80);
    System.out.println(mostDecoratedShape.info());


  }
}
