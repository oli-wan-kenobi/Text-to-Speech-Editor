/**
 * 
 */
package dataLoad;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DocumentReader {

	String path;
	ArrayList<String> arraylist;
	
	public ExcelReader(String path) {
		this.path = path;
		arraylist = null;
	}

	@Override
	public ArrayList<String> read() 
	{
		arraylist = new ArrayList<String>();
		
		try {
			FileInputStream fileToRead = new FileInputStream(path);
			try (XSSFWorkbook myWorkBook = new XSSFWorkbook(fileToRead)) {
				XSSFSheet mysheet = myWorkBook.getSheetAt(0);	// first sheet from xlsx workbook
				Iterator<Row> rowIterator = mysheet.iterator();		//iterator to all the rows in current sheet
				
				while(rowIterator.hasNext()) {
					Row row = rowIterator.next();
					String ar_row = "";
					
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						ar_row += ""+cell;
						
					}
					arraylist.add(ar_row);
				}
			}
			fileToRead.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		return arraylist;
	}
}
