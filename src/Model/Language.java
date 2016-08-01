package Model;

import java.io.Serializable;

public class Language implements Serializable {
	private String language;
	
	//Constructor
	public Language(String language)
	{
		this.language = language;
	}
	
	//getters and setters
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String toString()
	{
		return this.language;
	}
	
	public static void main(String[] args)
	{
		
	}

}
