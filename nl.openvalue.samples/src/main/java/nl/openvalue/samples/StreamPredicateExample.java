package nl.openvalue.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPredicateExample {

    public static class Persoon {
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

    public static void main(String[] args) {
        List<Persoon> personen = new ArrayList<>();
        personen.add(new Persoon("kevin", 16));
        personen.add(new Persoon("sdf", 23));
        personen.add(new Persoon("sdfsdf", 25));
        personen.add(new Persoon("kevisdsdn", 89));
        personen.add(new Persoon("kevidfdfgn", 86));
        personen.add(new Persoon("kevivvvn", 36));

        List<String> personenAsStrings = personen.stream()
                .filter(new Predicate<Persoon>() {
                    @Override
                    public boolean test(Persoon persoon) {
                        return persoon.getLeeftijd() >= 18;
                    }
                })
                .filter((p) -> {
                    return p.getLeeftijd() >= 18;
                })
                .filter(p -> p.getLeeftijd() < 80)
                .map(p -> String.format("%s: %d", p.getNaam(), p.getLeeftijd()))
                .collect(Collectors.toList());

        for (String s : personenAsStrings) {
            System.out.println(s);
        }
    }

}
