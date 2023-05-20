package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CloseDocument;
import commands.OpenDocument;

class LoadFileTest {

	@Test
	void test() {

		ArrayList<String> file = new ArrayList<String>() {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			{
				add("To be able to open encoded documents we have to decode the documents after loading their contents");
				add("from disk. In a sense, the decoding functionality should extend the file opening functionality (of any");
				add("possible file format) dynamically if the file is encoded.");
			}
		};
		ArrayList<String> file_withRot13 = new ArrayList<String>() {
			 
			
			  private static final long serialVersionUID = 1L;
			  
			 { add("Gb or noyr gb bcra rapbqrq qbphzragf jr unir gb qrpbqr gur qbphzragf nsgre ybnqvat gurve pbagragf "); 
			 	add("sebz qvfx. Va n frafr, gur qrpbqvat shapgvbanyvgl fubhyq rkgraq gur svyr bcravat shapgvbanyvgl (bs nal "); 
			 	add("cbffvoyr svyr sbezng) qlanzvpnyyl vs gur svyr vf rapbqrq. ");
			 }
		 };
		 ArrayList<String> file_Atbash = new ArrayList<String>() {
			 
				
			 private static final long serialVersionUID = 1L;
			  
			 { add("Gl yv zyov gl lkvm vmxlwvw wlxfnvmgh dv szev gl wvxlwv gsv wlxfnvmgh zugvi olzwrmt gsvri xlmgvmgh "); 
			 	add("uiln wrhp. Rm z hvmhv, gsv wvxlwrmt ufmxgrlmzorgb hslfow vcgvmw gsv urov lkvmrmt ufmxgrlmzorgb (lu zmb "); 
			 	add("klhhryov urov ulinzg) wbmznrxzoob ru gsv urov rh vmxlwvw. ");
			 }
		 };

		 JTextArea textArea = new JTextArea();
		 textArea.setText("");

		 OpenDocument openDocument1 = new OpenDocument("None", textArea);
		 openDocument1.actionPerformed(null);
		 ArrayList<String> contents1 = openDocument1.document.contents;

		 CloseDocument close = new CloseDocument(textArea);
		 close.actionPerformed(null);
		 
		 OpenDocument openDocument2 = new OpenDocument("Rot-13", textArea);
		 openDocument2.actionPerformed(null);
		 ArrayList<String> contents2 = openDocument2.document.contents;
				 
		 close.actionPerformed(null);
		 
		 OpenDocument openDocument3 = new OpenDocument("Atbash", textArea);
		 openDocument3.actionPerformed(null);
		 ArrayList<String> contents3 = openDocument3.document.contents;
				 
		 for(int i=0; i< contents1.size(); i++) { 
			 assertEquals(contents1.get(i),file.get(i));
			 assertEquals(contents2.get(i),file_withRot13.get(i));
			 assertEquals(contents3.get(i),file_Atbash.get(i)); }
				 
	}
}
				// PAROLO POU OTAN ANOIGOUME ENA ARXEIO ME ROT-13 H ATBASH TO KANOUME TRIM(), TA KENA PARAMENOUN. OPOTE
				// STA TEST APAITEITAI NA YPARXOYN KENA STO TELOS.