package nl.openvalue.samples.designpatterns;

public class FactoryMethodPattern {

    public static class Worker2{
        private String beschrijving;

        private Worker2(String beschrijving) {
            validate(beschrijving);
            this.beschrijving = beschrijving;
        }

        private static void validate(String beschrijving) {
            if (beschrijving == null)
                throw new NullPointerException();
            if (beschrijving.isBlank())
                throw new IllegalArgumentException("beschrijving == blank");
        }

        public static Worker2 create(String beschrijving) {
            if (beschrijving == null)
                throw new NullPointerException();
            if (beschrijving.isBlank())
                throw new IllegalArgumentException("beschrijving == blank");

            String b = ":: " + beschrijving;
            return new Worker2(b);
        }
    }

    public interface Worker {
        void run();

        static Worker createWorker() {
            return new WorkerImpl2();
        }
    }

    public static class WorkerImpl implements Worker {
        @Override
        public void run() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    public static class WorkerImpl2 implements Worker {
        @Override
        public void run() {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        Worker worker = Worker.createWorker();
        worker.run();

        Worker2 worker2 = Worker2.create(" ");
    }

}
