package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import Model.Language;
import Model.Set;
import View.CreateSetFrame;
import View.SetFrame;
import View.VocabularyFrame;


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
		this.load();
	}

	private void addVocabularyFormActionListeners() {
		this.vocabularyFrame.addNewSetButtonClickedActionListener(new CreateSetButtonActionListener());
		this.vocabularyFrame.addOpenSetButtonClickedActionListener(new OpenSetButtonActionListener());
		this.vocabularyFrame.addLoadMenuItemClicked(new LoadMenuItemActionListener());
		this.vocabularyFrame.addSaveMenuItemClicked(new SaveMenuItemActionListener());
		WindowListener exitListener = new WindowAdapter() {

    	    @Override
    	    public void windowClosing(WindowEvent e) {
    	    	save();
    	    }
    	};
    	this.vocabularyFrame.addWindowListener(exitListener);
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
			SetController controller = new SetController(vocabularyFrame.getSelectedSet(), vocabularyFrame);
		}
	}
	
	class LoadMenuItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
        	load();
        }
	}
	
	class SaveMenuItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
        	save();
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

	private void save() {
		Serializer serializer = new Serializer(sets, languages);
    	serializer.serialize("");
	}
	
	private void load()
	{
		Serializer serializer = new Serializer();
    	Object[] deserializedData = serializer.deserialize("");
    	sets = (ArrayList<Set>) deserializedData[0];
    	languages = (ArrayList<Language>) deserializedData[1];
    	vocabularyFrame.setSets(sets.toArray(new Set[3]));
	}

	
}
