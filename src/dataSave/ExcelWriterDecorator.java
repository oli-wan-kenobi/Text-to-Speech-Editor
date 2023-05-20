package dataSave;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterDecorator extends WriterDecorator{

	public ExcelWriterDecorator(DocumentWriter documentWriter) {
		super(documentWriter);
	}
	
	public ArrayList<String> write() {
		ArrayList<String> ar = documentWriter.write();
		
		return excelDecorator(ar);
	}

	public ArrayList<String> excelDecorator(ArrayList<String> ar) {
		
		String path = ar.get(ar.size() -1);
		ar.remove(ar.size()-1);
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			String name = new File(path).getName();
	        XSSFSheet sheet = workbook.createSheet(name);
	         
	        int rowid = 0;
	        
	        for(String line: ar) {
	        	Object [] cells = line.split("");
	        	XSSFRow row = sheet.createRow(rowid ++);
	        	int cellid = 0;
	        	
	        	for (Object obj : cells){
	                Cell cell = row.createCell(cellid++);
	                cell.setCellValue((String)obj);
	             }
	        }
	        //Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
			workbook.close();
			
	        System.out.println("Writesheet.xlsx written successfully");   
		
	        
	        return ar;
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
