package pl.sda.poznan.files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * Napisz program do zarządzania katalogami. Zaimplementuj funkcjonalności wyświetlania katalogów,
 * zmiany katalogu, tworzenia oraz usuwania plików z katalogów. Program powinien rozpocząć swoje
 * działanie w katalogu domowym użytkownika
 */
public class Program {

  public static void fileIntro() {
    File plik = new File("plik.txt");

    if (plik.exists()) {
      System.out.println("Plik istnieje - usuwamy");
      plik.delete();
    }
    try {
      boolean isCreated = plik.createNewFile();
      System.out.println(isCreated ? "Utworzono plik" : "Nie utworzono pliku");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Wypisuje pliki z katalogu C:\Program Files
  public static void listFiles(File file) {
    File[] subFiles = file.listFiles();
    for (File subFile : subFiles) {
      System.out.println("File name | r | w | x | isFile | isDirectory");
      System.out.println(
          String.format("%s| %s | %s | %s | %s | %s",
              subFile.getName(),
              subFile.canRead(),
              subFile.canWrite(),
              subFile.canExecute(),
              subFile.isFile(),
              subFile.isDirectory()
          ));
      System.out.println("--------------------------------------");
    }
  }

  public static void main(String[] args) {
    String property = System.getProperty("user.home");
    File currentFile = new File(property);

    boolean exit = false;
    Scanner scanner = new Scanner(System.in);
    while (!exit) {
      System.out.println(currentFile.getAbsolutePath() + ">");
      System.out.println("ls - wyswietla katalogi");
      System.out.println("mkdir nazwa -> tworzy katalog o danej nazwie");
      String operation = scanner.nextLine();
      String[] split = operation.split(" ");
      switch (split[0]) {
        case "ls": {
          listFiles(currentFile);
          break;
        }
        case "mkdir": {
          System.out.println("Tworze katalog......");
          String catalogName = split[1];
          File newCatalog = new File(currentFile.getAbsolutePath() + "\\" + catalogName);
          boolean result = newCatalog.mkdir();
          System.out.println(result ? "Utworzono katalog" : "Nie utworzono katalogu");
          break;
        }
        default: {
          System.out.println("Nieznane polecenie");
          break;
        }
      }
    }
  }
}
