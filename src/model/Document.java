package model;

import java.util.ArrayList;


import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dataLoad.DocumentReader;
import dataLoad.DocumentReaderFactory;
import dataSave.DocumentWriter;
import dataSave.DocumentWriterFactory;

public class Document {
	
	
	private static Document instance;

	public ArrayList<String> contents;
	public String fileName, extension, encryption;
	private DocumentWriter documentWriter;
	private DocumentWriterFactory documentWriterFactory;
	private DocumentReader documentReader;
	private DocumentReaderFactory documentReaderFactory;
	public boolean saved;
	
	private TTSFacade facade = new TTSFacade();
	
	public Document() {
		saved = false;
	}
	
	public void open(String fileName, String extension, String encryption) {
		
		documentReaderFactory = new DocumentReaderFactory();
		documentReader = documentReaderFactory.createReader(fileName, extension, encryption);
		contents = documentReader.read();
		
		//System.out.print("OPEN::::::::: ");
		for(String s: contents) {
			System.out.println(s);
		}
		
		this.fileName = fileName;
	}
	
	public void save (String fileName, String extension, String encryption, ArrayList<String> text) {
		
		documentWriterFactory = new DocumentWriterFactory();
		documentWriter = documentWriterFactory.createWriter(fileName, extension, encryption,text);
		ArrayList<String> success = documentWriter.write();
		if(success==null) {
			System.out.println("Task 'save' failed"); 
			JOptionPane.showMessageDialog(null, "Task 'save' failed"); 
		}
		this.fileName = fileName;
		contents = success;
		saved = true;
	}
	
	public void close() {
		contents = null;
		saved = false;
	}
	
	public static Document getInstance(){
		if(instance == null)
			instance = new Document();
		return instance;
	}
	

	public void playContnents(JTextArea textArea) {
		facade.play(textArea.getText(),-1, -1);
	}
	
	public void playFakeContnents(JTextArea textArea) {
		FakeTTSFacade fakeFacade = new FakeTTSFacade();
		fakeFacade.play(textArea.getText(),-1, -1);
	}
	
	public void playLine(JTextArea textArea, int a, int b) {
		String txt = textArea.getText();
		facade.play(txt, a, b);
	}
	
	public void playFakeLine(JTextArea textArea, int a, int b) {
		FakeTTSFacade fakeFacade = new FakeTTSFacade();
		String txt = textArea.getText();
		fakeFacade.play(txt, a, b);
	}
	
	
	public String[] getDefaultValues() {
		float[] tmp1 = facade.getDefaultValues();
		String[] tmp2 = new String[3];
		for(int i=0; i<tmp1.length; i++) {
			tmp2[i] = String.valueOf(tmp1[i]);
		}
		  
		return tmp2;
	}
	
	public void setConfigValues(String op, String num) {
		
		switch (op)
		{
			case "volume":
				if(Float.parseFloat(num) < 0)
					facade.setVolume( (Float.parseFloat(num)) * (-1));
				facade.setVolume(Float.parseFloat(num));
				break;
			case "rate":
				if(Float.parseFloat(num) < 0)
					facade.setRate( (Float.parseFloat(num)) * (-1));
				facade.setRate(Float.parseFloat(num));
				break;
			case "pitch":
				facade.setPitch(Float.parseFloat(num));
				break;
			default:
				System.out.println("setConfigValues method. Something unexpected happened");
				break;
		}
	}
}