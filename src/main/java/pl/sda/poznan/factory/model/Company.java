package pl.sda.poznan.factory.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {

  private String name;
  private List<Employee> employees = new ArrayList<>();

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployee(Employee e) {
    this.employees.add(e);
  }
}
