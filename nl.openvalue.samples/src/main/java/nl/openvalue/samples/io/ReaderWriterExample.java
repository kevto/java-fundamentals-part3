package nl.openvalue.samples.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ReaderWriterExample {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("logging.txt")) {
            try(PrintStream printStream = new PrintStream(fos)) {
                System.setOut(printStream);

                System.out.println("Hello System.out from file");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
