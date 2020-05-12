package util;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String ProjectPath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath,String SheetName){
		 try{
		ProjectPath = System.getProperty("user.dir");
		wb = new XSSFWorkbook(excelPath);
		sheet = wb.getSheet(SheetName);
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
	public static void main(String[] args){
		getCellDataString(0,0);		
		getCellDataNumeric(1,1);
	}

	public static int getRowCount(){
		
		int rowCount=0;
		
         try{
        	 rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of rows found in test.xlsx :  "+rowCount);
			
         }catch (Exception e) {
			// TODO: handle exception
        	 System.out.println(e.getMessage());
        	 System.out.println(e.getCause());
		}
        return rowCount;
	}
	
	public static int getColumnCount(){
		
		int colCount=0;
		
		try{
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		    System.out.println("No. of Coloumns found in test.xlsx :  "+colCount);
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return colCount;
	}
	
	public static String getCellDataString(int rowNum, int colNum){

	
		
			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);
			return cellData;
	
	}


	public static void getCellDataNumeric(int rowNum, int colNum){

		try {
			ProjectPath = System.getProperty("user.dir");
			wb = new XSSFWorkbook(ProjectPath+"/excel/test.xlsx");
			sheet = wb.getSheet("Sheet1");
			Double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();		
			//System.out.println(cellData);	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
