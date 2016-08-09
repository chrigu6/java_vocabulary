package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Card;

public class CardDialogFrame extends JFrame {
	private JLabel firstWordLabel;
	private JLabel secondWordLabel;
	private JTextField firstWordTextField;
	private ArrayList<JTextField> secondWordTextFields;
	
	private JButton addWordButton;
	private JButton addCardButton;
	private int secondWordPositionX = 1;
	private int secondWordPositionY = 1;
	GridBagConstraints c = new GridBagConstraints();
	
	
	public CardDialogFrame()
	{
		super("Create a Card");
		this.setLayout(new GridBagLayout());
		this.setSize(200, 200);
		
		
		
		this.firstWordLabel = new JLabel("First word: ");
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.firstWordLabel, c);
		
		this.firstWordTextField = new JTextField("Enter a word: ");
		c.gridx = 1;
		c.gridy = 0;		
		this.add(this.firstWordTextField, c);
		
		this.secondWordLabel = new JLabel("Second word: ");
		c.gridx = 0;
		c.gridy = 1;
		this.add(this.secondWordLabel, c);
		
		this.secondWordTextFields = new ArrayList<JTextField>();
		this.secondWordTextFields.add(new JTextField("Enter a word"));
		c.gridx = 1;
		c.gridy = 1;
		this.add(this.secondWordTextFields.get(0), c);
		
		this.addWordButton = new JButton("Add another word");
		c.gridx = 2;
		c.gridy = 1;
		this.add(this.addWordButton, c);
		this.addWordButton.addActionListener(new AddWordButtonClickedActionListener());
		
		this.addCardButton = new JButton("Add card");
		c.gridx = 0;
		c.gridy = 2;		
		this.add(this.addCardButton, c);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	class AddWordButtonClickedActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			secondWordTextFields.add(new JTextField("Enter another word"));
			secondWordPositionY++;
			c.gridx = secondWordPositionX;
			c.gridy = secondWordPositionY;
			CardDialogFrame.this.add(secondWordTextFields.get(secondWordTextFields.size()-1),c);
			CardDialogFrame.this.pack();		
		}
		
	}
	
	//
	public String getFirstWord()
	{
		return this.firstWordTextField.getText();
	}
	
	public String[] getsecondWords()
	{
		String[] result = new String[this.secondWordTextFields.size()];
		
		int i = 0;
		
		for (JTextField textField : this.secondWordTextFields)
		{
			result[i] = textField.getText();
			i++;
		}
		
		return result;
		
	}
	
	//ActionListeners
	public void addAddCardButtonClickedActionListener(ActionListener listener)
	{
		this.addCardButton.addActionListener(listener);
	}
	
	
	
	
}
