package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class AudioCommand implements ActionListener{

	JToolBar toolbar;
	JButton[] buttons;
	
	public AudioCommand(JToolBar toolbar,JButton[] buttons) {
		this.toolbar = toolbar;
		this.buttons = buttons;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(!toolbar.isEnabled()) {
			toolbar.setEnabled(true);
			toolbar.setVisible(true);
			
			buttons[0].setEnabled(true); 
			buttons[1].setEnabled(true);
			buttons[2].setEnabled(true); 
			buttons[3].setEnabled(true);
			 
		}else {
			toolbar.setEnabled(false);
			toolbar.setVisible(false);
			
			buttons[0].setEnabled(false); 
			buttons[1].setEnabled(false);
			buttons[2].setEnabled(false); 
			buttons[3].setEnabled(false);			
		}
	}

}
