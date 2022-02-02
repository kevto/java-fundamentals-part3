package nl.openvalue.samples.io;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesIOExample {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("hello.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
