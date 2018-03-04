package pl.sda.poznan.observer;

public class Program {

  public static void main(String[] args) {
    Stock stock = new Stock();
    stock.setPrice(10);
    new StockObserver(stock);

    // inne akcje


    // symulacja dzialania programu
    stock.setPrice(20);
  }
}
