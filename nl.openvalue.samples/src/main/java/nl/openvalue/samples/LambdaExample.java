package nl.openvalue.samples;

public class LambdaExample {

    public static void main(String[] args) {
        Runnable anonymousClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class");
            }
        };

        Runnable lambdaAnonymousClass = () -> {
            System.out.println("Hello from lambda anonymous class");
        };

        anonymousClass.run();
        lambdaAnonymousClass.run();

        System.out.println("anonymousClass: " + anonymousClass.getClass());
        System.out.println("lambdaAnonymousClass: " + lambdaAnonymousClass.getClass());
    }

}
