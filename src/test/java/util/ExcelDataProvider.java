package util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	@Test(dataProvider="test.csv data")
	public void test(String username , String password){

		System.out.println(username+" | "+password);

	}

	@DataProvider (name="test.csv data")
	public static Object[][] getData(){

		String excelPath = "C:\\Users\\apanse\\workspace\\SmartIT-Automation\\excel\\test.xlsx";		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;

	}


	public static Object[][] testData(String excelPath,String SheetName){

		ExcelUtils excel = new ExcelUtils(excelPath, SheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();

		Object data[][] = new Object[rowCount-1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData +" | ");

				data[i-1][j] = cellData;

			}		
			//System.out.println();
		}
		return data;
	}



}
