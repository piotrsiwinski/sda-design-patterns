package pl.sda.poznan.chor;

import java.awt.dnd.InvalidDnDOperationException;

// bazowa klasa dla Hanlerow, czylu obiektow umiejacych przetwarzac zadania
// Klasy rozsrzerzajace ta klase sa elementami lancucha zobowiazan
public abstract class PaymentHandler {

  protected PaymentHandler nextHandler;

  public void setNextHandler(PaymentHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  // sprawdzic czy mozemy przetworzyc zadanie, jesli nie to przekazac wyzej
  // wzdluz lancucha zobowiazan
  public void processPayment(BankAccount bankAccount, double amount) {
    // jezeli dany handler umie obsluzyc zadanie (canHandle zwraca true)
    // to wykunuje metode obslugi zadania
    // w przeciwnym przypadku, sprawdza, czy jest kolejny handler,
    // jesli tak to przekazuje zadanie wyzej, kolejny handler znowu sprawdzi czy umie to zrobic itd
    if (canHandlePayment(amount)) {
      handle(bankAccount, amount);
    } else if (nextHandler != null) {
      nextHandler.processPayment(bankAccount, amount);
    } else {
      throw new InvalidDnDOperationException(
          "Nie jestem w stanie obsluzyc zadania. Kwota zbyt duza ");
    }
  }

  private boolean canHandlePayment(double amount) {
    return amount < getMaxPrice();
  }

  // abstrakcyjna metoda
  // dlatego, ze na tym etapie jeszcze nie wiemy jak przetwarzac platnosc
  protected abstract void handle(BankAccount account, double amount);

  // Metoda zwraca maksymalna kwote jaka moze obsluzyc dana metoda (np. 50 zl dla zbizeniowej, 500 dla pin)
  protected abstract double getMaxPrice();

}
