package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Playground {

  public static void main(String[] args) {
    Person student = new Person("Jan", "Kowalski", 20);
    Person kierownik = new Person("Adam", "Nowak", 25);
    Person dyrektor = new Person("Alina", "Adamiak", 30);

    List<Person> people = Arrays.asList(student, kierownik, dyrektor);
    // sortowanie z uzyciem Collections.sort
    Collections.sort(people);
    people.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

//    int compare(T o1, T o2);
    people.sort((person1, person2) -> person1.getName().compareTo(person2.getName()));

//    boolean test(T t);

    Stream<Person> personStream = people.stream()
        .filter(p -> p.getAge() > 22)
        .filter(p -> p.getName().startsWith("A"));

    //pobrac kolejne parametry
    List<Person> collect = personStream.collect(Collectors.toList());

  }
}
