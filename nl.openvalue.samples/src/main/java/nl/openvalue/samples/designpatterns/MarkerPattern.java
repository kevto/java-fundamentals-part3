package nl.openvalue.samples.designpatterns;

public class MarkerPattern {

	public static interface Dier {
		String soort();
	}

	public static class Kat implements Dier {

		public String soort() {
			return "Kat";
		}

	}

	public static class HuisKat extends Kat {
		@Override
		public String soort() {
			return "Huiskat";
		}
	}

	public static void main(String[] args) {
//		Dier huiskat = new HuisKat();
		Kat kat = new Kat();
		System.out.println(kat.soort());

		System.out.println(kat.getClass().isAssignableFrom(Dier.class));
		System.out.println(Dier.class.isAssignableFrom(String.class));
	}

}
