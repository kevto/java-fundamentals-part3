package nl.openvalue.samples.io;

import java.io.Console;
import java.util.Scanner;

public class ConsoleExample {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

        Console console = System.console();

        System.out.println("Typ maar iets in:");
        String input = console.readLine();
        System.out.println("Dit was jouw input: " + input);
        char[] password = console.readPassword();
        System.out.println("Wachtwoord:" + new String(password));
    }

}
