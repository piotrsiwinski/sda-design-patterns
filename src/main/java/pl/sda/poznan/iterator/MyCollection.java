package pl.sda.poznan.iterator;

public class MyCollection implements Iterable<String> {

  private int index = 0;
  private String[] elements = new String[10];

  public void addElement(String e) {
    if (index < elements.length) {
      elements[index++] = e;
    }
  }

  @Override
  public Iterator<String> getIterator() {
    return new Iterator<String>() {
      private int iteratorIndex = 0;

      @Override
      public String getNextElement() {
        if (!hasNextElement()) {
          throw new ArrayIndexOutOfBoundsException();
        }
        return elements[iteratorIndex++];
      }

      @Override
      public boolean hasNextElement() {
        if (iteratorIndex >= elements.length) {
          return false;
        }
        return elements[iteratorIndex] != null;
      }
    };
  }


  private class MyCollecctionIterator implements Iterator<String> {

    private int iteratorIndex = 0;

    @Override
    public String getNextElement() {
      if (!hasNextElement()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      return elements[iteratorIndex++];
    }

    @Override
    public boolean hasNextElement() {
      // jezeli doszliscmy do konca tablicy to nie ma kolejnego elementu
      if (iteratorIndex >= elements.length) {
        return false;
      }
      // jezeli są elementy w kolekcji to pobieramy element
      String elem = elements[iteratorIndex];
      // zwracamy wynik operacji
      // czy element jest rozny nullem
      // jezeli jest rozny to znaczy ze mamy element w kolekcji
      return elem != null;
    }
  }
}
