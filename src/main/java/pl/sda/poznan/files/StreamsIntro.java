package pl.sda.poznan.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

public class StreamsIntro {

  public static void main(String[] args) throws Exception {

    File plik = new File("plik.txt");
    InputStream inputStream = new FileInputStream(plik);

    byte[] buffer = new byte[255];
    int read = inputStream.read(buffer);
    inputStream.close();

    char[] charBuffer = new char[255];
    FileReader reader = new FileReader(plik);
    reader.read(charBuffer);
    
  }
}
