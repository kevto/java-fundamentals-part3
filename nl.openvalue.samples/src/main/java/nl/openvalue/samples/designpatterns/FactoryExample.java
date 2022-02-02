package nl.openvalue.samples.designpatterns;

public class FactoryExample {

    public interface Voertuig {
        int getZitplaatsen();
    }

    public static class Fiets implements Voertuig {

        @Override
        public int getZitplaatsen() {
            return 2;
        }
    }

    public static class Tram implements Voertuig {

        @Override
        public int getZitplaatsen() {
            return 48;
        }
    }

    public interface VoertuigFactory {
        Voertuig createFiets();
        Voertuig createTram();

        static VoertuigFactory create() {
            return new VoertuigFactoryImpl();
        }
    }

    public static class VoertuigFactoryImpl implements VoertuigFactory {

        public Voertuig createFiets() {
            return new Fiets();
        }

        public Voertuig createTram() {
            return new Tram();
        }
    }

    public static void main(String[] args) {
        VoertuigFactory factory = VoertuigFactory.create();
        System.out.println(factory.getClass().getSimpleName());

        Voertuig fiets = factory.createFiets();
        System.out.println(fiets.getClass().getSimpleName());

        Voertuig tram = factory.createTram();
        System.out.println(tram.getClass().getSimpleName());
    }

}
