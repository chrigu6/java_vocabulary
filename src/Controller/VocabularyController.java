package Controller;

import View.CreateSetFrame;
import View.SetFrame;
import View.VocabularyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;


import Model.Language;
import Model.Set;


public class VocabularyController {
	private VocabularyFrame vocabularyFrame;
	private CreateSetFrame createSetFrame;
	private SetFrame setFrame;
	private ArrayList<Set> sets;
	private ArrayList<Language> languages;
	
	public VocabularyController()
	{
		this.vocabularyFrame = new VocabularyFrame("Learn your Words");
		this.sets = new ArrayList<Set>();
		this.languages = new ArrayList<Language>();
		this.addVocabularyFormActionListeners();
	}

	private void addVocabularyFormActionListeners() {
		this.vocabularyFrame.addNewSetButtonClickedActionListener(new CreateSetButtonActionListener());
		this.vocabularyFrame.addOpenSetButtonClickedActionListener(new OpenSetButtonActionListener());
		this.vocabularyFrame.addLoadMenuItemClicked(new LoadMenuItemActionListener());
	}
	
	//ActionListener for the VocabularyForm
	class CreateSetButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	vocabularyFrame.setEnabled(false);
        	createSetFrame = new CreateSetFrame("Create a set", languages);
        	WindowListener exitListener = new WindowAdapter() {

        	    @Override
        	    public void windowClosing(WindowEvent e) {
        	        vocabularyFrame.setEnabled(true);
        	    }
        	};
        	
        	createSetFrame.addWindowListener(exitListener);
        	createSetFrame.addCreateSetButtonClickedListener(new CreateSetButtonClickedActionListener());
        	createSetFrame.addFirstLanguageButtonClickedListener(new AddFirstLanguageButtonActionListener());
        	createSetFrame.addSecondLanguageButtonClickedListener(new AddSecondLanguageButtonActionListener());
        	
        }
	}
	
	class OpenSetButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			vocabularyFrame.setEnabled(false);
			setFrame = new SetFrame(vocabularyFrame.getSelectedSet());
			WindowListener exitListener = new WindowAdapter() {

        	    @Override
        	    public void windowClosing(WindowEvent e) {
        	        vocabularyFrame.setEnabled(true);
        	    }
        	};
        	
        	setFrame.addWindowListener(exitListener);
		}
	}
	
	class LoadMenuItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
        	Serializer serializer = new Serializer();
        	Object[] deserializedData = serializer.deserialize("");
        	sets = (ArrayList<Set>) deserializedData[0];
        	languages = (ArrayList<Language>) deserializedData[1];
        	vocabularyFrame.setSets(sets.toArray(new Set[3]));
        }
	}
	
	//ActionListener for the CreateSetForm
	class AddFirstLanguageButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String languageName = createSetFrame.getFirstLanguageName();
        	languages.add(new Language(languageName));
        	createSetFrame.setLanguages(languages.toArray(new Language[3]));
        }
	}
	
	class AddSecondLanguageButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String languageName = createSetFrame.getSecondLanguageName();
        	languages.add(new Language(languageName));
        	createSetFrame.setLanguages(languages.toArray(new Language[3]));
        }
	}
	
	class CreateSetButtonClickedActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			String setName = createSetFrame.getSetName();
			Language firstLanguage = createSetFrame.getFirstLanguage();
			Language secondLanguage = createSetFrame.getSecondLanguage();
			sets.add(new Set(setName, firstLanguage, secondLanguage));
			vocabularyFrame.setSets(sets.toArray(new Set[3]));
			createSetFrame.dispose();
			vocabularyFrame.setEnabled(true);
		}
	}
	
	public static void main(String[] args)
	{
		VocabularyController controller = new VocabularyController();
	}
	
	
    
	
	

}
