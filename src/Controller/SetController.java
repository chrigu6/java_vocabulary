package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import Model.Language;
import Model.Set;
import View.CardDialogFrame;
import View.CreateSetFrame;
import View.SetFrame;
import View.VocabularyFrame;

public class SetController {
	private SetFrame setFrame;
	private Set set;
	private JFrame parentFrame;

	
	public SetController(Set set, JFrame parentFrame)
	{
		this.set = set;
		this.parentFrame = parentFrame;	
		this.setFrame = new SetFrame(this.set);
		this.addSetFormActionListeners();

	}


	private void addSetFormActionListeners() {
		WindowListener exitListener = new WindowAdapter() {

    	    @Override
    	    public void windowClosing(WindowEvent e) {
    	        parentFrame.setEnabled(true);
    	    }
    	};
    	
    	setFrame.addWindowListener(exitListener);
    	this.setFrame.addCardButtonClickedActionListener(new AddCardButtonClickedActionListener());
	}
	
	//ActionListeners
	
	class AddCardButtonClickedActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			setFrame.setEnabled(false);
			CardController cardController = new CardController(set, setFrame);
		}
	}
	
}
