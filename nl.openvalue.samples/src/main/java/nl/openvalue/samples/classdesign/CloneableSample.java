package nl.openvalue.samples.classdesign;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CloneableSample {

	public static class Persoon implements Cloneable {

		private final String naam;
		private final int leeftijd;

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
		protected Object clone() throws CloneNotSupportedException {
			return new Persoon(naam, leeftijd);
		}

		@Override
		public String toString() {
			return String.format("Persoon[naam=%s, leeftijd=%d]", naam, leeftijd);
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Persoon p1 = new Persoon("Kevin", 27);
//		Persoon p2;
//		try {
//			p2 = (Persoon) p1.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//			return;
//		}
//
//		System.out.printf("1 (hash: %d): %s\n", p1.hashCode(), p1);
//		System.out.printf("2 (hash: %d): %s\n", p2.hashCode(), p2);

	}


}
