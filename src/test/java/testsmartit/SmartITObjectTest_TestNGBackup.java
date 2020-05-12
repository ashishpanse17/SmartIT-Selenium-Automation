/*  This is TestNG Class for SmartITPageObjects.java class
 *  SmartIT UseCase Global Search to check whether is ran or not
 *  GlobalSearch by Asset Term & Update Associated Change Request (CR)
 *  @BMC Software Performance  Testing Team 
 *  Internally Managed by Performance Team to ran a sanity test
 *  to check 'Functional-Testing' of @BMC Software Products.
 */

package testsmartit;

import org.testng.annotations.Test;

import config.PropertiesFile;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import smartitpage.SmartITPageObjects;


public class SmartITObjectTest_TestNGBackup {

	
	  private static WebDriver driver 	 = null; 
	  public static String browsername   = null;
	  public static String protocol	     = null;
	  public static String url           = null;
	  public static String username	     = null;
	  public static String password	     = null;
	  public static String textSearch    = null;
	  public static String Note 		 = null;

	
		@BeforeTest 
		public void setUpTest() throws IOException{
			
			String ProjectPath  = System.getProperty("user.dir");
			PropertiesFile.getProperties();
			
			if(browsername.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver", ProjectPath+"/drivers/chromedriver/chromedriver_win32 (1)/chromedriver.exe");
				driver = new ChromeDriver();	            		    
				driver.manage().window().maximize();
				
			}
			else if(browsername.equalsIgnoreCase("firefox")){
				
				System.setProperty("webdriver.gecko.driver", ProjectPath+"/drivers/geckodriver/geckodriver-v0.26.0-win64/geckodriver.exe");
				driver = new FirefoxDriver();	            		    
				driver.manage().window().maximize();
				
			}
			
			try {
				PropertiesFile.getProperties();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		
	
		
		//Main Test Method
		@Test
		public void globalSearch() throws IOException {
			
			SmartITPageObjects smtITPageObj = new SmartITPageObjects(driver);
						 
			driver.get(protocol+"://"+url+"/smartit/app/#/");
			
			PropertiesFile.getProperties();
					
			smtITPageObj.setloginUserName(username);
			smtITPageObj.setloginPassword(password);
			smtITPageObj.smarITLogin();
			smtITPageObj.clickSearchButton();
			smtITPageObj.selectticketTypeAll();
			smtITPageObj.globalSearchTextbox(textSearch);
			smtITPageObj.selectCR();
			smtITPageObj.viewFullCR();
			smtITPageObj.clickAddNote();
			smtITPageObj.addNote(Note);
			smtITPageObj.clickCheckBox();
			smtITPageObj.post();
			//smtITPageObj.dropDownList();
			smtITPageObj.smartITLogout();		
		}
		
		
		@AfterTest
		public void tearDown(){
			
		   //Close browser
			driver.quit();
            
			//Release WebDriver instance resource 
			driver.close();
	
		}
}
	