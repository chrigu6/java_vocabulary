package Controller;

import View.CreateSetFrame;
import View.VocabularyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.Action;

import Model.Language;
import Model.Set;


public class VocabularyController {
	private VocabularyFrame vocabularyFrame;
	private CreateSetFrame createSetFrame;
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
		this.vocabularyFrame.addNewSetButtonClickedActionListerner(new CreateSetButtonActionListener());
	}
	
	//ActionListener for the VocabularyForm
	class CreateSetButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	vocabularyFrame.setEnabled(false);
        	createSetFrame = new CreateSetFrame("Create a set");
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
