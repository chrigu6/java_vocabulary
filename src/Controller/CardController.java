package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import Controller.SetController.AddCardButtonClickedActionListener;
import Model.Card;
import Model.Set;
import Model.Word;
import View.CardDialogFrame;
import View.SetFrame;

public class CardController {
	private Set set;
	private SetFrame parentFrame;
	private CardDialogFrame cardFrame;
	
	public CardController(Set set, SetFrame parentFrame)
	{
		this.set = set;
		this.parentFrame = parentFrame;
		this.cardFrame = new CardDialogFrame();
		this.addCardFormActionListeners();
	}
	
	private void addCardFormActionListeners() {
		WindowListener exitListener = new WindowAdapter() {

    	    @Override
    	    public void windowClosing(WindowEvent e) {
    	        parentFrame.setEnabled(true);
    	    }
    	};
    	
    	cardFrame.addWindowListener(exitListener);
    	this.cardFrame.addAddCardButtonClickedActionListener(new AddCardButtonClickedActionListener());
	}
	
	//ActionListeners
	
	class AddCardButtonClickedActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			set.addCard(new Card(set.getFirstLanguage(), set.getSecondLanguage(), new Word(cardFrame.getFirstWord()), cardFrame.getsecondWords()));
			parentFrame.setCards(set.getCards().toArray(new Card[3]));
			cardFrame.dispatchEvent(new WindowEvent(cardFrame, WindowEvent.WINDOW_CLOSING));
		}
	}

}
