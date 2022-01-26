package nl.openvalue.samples.spi;

public class ChangeImplementationRuntime {
	
	public static void main(String[] args) { 
		Language first = LanguagePicker.getInstance().get();
		System.out.printf("First language: %s, greets: '%s'\n", first.name(), first.greet());
		
		LanguagePicker.getInstance().select("Nederlands");
		Language dutch = LanguagePicker.getInstance().get(); 
		System.out.printf("Dutch language: %s, greets: '%s'\n", dutch.name(), dutch.greet());

		LanguagePicker.getInstance().select("English");
		Language english = LanguagePicker.getInstance().get();
		System.out.printf("English language: %s, greets: '%s'\n", english.name(), english.greet());
		
		try {
			LanguagePicker.getInstance().select("Deutsch");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		Language previous = LanguagePicker.getInstance().get();
		System.out.printf("Previous language: %s, greets: '%s'\n", previous.name(), previous.greet());
	}

}
