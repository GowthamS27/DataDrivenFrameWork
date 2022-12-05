package org.usingApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DataDrivenUsingPOI {
	public void readExcel() throws IOException {
		FileInputStream excel = new FileInputStream("‪C:\\Users\\gowth\\Pictures\\Test.xls");
		Workbook workbook = new HSSFWorkbook(excel);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			while (columnIterator.hasNext()) {
				columnIterator.next();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		DataDrivenUsingPOI usingPOI= new DataDrivenUsingPOI();
		usingPOI.readExcel();
		
	}
}
