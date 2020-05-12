package util;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ProjectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(ProjectPath+"/excel/test.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getColumnCount();
		excel.getCellDataString(0,0);
		excel.getCellDataNumeric(0, 1);
		excel.getCellDataString(1,0);
		excel.getCellDataNumeric(1, 1);

	}
}
