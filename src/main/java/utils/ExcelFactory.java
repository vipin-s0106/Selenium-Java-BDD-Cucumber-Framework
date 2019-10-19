package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFactory {
	
	
//Used for to create the Excel Template
	public void create_Excel_Template(ArrayList<String> coulmn_name_list,String sheetname,String Path,String filename) throws IOException {
		if(!new ExcelFactory().verifyFilePresent(Path, filename)) {
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet(sheetname);
	        Row row = sheet.createRow(0);
	        int cellNo=0;
	        for(String column_value : coulmn_name_list) {
	        	row.createCell(cellNo++).setCellValue(column_value);
	        }         
	        try (FileOutputStream outputStream = new FileOutputStream(Path+"\\"+filename)) {
	            workbook.write(outputStream);
	        }
	        finally {
	        	workbook.close();
	        }
		}
		else {
			System.out.println("File already present");
		}
		
    }
	
//Used for to write the Single_Row_Data 
	public void write_Excel_single_row(ArrayList<String> values_list,String sheetname,String Path,String filename) throws IOException {
		FileInputStream excelFile = new FileInputStream(Path+"\\"+filename);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        int row_number = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Row row = sheet.createRow(row_number+1);
        for(int i =0;i < values_list.size();i++) {
        	row.createCell(i).setCellValue(values_list.get(i));
        }
        try (FileOutputStream outputStream = new FileOutputStream(Path+"\\"+filename)) {
            workbook.write(outputStream);
        }
        finally {
        	workbook.close();
        }
	}
	
//Used for to Overwrite the Data for the Given Row
	public void overwrite_data_single_row(ArrayList<String> values_list,String sheetname,String Path,String filename,int RowNum) throws Exception {
		FileInputStream excelFile = new FileInputStream(Path+"\\"+filename);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        //int row_number = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Row row = sheet.getRow(RowNum);
        for(int i =0;i < values_list.size();i++) {
        	row.createCell(i).setCellValue(values_list.get(i));
        }
        try (FileOutputStream outputStream = new FileOutputStream(Path+"\\"+filename)) {
            workbook.write(outputStream);
        }
        finally {
        	workbook.close();
        }
	}
	
//Used for to Overwrite the Data for Multiple Row
	public void overwrite_data_multiple_row(ArrayList<ArrayList<String>> row_list,String sheetname,String Path,String filename) throws Exception {
		FileInputStream excelFile = new FileInputStream(Path+"\\"+filename);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        for( int i = 1 ; i <= row_list.size() ; i++) {
        	ArrayList<String> value_list = row_list.get(i-1);
        	Row row = sheet.getRow(i);
        	for( int j = 0 ; j < value_list.size() ; j++ ) {
        		row.getCell(j).setCellValue(value_list.get(j));
        	}
        }
        
        try (FileOutputStream outputStream = new FileOutputStream(Path+"\\"+filename)) {
            workbook.write(outputStream);
        }
        finally {
        	workbook.close();
        }
	}
	
	
	public boolean verifyFilePresent(String Path,String Filename) {
		Path = Path + "\\" + Filename;
		File f = new File(Path);
		if(f.exists()) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) throws IOException {
//		ArrayList<String> list = new ArrayList<>();
//		list.add("a");
//		list.add("a");
//		list.add("a");
//		new ExcelFactory().write_Excel_single_row(list, "Sheet1","C:\\Users\\vipin\\Desktop" , "Demo.xlsx");
//		System.out.println(new ExcelFactory().verifyFilePresent("C:\\Users\\vipin\\Desktop" , "Demo.xlsx"));
	}
}
