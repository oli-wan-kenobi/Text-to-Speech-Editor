package tests;


import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CloseDocument;
import commands.OpenDocument;
import commands.SaveDocument;

class SaveFileTest {

	@Test
	void test() {
		
		JTextArea textAreaNotEncoded = new JTextArea(
				"To be able to open encoded documents we have to decode the documents after loading their contents" +
				"from disk. In a sense, the decoding functionality should extend the file opening functionality (of any" +
				"possible file format) dynamically if the file is encoded."
			);
		JTextArea textAreaWithRot13 = new JTextArea(
				"Gb or noyr gb bcra rapbqrq qbphzragf jr unir gb qrpbqr gur qbphzragf nsgre ybnqvat gurve pbagragf " +
				"sebz qvfx. Va n frafr, gur qrpbqvat shapgvbanyvgl fubhyq rkgraq gur svyr bcravat shapgvbanyvgl (bs nal " +
				"cbffvoyr svyr sbezng) qlanzvpnyyl vs gur svyr vf rapbqrq. "
			);
		JTextArea textAreaWithAtbash = new JTextArea(
				"Gl yv zyov gl lkvm vmxlwvw wlxfnvmgh dv szev gl wvxlwv gsv wlxfnvmgh zugvi olzwrmt gsvri xlmgvmgh " +
				"uiln wrhp. Rm z hvmhv, gsv wvxlwrmt ufmxgrlmzorgb hslfow vcgvmw gsv urov lkvmrmt ufmxgrlmzorgb (lu zmb " +
				"klhhryov urov ulinzg) wbmznrxzoob ru gsv urov rh vmxlwvw. "
			);
		SaveDocument saveDocumentDocument = new SaveDocument("None", textAreaNotEncoded);
		 saveDocumentDocument.actionPerformed(null);
		 ArrayList<String> contents = saveDocumentDocument.document.contents;
		 
		
		 JTextArea textArea = new JTextArea();
		 textArea.setText("");

		 OpenDocument openDocument = new OpenDocument("None", textArea);
		 openDocument.actionPerformed(null);
		 ArrayList<String> contents_t = openDocument.document.contents;
		 
		 assertEquals(contents, contents_t);			//------------ TEST 1
		//------------------------------------------------------------------------
		 
		 CloseDocument close = new CloseDocument(textArea);
		 close.actionPerformed(null);
		 
		 
		 saveDocumentDocument = new SaveDocument("Rot-13", textAreaWithRot13);
		 saveDocumentDocument.actionPerformed(null);
		 contents = saveDocumentDocument.document.contents;
		 

		 openDocument = new OpenDocument("None", textArea);
		 openDocument.actionPerformed(null);
		 contents_t = openDocument.document.contents;
		 
		 assertEquals(contents, contents_t);			//------------ TEST 2
		 close.actionPerformed(null);
			//------------------------------------------------------------------------
		 
		 saveDocumentDocument = new SaveDocument("Atbash", textAreaWithAtbash);
		 saveDocumentDocument.actionPerformed(null);
		 contents = saveDocumentDocument.document.contents;
		 

		 openDocument = new OpenDocument("None", textArea);
		 openDocument.actionPerformed(null);
		 contents_t = openDocument.document.contents;
		 
		 assertEquals(contents, contents_t);			//------------ TEST 3
		 close.actionPerformed(null);
		 //------------------------------------------------------------------------
	}
}
