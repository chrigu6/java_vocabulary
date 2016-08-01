package View;

import javax.swing.JFrame;

import Model.Set;

public class SetFrame extends JFrame {
	
	private Set set;
	
	public SetFrame(Set set)
	{
		super(set.getName());
		this.set = set;
		this.setVisible(true);
		
	}

}
