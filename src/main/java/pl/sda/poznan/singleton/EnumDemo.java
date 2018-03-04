package pl.sda.poznan.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;

public class EnumDemo {

  public static void main(String[] args) {

    Employee dyrektor = new Employee("Jan", "Nowak", "nowak@gmail.com", 10000D);
    Employee kierownik = new Employee("Jan", "Kowalski", "kowalski@gmail.com", 8000D);

    Company company = new Company();
    company.addEmployee(dyrektor);
    company.addEmployee(kierownik);

    CompanyWriter writer = EnumFactory.INSTANCE.create("enum.xml");

    Class<? extends EnumFactory> aClass = EnumFactory.INSTANCE.getClass();
    Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
    for (Constructor c : declaredConstructors) {
      c.setAccessible(true);
    }

    Constructor<?> declaredConstructor = declaredConstructors[0];
    try {
      Object o = declaredConstructor.newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    writer.write(company);
  }
}
