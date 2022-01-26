package nl.openvalue.samples.designpatterns;

public class BuilderPattern {
	
	public static class Persoon {
		
		private String naam;
		private int leeftijd;
		
		private Persoon(String naam, int leeftijd) {
			this.naam = naam;
			this.leeftijd = leeftijd;
		}
		
		/* Typisch alleen getters */
		
		public static class Builder {
			
			private String naam;
			private int leeftijd;
			
			/* Of setNaam(...) */
			public Builder naam(String naam) {
				this.naam = naam;
				return this;
			}
			
			public Builder leeftijd(int leeftijd) {
				this.leeftijd = leeftijd;
				return this;
			}
			
			public Persoon build() {
				return new Persoon(naam, leeftijd);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Persoon p = new Persoon.Builder()
				.naam("Kevin")
				.leeftijd(27)
				.build();
		
		
	}

}
