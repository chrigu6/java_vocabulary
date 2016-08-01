package View;

import Model.Set;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class VocabularyFrame extends JFrame {
	
	Set[] sets;
	JList<Set> setJList;
	JButton addNewSetButton;
	
	
	public VocabularyFrame(String name)
	{
		super(name);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.sets = new Set[0];
		this.setSize(200,200);
		
		this.setJList = new JList<Set>(sets);
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.setJList, c);
		
		this.addNewSetButton = new JButton("Add Set");
		c.gridx = 1;
		c.gridy = 0;
		this.add(addNewSetButton, c);
		
		this.setVisible(true);
		
		
		
		
	}
	

	public void addNewSetButtonClickedActionListerner(ActionListener listener)
	{
		this.addNewSetButton.addActionListener(listener);
	}


	public void setSets(Set[] array) {
		this.setJList.setListData(array);
	}
}
