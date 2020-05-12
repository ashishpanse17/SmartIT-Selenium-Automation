/*  This is TestNG Class for SmartITPageObjects.java class
 *  SmartIT UseCase Global Search to check whether is ran or not
 *  GlobalSearch by Asset Term & Update Associated Change Request (CR)
 *  @BMC Software Performance  Testing Team 
 *  Internally Managed by Performance Team to ran a sanity test
 *  to check 'Functional-Testing' of @BMC Software Products.
 */

package testsmartit;


import util.ExcelUtils;
import java.io.IOException;
import config.PropertiesFile;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import smartitpage.SmartITPageObjects;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;





public class SmartITObjectTest_TestNG {

	
	  private static WebDriver driver 	 = null; 
	  public static String browsername   = null;
	  public static String protocol	     = null;
	  public static String url           = null;
	  public static String username	     = null;
	  public static String password	     = null;
	  public static String textSearch    = null;
	  public static String Note 		 = null;

	  ExtentHtmlReporter htmlReporter ;
	  ExtentReports extent;
	  
	    
		@BeforeTest 
		@Parameters("browserName")
		public void setUpTest(String browserName) throws IOException{
			
	        // start reporters
	        htmlReporter = new ExtentHtmlReporter("extent.html");
	    
	        // create ExtentReports and attach reporter(s)
	        extent = new ExtentReports(); 
	        extent.attachReporter(htmlReporter);
			
			String ProjectPath  = System.getProperty("user.dir");
			PropertiesFile.getProperties();
			
			if(browserName.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver", ProjectPath+"/drivers/chromedriver/chromedriver_win32 (1)/chromedriver.exe");
				driver = new ChromeDriver();	            		    
				driver.manage().window().maximize();
				
			}
			else if(browserName.equalsIgnoreCase("firefox")){
				
				System.setProperty("webdriver.gecko.driver", ProjectPath+"/drivers/geckodriver/geckodriver-v0.26.0-win64/geckodriver.exe");
				driver = new FirefoxDriver();	            		    
				driver.manage().window().maximize();
				
			}
			
			try {
				PropertiesFile.getProperties();
			}catch (IOException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
			
		  }
		
	/*	@Test(dataProvider="test.csv data")
		public void test(String username , String password) throws IOException, InterruptedException{

			System.out.println(username+" | "+password);
			SmartITObjectTest_TestNG.username=username;
			SmartITObjectTest_TestNG.password=password;
			d
		}
	*/	
		
		@Test(dataProvider="test.csv data")
		public void globalSearch(String username , String password)  throws IOException, InterruptedException {
			
			
			System.out.println(username+" | "+password);
			SmartITObjectTest_TestNG.username=username;
			SmartITObjectTest_TestNG.password=password;
			
			// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("SmartIT - Automation", "This is SmartIT - Automation Project to automate Business Usecase of Global Search");
		    
	        // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");
	        
	        // log(Status, details)
	        test.log(Status.INFO,"Starting Test Case");
	        
	        test.pass("Open the Browser");
			

			SmartITPageObjects smtITPageObj = new SmartITPageObjects(driver);
			 
			driver.get(protocol+"://"+url+"/smartit/app/#/");
			
			 test.pass("Navigate to SmartIT Login Page");
			 
		        // info(details)
		        test.info("This step shows usage of info(details)");
		        
		        // log with snapshot
		        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		        
		        // test with snapshot
		        test.addScreenCaptureFromPath("screenshot.png");
			
			PropertiesFile.getProperties();
					
			smtITPageObj.setloginUserName(username);
			smtITPageObj.setloginPassword(password);
			
				smtITPageObj.smarITLogin();
			test.pass("Click Login Button");
			
			test.addScreenCaptureFromPath("screenshot.png");
			
			Thread.sleep(5000);
			
			smtITPageObj.clickSearchButton();
			test.pass("Click Global Search Button");
			smtITPageObj.selectticketTypeAll();
			test.pass("Select Ticket Type All");
			
			Thread.sleep(5000);
			
			smtITPageObj.globalSearchTextbox(textSearch);
			test.pass("Enter Text : '"+textSearch+"' in Search Box");
			
			Thread.sleep(5000);
			
			smtITPageObj.selectCR();
			test.pass("Select Chage Request");
			
			Thread.sleep(3000);
			
			smtITPageObj.viewFullCR();
			test.pass("View Full Chage Request");
			smtITPageObj.clickAddNote();
			test.pass("Click Add Note Button");
			
			Thread.sleep(3000);
			
			smtITPageObj.addNote(Note);
			test.pass("Add Note : '"+Note);
			smtITPageObj.clickCheckBox();
			test.pass("Click Check Box Public");
			smtITPageObj.post();
			test.pass("Click Post Button");
			smtITPageObj.dropDownList();
			test.pass("Click User DropDown Button");
			smtITPageObj.smartITLogout();
			test.pass("Click Logout Button");
			
			Thread.sleep(15000);
	
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

		
		@AfterTest
		public void tearDown(){
			
			 // calling flush writes everything to the log file
			extent.flush();
			
		   //Close browser
			driver.quit();
            
			//Release WebDriver instance resource 
			driver.close();

		}
}
	