package nl.openvalue.samples.designpatterns;

public class CompositionOverInheritance {
	
	public static class Composition {
	
		public static class Persoon {
			private String naam;
			private int leeftijd;
			
			public Persoon(String naam, int leeftijd) {
				this.naam = naam;
				this.leeftijd = leeftijd;
			}
			
			/* Getters & setters */
		}
		
		public static class Employee {
			private Persoon persoon;
			private float salaris;
			
			public Employee(Persoon persoon, float salaris) {
				this.persoon = persoon;
				this.salaris = salaris;
			}
			
			public Persoon getPersoon() {
				return this.persoon;
			}
		}
	
	}
	
	
	public static class Inheritance {
		
		public static class Persoon {
			private String naam;
			private int leeftijd;
			
			public Persoon(String naam, int leeftijd) {
				this.naam = naam;
				this.leeftijd = leeftijd;
			}
			
			/* Getters & setters */
		}
		
		public static class Employee extends Persoon {
			private float salaris;
			
			public Employee(String naam, int leeftijd, float salaris) {
				super(naam, leeftijd);
				this.salaris = salaris;
			}
			
			/* Alle getters/setters krijg je 'gratis', mits ze public of package level zijn */
		}
	
	}

}
