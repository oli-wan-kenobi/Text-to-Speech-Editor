package commands;

import model.Document;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenDocument implements ActionListener {

	public Document document;
	private String encryption;
	private JTextArea textArea;
	
	public OpenDocument(String encryption, JTextArea textArea) {
		this.encryption = encryption;
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String text = textArea.getText();
		if(text.length() > 0)
		{
			System.out.println("In order to open a new file close this one first!");
			JOptionPane.showMessageDialog(null, "In order to open a new file close this one first!");

		}else {
			JFileChooser file_chooser = new JFileChooser(); 
			file_chooser.setCurrentDirectory(new File("./Data"));
			file_chooser.setFileFilter(new FileNameExtensionFilter("(*docx,*.xlsx)","docx", "xlsx"));
			int returnValue	= file_chooser.showOpenDialog(null); 
			
			if(returnValue  == JFileChooser.APPROVE_OPTION) {
				File inputFile = file_chooser.getSelectedFile();
				
				String whole_path = inputFile.toString();
				String extension = getFileExtension(whole_path);
				

				document = Document.getInstance();
				document.open(whole_path, extension, encryption);
				
				if(show_file() != 0) {
					System.out.println("Could not show file");
					JOptionPane.showMessageDialog(null, "Could not show file");
				}
				
				
			}else {
				System.out.println("ShowOpenDialog Method could not open file system!");
			}			
		}	
	}
	
	private String getFileExtension(String fullName) {
	    String fileName = new File(fullName).getName();
	    int dotIndex = fileName.lastIndexOf('.');
	    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
	
	private int show_file() {
		
		for(String row: document.contents) {
			textArea.append(""+row);
			textArea.append("\n");
		}
		return 0;
	}
}