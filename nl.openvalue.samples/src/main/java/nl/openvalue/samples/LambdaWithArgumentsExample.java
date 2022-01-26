package nl.openvalue.samples;

public class LambdaWithArgumentsExample {

    public interface Dier {
        void printSoort(String soort);
    }

    public static void main(String[] args) {
        Dier anonymousDier = new Dier() {
            @Override
            public void printSoort(String soort) {
                System.out.println("Anonymous class: " + soort);
            }
        };

        Dier lambdaAnonymousDier = (s) -> { System.out.println("Lambda anonymous class: " + s); };
        Dier lambdaShorterAnonymousDier = s -> System.out.println("Lambda anonymous class (shorter): " + s);

        anonymousDier.printSoort("kat");
        lambdaAnonymousDier.printSoort("hond");
        lambdaShorterAnonymousDier.printSoort("vis");
    }

}
