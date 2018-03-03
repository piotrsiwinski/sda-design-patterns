package pl.sda.poznan.factory;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;
import pl.sda.poznan.factory.writer.TxtCompanyWriter;
import pl.sda.poznan.factory.writer.XmlCompanyWriter;

public class App {

  // utworz klase Employee przech dane o pracownikach
  //imie, nazwisko, email, salary
  // utworz klase Company
  // jak zareprezentwoac fakt, ze firma ma pracownikow??


  public static void main(String[] args) {
    Employee dyrektor = new Employee("Jan", "Nowak", "nowak@gmail.com", 10000D);
    Employee kierownik = new Employee("Jan", "Kowalski", "kowalski@gmail.com", 8000D);

    Company company = new Company();
    company.addEmployee(dyrektor);
    company.addEmployee(kierownik);

    CompanyWriter writer =new XmlCompanyWriter("firma.xml");
    writer.write(company);
  }
}
