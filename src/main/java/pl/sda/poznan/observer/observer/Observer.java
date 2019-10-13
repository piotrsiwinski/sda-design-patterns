package pl.sda.poznan.observer.observer;

public interface Observer<T>{
  void handle(PropertyChangedEventArgs<T> args);
}
