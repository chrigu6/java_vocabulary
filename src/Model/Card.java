package Model;
import java.util.ArrayList;

public class Card {
	private Language firstLanguage;
	private Language secondLanguage;
	private Word firstLanguageWord;
	private ArrayList<Word> secondLanguageWords;
	
	//Constructor
	public Card(Language firstLanguage, Language secondLanguage)
	{
		this.firstLanguage = firstLanguage;
		this.secondLanguage = secondLanguage;
	}
	
	//getters and setters
	public Language getFirstLanguage() {
		return firstLanguage;
	}

	public void setFirstLanguage(Language firstLanguage) {
		this.firstLanguage = firstLanguage;
	}

	public Language getSecondLanguage() {
		return secondLanguage;
	}

	public void setSecondLanguage(Language secondLanguage) {
		this.secondLanguage = secondLanguage;
	}

	public Word getFirstLanguageWord() {
		return firstLanguageWord;
	}

	public void setFirstLanguageWord(Word firstLanguageWord) {
		this.firstLanguageWord = firstLanguageWord;
	}

	public ArrayList<Word> getSecondLanguageWords() {
		return secondLanguageWords;
	}

	public void setSecondLanguageWords(ArrayList<Word> secondLanguageWords) {
		this.secondLanguageWords = secondLanguageWords;
	}
}
