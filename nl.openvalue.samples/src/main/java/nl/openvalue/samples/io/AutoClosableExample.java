package nl.openvalue.samples.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AutoClosableExample {

    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            // Openen van input stream.
            fis = new FileInputStream(new File("hello.txt"));

            // TODO Data lezen vanuit het bestand
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (FileInputStream fis2 = new FileInputStream("hello.txt")) {
            // TODO Lees van data het bestand
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }



    }

}
