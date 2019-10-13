package pl.sda.poznan.observer.subject;

import pl.sda.poznan.observer.observer.Observer;
import pl.sda.poznan.observer.observer.PropertyChangedEventArgs;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

  // lista obserwatorow
  private List<Observer<T>> observers = new ArrayList<>();

  //metoda dodajaca nowego obserwatora
  public void subscribe(Observer<T> observer) {
    this.observers.add(observer);
  }

  // metoda ktora powiadamia  wszystkich obserwatorow po kolei o wydarzeniu
  protected void propertyChanged(PropertyChangedEventArgs<T> eventArgs) {
    for (Observer<T> o : observers) {
      o.handle(eventArgs);
    }
  }
}
