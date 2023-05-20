package commands;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Document;

public class PlayAudio implements ActionListener {

	private static PlayAudio instance;
	private Document document;
	private ReplayManager replayManager;
	
	public static JTextArea textArea;
	public static JTextField[] txtfields;
	
	
	public PlayAudio(JTextArea textArea,JTextField[] txtfields) {
		PlayAudio.textArea = textArea;
		PlayAudio.txtfields = txtfields;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		document = Document.getInstance();
		replayManager = ReplayManager.getInstance();
		
		if(txtfields[0].getText().equals("") && txtfields[1].getText().equals("")) {
			
			String txt = textArea.getText();
			String[] lines1 = txt.split("\n");
			
			System.out.println("PlayContnents...");
			document.playContnents(textArea);
			
			if(replayManager.isActionRecording()) {				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			    LocalDateTime now = LocalDateTime.now();  
			    String time = dtf.format(now).toString();
			    
			    String[] dateTime = time.split(" ");
			
			    replayManager.addCommand(PlayAudio.getInstance());
			    replayManager.Recording(dateTime[0], dateTime[1], document.fileName, 0, lines1.length, textArea);
			 
			}
		}
		else {
			System.out.println("Playing certain lines...");
			
			
			String txt = textArea.getText();
			String[] lines1 = txt.split("\n");
			
			int start = Integer.parseInt(txtfields[0].getText());
			int stop = Integer.parseInt(txtfields[1].getText());
			if (start < 0 || stop > lines1.length) {
				System.out.println("Index lines out of bounds. File ends at line "+lines1.length);
				JOptionPane.showMessageDialog(null, "Index lines out of bounds. File ends at line "+lines1.length);
			}else
			{
				document.playLine(textArea, start, stop);
				
				if(replayManager.isActionRecording()) {				
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				    LocalDateTime now = LocalDateTime.now();  
				    String time = dtf.format(now).toString();
				    
				    String[] dateTime = time.split(" ");
				
				    replayManager.addCommand(PlayAudio.getInstance());
				    replayManager.Recording(dateTime[0], dateTime[1], document.fileName, start, stop, textArea);
				 
				}
			}
		}
	}
	
	public static PlayAudio getInstance(){
		if(instance == null)
			instance = new PlayAudio(textArea,txtfields);
		return instance;
	}
}