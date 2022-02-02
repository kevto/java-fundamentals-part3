package nl.openvalue.samples.spi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class LanguagePicker {

	private static LanguagePicker INSTANCE;
	private final Map<String, Language> languages;
	private Language selected;

	private LanguagePicker(Language selected, Map<String, Language> languages) {
		this.selected = selected;
		this.languages = languages;
	}

	public static LanguagePicker getInstance() {
		if (INSTANCE != null)
			return INSTANCE;

		Map<String, Language> languages = new HashMap<>();
		Language selected = null;

		ServiceLoader<Language> sl = ServiceLoader.load(Language.class);
		for(Language l : sl) {
			if (selected == null) {
				selected = l;
			}
			languages.put(l.name(), l);
		}

		INSTANCE = new LanguagePicker(selected, languages);
		return INSTANCE;
	}

	public void select(String name) {
		Language l = languages.get(name);
		if (l == null) {
			throw new IllegalStateException(String.format("%s: language doesn't exist", name));
		}
		selected = l;
	}

	public Language get() {
		return selected;
	}
}
