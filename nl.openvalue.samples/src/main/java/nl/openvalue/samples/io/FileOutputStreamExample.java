package nl.openvalue.samples.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

    public static void main(String[] args) {
        // Define file and create subdirectories
        // if they don't exist, yet.
        File directory = new File("world/");
        if (!directory.exists() && directory.mkdirs()) {
            System.out.println("Sub directories created");
        } else if (!directory.exists()) {
            System.out.println("Failed to create sub directories");
        }

        File txtFile = new File(directory, "hello.txt");
        if (txtFile.exists()) {
            System.out.println("File exists, deleting now");
            if (txtFile.delete()) {
                System.out.println("File successfully deleted");
            } else {
                System.out.println("Failed to delete file");
            }
        } else {
            System.out.println("File doesn't exit yet");
        }

        // Write text to file
        try (FileOutputStream fos = new FileOutputStream(txtFile)) {
            fos.write("Hello World from program".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
