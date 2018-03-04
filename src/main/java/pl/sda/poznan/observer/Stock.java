package pl.sda.poznan.observer;

// klasa Stock jest obserwowalna (dajca sie obserwowac)
public class Stock extends Observable<Stock> {

  private String name;
  // pole na zmiane ktorego chcemy reagowac - patrz setter
  private double price;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    //old price zmienna pomocnicza do przechowania aktualnej (starej ceny, sprzed wywoalania settera)
    double oldPrice = this.price;
    // jezeli nowa cena (argument settera) rowna sie starej cenie to nie powiadamiamy
    if (price == oldPrice) {
      return;
    }
    //teraz this.price przechowuje nowa wartosc podana jako argument settera
    // jezeli ceny sie zmienily to ustawiamy nowa wartosc
    this.price = price;
    // i powiadamiamy obserwatorow
    propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
  }

  // wykonuj tylko, jezeli ceny sa rozne
  public void setPriceWithValidation(double price) {
    double oldPrice = price;
    this.price = price;
    if (oldPrice != this.price) {
      propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
    }
  }

  // Alternatywny zapis (jezeli ceny takie same to wroc z funkcji - redukujemy zagniezdzenie
  public void set(double price) {
    if (this.price == price) {
      return;
    }
    double oldPrice = price;
    this.price = price;
    propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
