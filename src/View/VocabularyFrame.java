package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Model.Set;

public class VocabularyFrame extends JFrame {
	
	Set[] sets;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem loadMenuItem;
	JMenuItem saveMenuItem;
	JList<Set> setJList;
	JButton addNewSetButton;
	JButton openSetButton;
	
	
	public VocabularyFrame(String name)
	{
		super(name);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		this.sets = new Set[0];
		this.setSize(200,200);
		
		this.menuBar = new JMenuBar();
		this.menu = new JMenu("File");
		this.loadMenuItem = new JMenuItem("Load Data");
		this.menu.add(this.loadMenuItem);
		this.saveMenuItem = new JMenuItem("Save Data");
		this.menu.add(this.saveMenuItem);
		this.menuBar.add(this.menu);
		this.add(this.menuBar);
		this.setJList = new JList<Set>();
		c.gridx = 0;
		c.gridy = 1;
		this.add(this.setJList, c);
		
		this.addNewSetButton = new JButton("Add Set");
		c.gridx = 1;
		c.gridy = 1;
		this.add(addNewSetButton, c);
		
		this.openSetButton = new JButton("Open Set");
		c.gridx = 0;
		c.gridy = 2;
		this.add(this.openSetButton, c);
		
		this.pack();
		this.setVisible(true);		
	}
	
	//Action Listeners
	//Menu
	public void addLoadMenuItemClicked(ActionListener listener)
	{
		this.loadMenuItem.addActionListener(listener);
	}
	
	public void addSaveMenuItemClicked(ActionListener listener)
	{
		this.saveMenuItem.addActionListener(listener);
	}
	
	//Buttons
	public void addNewSetButtonClickedActionListener(ActionListener listener)
	{
		this.addNewSetButton.addActionListener(listener);
	}
	
	public void addOpenSetButtonClickedActionListener(ActionListener listener)
	{
		this.openSetButton.addActionListener(listener);
	}

	//getters and setters
	public void setSets(Set[] array) {
		this.setJList.setListData(array);
	}
	
	public Set getSelectedSet()
	{
		return (Set) setJList.getSelectedValue();
	}
}
