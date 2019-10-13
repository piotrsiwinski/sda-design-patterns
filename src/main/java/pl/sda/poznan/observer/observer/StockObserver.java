package pl.sda.poznan.observer.observer;

import pl.sda.poznan.observer.subject.Stock;

public class StockObserver implements Observer<Stock> {

  private Stock stockToObserve;

  public StockObserver(Stock stockToObserve) {
    this.stockToObserve = stockToObserve;
    this.stockToObserve.subscribe(this);
  }

  @Override
  public void handle(PropertyChangedEventArgs<Stock> args) {
    //tutaj logika przetwarzania zdarzenia
    // np wyslanie maila powiadamiajacego
    System.out.println("Wartosc sie zmienila: " + args.getPropertyName());
    System.out.println("Stara wartosc: " + args.getOldValue());
    System.out.println("Nowa wartosc: " + args.getNewValue());
  }
}
