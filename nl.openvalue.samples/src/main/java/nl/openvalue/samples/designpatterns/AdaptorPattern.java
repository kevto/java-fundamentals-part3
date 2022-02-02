package nl.openvalue.samples.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class AdaptorPattern {

    public interface Job {
        void run();
    }

    public static class Executor {
        private List<Job> jobs;
        public Executor(List<Job> jobs) {
            this.jobs = jobs;
        }

        public void execute() {
            for(Job j : jobs) {
                j.run();
            }
        }
    }

    public static final class Controle {
        public void uitvoeren() {
            System.out.println("voert controle uit");
        }
    }

    public static class ControleJob implements Job {

        private Controle controle;

        public ControleJob(Controle controle) {
            this.controle = controle;
        }

        @Override
        public void run() {
            this.controle.uitvoeren();
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new ControleJob(new Controle()));

        Executor executor = new Executor(jobs);
        executor.execute();
    }

}
