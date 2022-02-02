package nl.openvalue.samples.designpatterns;

public class FacadePattern {

    public static class Worker implements WorkerFacade {
        public void doWork1() {}
        public void doWork2() {}
        public void doWork3() {}
        public void doWork() {
            doWork1();
        }

        static WorkerFacade createFacade() {
            return new Worker();
        }
    }

    public interface WorkerFacade {
        void doWork();
    }


    public static void main(String[] args) {
        WorkerFacade worker = Worker.createFacade();
        worker.doWork();
    }

}
