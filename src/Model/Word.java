package Model;

import java.io.Serializable;

public class Word implements Serializable{
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
	
	public String toString()
	{
		return this.word;
	}
	

}
