package commands;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class CommandsFactory {

	public CommandsFactory() {}
	
	public ActionListener createCommand(String s,String en, JTextArea textArea, JToolBar toolbar,JButton[] buttons,JTextField[] txtfields)
	{
		if(s.equals("OpenDocument")) {
			return new OpenDocument(en, textArea);
		}
		else if(s.equals("CloseDocument")) {
			return new CloseDocument(textArea);
		}
		else if(s.equals("SaveDocument")) {
			return new SaveDocument(en, textArea);
		}
		else if(s.equals("AudioCommand")) 
		{
			return new AudioCommand(toolbar,buttons);
			
		}else if(s.equals("PlayAudio")) 
		{
			return new PlayAudio(textArea,txtfields);
			
		}
		else if(s.equals("ReplayAudio")) 
		{
			return new ReplayManager();
			
		}
		else if(s.equals("RecordAudio")) 
		{
			return new RecordAudio();
			
		}
		else if(s.equals("ConfigureAudio")) 
		{
			return new ConfigureAudio();
			
		}else {
			return null;
		}
	}
}
