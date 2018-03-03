package pl.sda.poznan.singleton;

import pl.sda.poznan.factory.Factory;
import pl.sda.poznan.factory.writer.CompanyWriter;
import pl.sda.poznan.factory.writer.TxtCompanyWriter;
import pl.sda.poznan.factory.writer.XmlCompanyWriter;

public class SingleCompanyWriterFactory implements Factory<String, CompanyWriter> {

  // reczne utworzenie instacji
  // jedyne wywolanie konstruktora
  private final static SingleCompanyWriterFactory INSTANCE = new SingleCompanyWriterFactory();

  //prywatny konstruktor, zeby wylaczyc na zewnatrz mozliwosc tworzenia obiektu
  private SingleCompanyWriterFactory() {
  }

  //metoda dostepowa do jedynej instancji
  public static SingleCompanyWriterFactory getInstance() {
    return INSTANCE;
  }

  @Override
  public CompanyWriter create(String key) {
    if (key.endsWith(".txt")) {
      return new TxtCompanyWriter(key);
    } else if (key.endsWith(".xml")) {
      return new XmlCompanyWriter(key);
    }
    return null;
  }
}
