package pl.sda.poznan.iterator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Playground {

  // var - args

  public static void foo(String... mojeNapisy) {
    for (String s : mojeNapisy) {
      System.out.println(s);
    }
  }

  public static void main(String[] args) {
    //1
//    foo("piotr");
//    foo("piotr", "Ela");
//    foo("piotr", "Ela", "12312312", "0213");

    List<String> names = Arrays.asList("Piotr", "Jan", "Ala");

    for (int i = 0; i < names.size(); i++) {
      String element = names.get(i);
      System.out.println(element);
    }

    System.out.println("Petla for each ..........");
    for (String s : names) {
      System.out.println(s);
    }

    // "Ala"
    // "ma"
    // "kota"


    System.out.println("Z uzyciem iteratora:.....");
    Iterator<String> iterator = names.iterator();
    while (iterator.hasNext()) {
      String s = iterator.next();
    }

    // z uzyciem wlasnego iteratora
    MyCollection imiona = new MyCollection();
    imiona.addElement("Piotr");
    imiona.addElement("Pawel");
    imiona.addElement(null);
    imiona.addElement("Karolina");

    pl.sda.poznan.iterator.Iterator<String> imionaIterator = imiona.getIterator();
    while (imionaIterator.hasNextElement()) {
      String elem = imionaIterator.getNextElement();
      System.out.println(elem);
    }

    MyIterableCollection collection = new MyIterableCollection();

    for (String s : collection) {

    }

  }
}
