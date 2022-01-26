package nl.openvalue.samples.collections;

import java.util.HashSet;
import java.util.Set;


public class HashCodeSample {

	public static class Persoon {

		private String naam;
		private int leeftijd;

		public Persoon(String naam, int leeftijd) {
			this.naam = naam;
			this.leeftijd = leeftijd;
		}

		public int getLeeftijd() {
			return leeftijd;
		}

		public String getNaam() {
			return naam;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + leeftijd;
			result = prime * result + ((naam == null) ? 0 : naam.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Persoon other = (Persoon) obj;
			if (leeftijd != other.leeftijd)
				return false;
			if (naam == null) {
				if (other.naam != null)
					return false;
			} else if (!naam.equals(other.naam))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("Persoon[naam=%s, leeftijd=%d]", naam, leeftijd);
		}
	}

	public static void main(String[] args) {
		Set<Persoon> personen = new HashSet<>();
		Persoon p1 = new Persoon("Kevin", 27);
		System.out.println(p1.hashCode());
		personen.add(p1);
		personen.add(new Persoon("Piet", 51));
		Persoon p2 = new Persoon("Kevin", 27);
		System.out.println(p2.hashCode());
		personen.add(p2);


		for (Persoon p : personen) {
			System.out.println(p);
		}
	}

}
