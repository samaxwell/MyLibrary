package com.industries.seanimus.books;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class AllBooksReport {

	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private String inputFile;

	public void setOutputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void write() throws IOException, WriteException {
		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		createLabel(excelSheet);
		createContent(excelSheet);

		workbook.write();
		workbook.close();
	}

	private void createLabel(WritableSheet sheet) throws WriteException {
		// Create a font
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		times = new WritableCellFormat(times10pt);
		times.setWrap(true);

		// Create a new font
		WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		timesBoldUnderline.setWrap(true);
		
		CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);
	
		addCaption(sheet, 0, 0, "Header 1");
		addCaption(sheet, 1, 0, "This is another header");
	}
	
	private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
		System.out.println("Generating content");
		long startTime = System.nanoTime();
		int MAX = 65535;
		for (int i=1; i<MAX; i++){
			addNumber(sheet, 0, i, i + 10); // First column
			addNumber(sheet, 1, i, i * i);  // Second column
		}
		
		StringBuffer buf = new StringBuffer();
		buf.append("SUM(A2:A"+MAX+")");
		Formula f = new Formula(0, MAX, buf.toString());
		sheet.addCell(f);;
		buf = new StringBuffer();
		buf.append("SUM(B2:B"+MAX+")");
		f = new Formula(1, MAX, buf.toString());
		sheet.addCell(f);

		for (int i=0; i<MAX; i++){
			addLabel(sheet, 3, i, "Boring text " + i);
			addLabel(sheet, 4, i, "Another text");
		}
		
		System.out.println("Done: " + ((System.nanoTime()-startTime)/1000000000) + " seconds");
	}
	
	private void addCaption(WritableSheet sheet, int column, int  row, String s)
				throws RowsExceededException, WriteException {
		Label label = new Label(column, row, s, timesBoldUnderline);
		sheet.addCell(label);
	}
	
	private void addNumber(WritableSheet sheet, int column, int row, Integer integer)
				throws WriteException, RowsExceededException {
		Number number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}
	
	private void addLabel(WritableSheet sheet, int column, int row, String s) 
				throws WriteException, RowsExceededException {
		Label label = new Label(column, row, s, times);
		sheet.addCell(label);
	}
}
