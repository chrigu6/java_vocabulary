package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import Model.Card;
import Model.Set;

public class SetFrame extends JFrame {
	
	private Set set;
	private JList<Card> cardJList;
	private JButton addCardButton;
	
	public SetFrame(Set set)
	{
		super(set.getName());
		this.set = set;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.cardJList = new JList<Card>();
		c.gridx = 0;
		c.gridy = 1;
		this.add(this.cardJList, c);
		
		this.addCardButton = new JButton("Add card");
		c.gridx = 1;
		c.gridy = 1;
		this.add(addCardButton, c);
		
		
		this.setSize(200,200);
		this.pack();
		this.setVisible(true);
		
	}
	
	public void addCardButtonClickedActionListener(ActionListener listener)
	{
		this.addCardButton.addActionListener(listener);
	}

}
