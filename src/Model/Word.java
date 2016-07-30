package Model;

public class Word {
	private String word;
	private Language Language;
	
	//Constructor
	public Word(String word)
	{
		this.word = word;
	}
	
	//getters and setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Language getLanguage() {
		return Language;
	}

	public void setLanguage(Language language) {
		Language = language;
	}
	
	

}
