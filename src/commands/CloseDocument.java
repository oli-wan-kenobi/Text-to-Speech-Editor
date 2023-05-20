package commands;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Document;

public class CloseDocument implements ActionListener {
	
	private JTextArea textArea;
	private Document document;
	
	public CloseDocument(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String file_to_text = textArea.getText();
		
		if(file_to_text.length() > 0)
		{
			document = Document.getInstance();
			if(document.contents != null) 
			{				
				System.out.println("---------");
				System.out.println(texttoArraylist(file_to_text));
				System.out.println(document.contents);
				System.out.println("---------");
				if(!(document.contents).equals(    texttoArraylist(file_to_text)    )) {
					if(!document.saved) {
						System.out.println("File is still in edditing mode");				
						
						int i = JOptionPane.showConfirmDialog(null, "You are about to close a file.\nDo you want to save changes?","File unsaved",JOptionPane.YES_NO_OPTION);
						
						if((i == 1)) {
							textArea.setText("");
							document.close();
						}
						else if((i == 0) || (i == -1)){
							;
						}
					}
					else {
						textArea.setText("");
						document.close();
						
						System.out.println("File closed!");
					}
				}
				else {
					textArea.setText("");
					document.close();
					
					System.out.println("File closed!");
				}
			}
			else {
				int i = JOptionPane.showConfirmDialog(null, "You are about to close a file.\nDo you want to save changes?","File unsaved",JOptionPane.YES_NO_OPTION);
				
				if((i == 1)) {
					textArea.setText("");
					document.close();
				}
				else if((i == 0) || (i == -1)){
					;
				}
			}
		}
	}
	
	private ArrayList<String> texttoArraylist(String textArea){
		
		String[] rows = textArea.split("\n");
		
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i=0; i<rows.length; i++) {
			tmp.add(rows[i]);
		}
		
		return tmp;	
	}
}
