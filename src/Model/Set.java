package Model;
import java.util.ArrayList;

public class Set {
	private String name;
	private Language firstLanguage;
	private Language secondLanguage;
	private ArrayList<Card> cards;
	
	//Constructors
	public Set(String name)
	{
		this.name = name;
		
	}
	
	public Set(String name, Language firstLanguage, Language secondLanguage)
	{
		this.name = name;
		this.firstLanguage = firstLanguage;
		this.secondLanguage = secondLanguage;
	}
	
	//Methods
	public void addCard()
	{
		this.cards.add(new Card(this.firstLanguage, this.secondLanguage));
		
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

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

	public ArrayList<Card> getCards() {
		return cards;
	}
}
