package nl.openvalue.samples.spi;

public class DutchLanguage implements Language {

	@Override
	public String name() {
		return "Nederlands";
	}

	@Override
	public String greet() {
		return "Hallo!";
	}

}
