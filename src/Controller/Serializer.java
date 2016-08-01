package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.Language;
import Model.Set;

public class Serializer {
	private ArrayList<Language> languages;
	private ArrayList<Set> sets;
	
	public Serializer()
	{
		
	}
	
	
	public Serializer(ArrayList<Set> sets, ArrayList<Language> languages)
	{
		this.sets = sets;
		this.languages = languages;
	}
	
	public void serialize(String path){
		try {
			FileOutputStream fileOut = new FileOutputStream("save.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this.sets);
			out.writeObject(this.languages);
			out.close();
			fileOut.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object[] deserialize(String path)
	{
		try {
			FileInputStream fileIn = new FileInputStream("save.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			this.sets = (ArrayList<Set>) in.readObject();
			this.languages = (ArrayList<Language>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Object[]{this.sets, this.languages};
	}
	

}
