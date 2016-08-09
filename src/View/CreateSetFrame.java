package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Language;

public class CreateSetFrame extends JFrame {
	
	JLabel nameLabel;
	JTextField nameTextField;
	
	JLabel firstLanguageLabel;
	JComboBox<Language> firstLanguageComboBox;
	JTextField firstLanguageTextField;
	JButton addFirstLanguageButton;
	
	JLabel secondLanguageLabel;
	JComboBox<Language> secondLanguageComboBox;
	JTextField secondLanguageTextField;
	JButton addSecondLanguageButton;
	
	JButton createSetButton;
	
	public CreateSetFrame(String name, ArrayList<Language> languages){		
		super(name);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.nameLabel = new JLabel("Name:", JLabel.LEFT);
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.nameLabel, c);
		this.nameTextField = new JTextField("Enter a name ...");
		c.gridx = 1;
		c.gridy = 0;
		this.add(this.nameTextField, c);
		
		
		this.firstLanguageLabel = new JLabel("Choose a Language:");
		c.gridx = 0;
		c.gridy = 1;
		this.add(this.firstLanguageLabel, c);
		this.firstLanguageComboBox = new JComboBox<Language>();
		c.gridx = 1;
		c.gridy = 1;
		this.firstLanguageComboBox.setModel(new DefaultComboBoxModel<Language>(languages.toArray(new Language[3])));
		this.add(this.firstLanguageComboBox, c);
		this.firstLanguageTextField = new JTextField("Enter a new Language ...");
		c.gridx = 2;
		c.gridy = 1;
		this.add(this.firstLanguageTextField, c);
		this.addFirstLanguageButton = new JButton("Add new Language");
		c.gridx = 3;
		c.gridy = 1;
		this.add(this.addFirstLanguageButton,c);
		
		this.secondLanguageLabel = new JLabel("Choose a Language:");
		c.gridx = 0;
		c.gridy = 2;
		this.add(this.secondLanguageLabel, c);
		this.secondLanguageComboBox = new JComboBox<Language>();
		c.gridx = 1;
		c.gridy = 2;
		this.add(this.secondLanguageComboBox, c);
		this.secondLanguageTextField = new JTextField("Enter a new Language ...");
		c.gridx = 2;
		c.gridy = 2;
		this.secondLanguageComboBox.setModel(new DefaultComboBoxModel<Language>(languages.toArray(new Language[3])));
		this.add(this.secondLanguageTextField, c);
		this.addSecondLanguageButton = new JButton("Add new Language");
		c.gridx = 3;
		c.gridy = 2;
		this.add(this.addSecondLanguageButton, c);
		
		this.createSetButton = new JButton("Create Set");
		c.gridx = 0;
		c.gridy = 3;
		this.add(this.createSetButton, c);
		
		this.setSize(400, 400);
		this.setVisible(true);
	}	
	
	//ActionListeners
	public void addFirstLanguageButtonClickedListener(ActionListener listener)
	{
		this.addFirstLanguageButton.addActionListener(listener);
	}
	
	public void addSecondLanguageButtonClickedListener(ActionListener listener)
	{
		this.addSecondLanguageButton.addActionListener(listener);
	}
	
	public void addCreateSetButtonClickedListener(ActionListener listener)
	{
		this.createSetButton.addActionListener(listener);
	}
	
	//getters
	public String getFirstLanguageName() {
		return this.firstLanguageTextField.getText();
	}
	
	public String getSecondLanguageName()
	{
		return this.secondLanguageTextField.getText();
	}

	public void setLanguages(Language[] array) {
		this.firstLanguageComboBox.setModel(new DefaultComboBoxModel<Language>(array));
		this.secondLanguageComboBox.setModel(new DefaultComboBoxModel<Language>(array));
	}

	public String getSetName() {
		return this.nameTextField.getText();
	}

	public Language getFirstLanguage() {
		return (Language) this.firstLanguageComboBox.getSelectedItem();
	}

	public Language getSecondLanguage() {
		return (Language) this.secondLanguageComboBox.getSelectedItem();
	}
	
	
}
