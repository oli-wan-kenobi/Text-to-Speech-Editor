package commands;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Document;

public class SaveDocument implements ActionListener {

	public Document document;
	private String encryption;
	private JTextArea textArea;
	
	public SaveDocument(String encryption, JTextArea textArea) {
		this.encryption = encryption;
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		ArrayList<String> file_to_text = new ArrayList<String>();
		file_to_text = texttoArraylist();
		
		String s = String.join("", file_to_text);
		
		document = Document.getInstance();
		
		
		if(!s.equals(""))
		{
			if(document.contents != null)
			{
				if(!(document.contents).equals(   file_to_text   ))
				{
					
					try {
						JFileChooser file_chooser = new JFileChooser(new File("Documents"));
						file_chooser.setFileFilter(new FileNameExtensionFilter("Microsoft Word Documents","docx"));
						file_chooser.setFileFilter(new FileNameExtensionFilter("Microsoft Excel Documents","xlsx"));
						file_chooser.setDialogTitle("Save As");
						
						int results = file_chooser.showSaveDialog(null);
						if(results == JFileChooser.APPROVE_OPTION) 
						{
							File output_file = file_chooser.getSelectedFile();
						
							
							String whole_path = output_file.toString();
							String extension = getFileExtension(whole_path);
							
							System.out.println("Extension =  "+ extension);
							
							if(extension.equals("docx") || extension.equals("xlsx")) {
											
								if(extension.equals("docx")) {					
									document.save(whole_path, "docx", encryption, file_to_text);
								}else if(extension.equals("xlsx")) {
									document.save(whole_path, "xlsx", encryption, file_to_text);
								}else {
									System.out.println("This file format is not supoorted by this app");
									JOptionPane.showMessageDialog(null, "This file format is not supoorted by this app"); 
								}
							}else {
								String e1 = file_chooser.getFileFilter().toString();
								e1 = e1.substring(e1.indexOf("=[")+2);
								e1 = e1.substring(0,e1.indexOf("]"));
								System.out.println("found");
								
								if(e1.equals("docx")) {
									whole_path += ".docx";
									document.save(whole_path, "docx", encryption, file_to_text);
								}else if(e1.equals("xlsx")) {
									whole_path += ".xlsx";
									document.save(whole_path, "xlsx", encryption, file_to_text);
								}else {
									System.out.println("This file format is not supoorted by this app");
									JOptionPane.showMessageDialog(null, "This file format is not supoorted by this app"); 
								}
							}
						}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				else {
					System.out.println("Nothing to save");
				}
			}else {											//  SIMPLE TEXT FROM TEXT AREA
				try {
					JFileChooser file_chooser = new JFileChooser(new File("Documents"));
					file_chooser.setFileFilter(new FileNameExtensionFilter("Microsoft Word Documents","docx"));
					file_chooser.setFileFilter(new FileNameExtensionFilter("Microsoft Excel Documents","xlsx"));
					file_chooser.setDialogTitle("Save As");
					
					int results = file_chooser.showSaveDialog(null);
					if(results == JFileChooser.APPROVE_OPTION) 
					{
						File output_file = file_chooser.getSelectedFile();
						
						
						String whole_path = output_file.toString();
						String extension = getFileExtension(whole_path);
						
						System.out.println("Extension =  "+ extension);
						
						if(extension.equals("docx") || extension.equals("xlsx")) {
										
							if(extension.equals("docx")) {					
								document.save(whole_path, "docx", encryption, file_to_text);
							}else if(extension.equals("xlsx")) {
								document.save(whole_path, "xlsx", encryption, file_to_text);
							}else {
								System.out.println("This file format is not supoorted by this app");
								JOptionPane.showMessageDialog(null, "This file format is not supoorted by this app"); 
							}
						}else {
							System.out.println(file_chooser.getFileFilter());
							String e1 = file_chooser.getFileFilter().toString();
							e1 = e1.substring(e1.indexOf("=[")+2);
							e1 = e1.substring(0,e1.indexOf("]"));
							System.out.println("found");
							
							if(e1.equals("docx")) {
								whole_path += ".docx";
								document.save(whole_path, "docx", encryption, file_to_text);
							}else if(e1.equals("xlsx")) {
								whole_path += ".xlsx";
								document.save(whole_path, "xlsx", encryption, file_to_text);
							}else {
								System.out.println("This file format is not supoorted by this app");
								JOptionPane.showMessageDialog(null, "This file format is not supoorted by this app"); 
							}
						}						
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		else {
			System.out.println("Nothing to save");
		}
		
	}
	
	private String getFileExtension(String fullName) {
	    String fileName = new File(fullName).getName();
	    int dotIndex = fileName.lastIndexOf('.');
	    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
	
	private ArrayList<String> texttoArraylist(){
		
		String text = textArea.getText();
		
		String[] rows = text.split("\n");
		
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i=0; i<rows.length; i++) {
			if(rows[i] != "")
				tmp.add(rows[i]);
		}
		return tmp;
	}
}