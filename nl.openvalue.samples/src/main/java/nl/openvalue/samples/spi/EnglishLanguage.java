package nl.openvalue.samples.spi;

public class EnglishLanguage implements Language {

	@Override
	public String name() {
		return "English";
	}

	@Override
	public String greet() {
		return "Hi!";
	}

}
