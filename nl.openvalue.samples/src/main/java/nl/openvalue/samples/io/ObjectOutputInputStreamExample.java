package nl.openvalue.samples.io;

import java.io.*;

public class ObjectOutputInputStreamExample {

    public static class Persoon implements Serializable {
        private static final long serialVersionUID = 1245678;

        private String naam;
        private int leeftijd;

        public Persoon(String naam, int leeftijd) {
            this.naam = naam;
            this.leeftijd = leeftijd;
        }

        public String getNaam() {
            return naam;
        }

        public void setNaam(String naam) {
            this.naam = naam;
        }

        public int getLeeftijd() {
            return leeftijd;
        }

        public void setLeeftijd(int leeftijd) {
            this.leeftijd = leeftijd;
        }
    }

    public static class PersoonOutputStream implements Closeable {
        private ObjectOutputStream oos;

        public PersoonOutputStream(FileOutputStream fos) throws IOException {
            this.oos = new ObjectOutputStream(fos);
        }

        public void writePersoon(Persoon persoon) throws IOException {
            System.out.println("Writing persoon: " + persoon.getNaam());
            this.oos.writeObject(persoon);
        }

        @Override
        public void close() throws IOException {
            this.oos.close();
        }
    }

    public static void main(String[] args) {
//        Persoon p = new Persoon("kevin", 27);
//
//        try(FileOutputStream fos = new FileOutputStream("persoon.dat")) {
//            try (PersoonOutputStream oos = new PersoonOutputStream(fos)) {
//                oos.writePersoon(p);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Persoon p = null;
        try (FileInputStream fis = new FileInputStream("persoon.dat")) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                p = (Persoon) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        if (p != null)
            System.out.println(p.getNaam() + " " + p.getLeeftijd());
        else
            System.out.println("Persoon kon niet worden gelezen");
    }

}
