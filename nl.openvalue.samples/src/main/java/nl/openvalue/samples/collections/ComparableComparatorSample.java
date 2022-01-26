package nl.openvalue.samples.collections;

import java.util.*;

public class ComparableComparatorSample {

	public static class Persoon implements Comparable<Persoon> {

		private String naam;
		private int leeftijd;

		public Persoon(String naam, int leeftijd) {
			this.naam = naam;
			this.leeftijd = leeftijd;
		}

		@Override
		public int compareTo(Persoon p) {
			if (this.leeftijd > p.getLeeftijd()) {
				return 1;
			} else if (this.leeftijd < p.getLeeftijd()) {
				return -1;
			} else {
				return 0;
			}
		}

		public int getLeeftijd() {
			return leeftijd;
		}

		public String getNaam() {
			return naam;
		}

		@Override
		public String toString() {
			return String.format("Persoon[naam=%s, leeftijd=%d]", naam, leeftijd);
		}
	}

	public static class ReversePersoonComparator implements Comparator<Persoon> {

		@Override
		public int compare(Persoon p1, Persoon p2) {
			if (p1.getLeeftijd() < p2.getLeeftijd()) {
				return 1;
			} else if (p1.getLeeftijd() > p2.getLeeftijd()) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	public static void main(String[] args) {
		List<Persoon> personen = new ArrayList<>();
		personen.add(new Persoon("Kevin", 27));
		personen.add(new Persoon("Jan", 56));
		personen.add(new Persoon("Piet", 18));
		personen.add(new Persoon("Bryan", 27));

		System.out.println("Sorteren op leeftijd van laag naar hoog:");
		Collections.sort(personen);
		for(Persoon p : personen) {
			System.out.println(p);
		}

		System.out.println("\nSorteren op leeftijd van hoog naar laag:");
		Collections.sort(personen, new ReversePersoonComparator());
		for(Persoon p : personen) {
			System.out.println(p);
		}

	}

}
