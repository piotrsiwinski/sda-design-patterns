package pl.sda.poznan.builder;

import java.time.LocalDate;
import pl.sda.poznan.builder.Reservation.ReservationBuilder;

public class Program {

  public static void main(String[] args) {

    ReservationBuilder builder = Reservation.builder()
        .price(20d);

    builder.city("Poznan");

    builder.headcount(20);

    Reservation res = Reservation.builder()
        .headcount(100)
        .city("Wroclaw")
        .date(LocalDate.now())
        .price(29)
        .build();

    String toParse = "Date, 2018-02-12, Headcount, 250, City, Poznan, Price, 100";
    Reservation myReservation = ReservationParser.parse(toParse);
    System.out.println(myReservation);
  }
}