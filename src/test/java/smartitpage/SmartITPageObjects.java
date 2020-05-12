/* SmartIT 1908 Page Object Model Java Class
 * To locate WebPage Elements 
 * Demonstrate UC Global Search & Add Note
 */


package smartitpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


//SmartITPageObject Container Class
public class SmartITPageObjects {
	
	 //global variable of WebDriver class
	 WebDriver driver = null;
	
	
	 //Create WebElemens Objects of SmartIT WebPage
	 By loginUserName  		= By.id("loginUserName");
	 By loginPass 	   		= By.xpath("//input[@id='loginPass']");
	 By loginButton    		= By.xpath("//button[@class='btn btn-block btn-login ng-binding']");
	 By clickSearchButton	= By.xpath("//a[@id='header-search_button']");
	 By dropdownList        = By.xpath("//button[contains(text(),'Tickets & Knowledge')]");
	 By ticketTypeAll		= By.xpath("//a[contains(text(),'All')]");
	 By globalSearchtextbox = By.xpath("//input[@id='globalSearchBox']");
	 By selectCR            = By.xpath("//span[contains(text(),'CRQ000000030351')]");
	 By viewFullChange	    = By.xpath("//a[@class='ticket__name-link ng-binding']");
	 By addNote 			= By.xpath("//input[@placeholder='Add a note']");
	 By addNotefield		= By.xpath("/html/body/div[2]/div/div[2]/div/div[4]/div/div/div/div/div[3]/div[2]/div[1]/div[2]/div"); 
	 By postButton          = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/button[1]");
	 By UserDropdownlist    = By.xpath("//i[@class='icon-angle_down navigation-bar__item-icon']");
     By logoutButton		= By.xpath("//span[contains(text(),'Log Out')]");
	

	 //@Methods to initialize WebDriver instance
	 public SmartITPageObjects(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	//@Method to setLoginUserName
	public void setloginUserName(String login_UserName){
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginUserName));
		driver.findElement(loginUserName).sendKeys(login_UserName);
		wait  = null;
		System.gc();
		
	}
	
	//@Method to setPassword
	public void setloginPassword(String login_Password){
		
		driver.findElement(loginPass).sendKeys(login_Password);
		
	}
	
	//@Method  SmartIT 1908 Login 
	public void smarITLogin(){
		
		driver.findElement(loginButton).sendKeys(Keys.ENTER);
	
	}
	
	//@Method to click GlobalSearch
	public void clickSearchButton(){
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickSearchButton));
		driver.findElement(clickSearchButton).click();
		wait  = null;
		System.gc();
		
	}
	
	//@Method to set Ticket Type All
	public void selectticketTypeAll(){
		
		driver.findElement(dropdownList).click();
		driver.findElement(ticketTypeAll).click();
		
	}	
	
	//@Method to set text in GlobalSearch TextBox
	public void globalSearchTextbox(String textSearch){	
	
		driver.findElement(globalSearchtextbox).sendKeys(textSearch);
		driver.findElement(globalSearchtextbox).sendKeys(Keys.ENTER);
		
	}
	
	//@Method to select Change Request
	public void selectCR(){
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCR));
		driver.findElement(selectCR).click();
		wait = null;
		System.gc();
	}
	
	//@Method to see full Change Request
	public void viewFullCR(){
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewFullChange));
		driver.findElement(viewFullChange).click();
		wait = null;
		System.gc();
	}

	//@Method to click AddNote
	public void clickAddNote(){
		
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNote));
		driver.findElement(addNote).click();
		wait = null;
		System.gc();
		
	}
	
	//@Method to AddNote in CR
	public void addNote(String textNote){
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNotefield));
	    driver.findElement(addNotefield).sendKeys(textNote);

	}
	
	//@Method to check ChekBox Public
	public void clickCheckBox(){
		
		 WebElement tcCheckbox = driver.findElement(By.xpath("//div[@class='timeline-note__access ng-scope']"));
		 
		 //check whether CheckBox is visible or not 
         System.out.println("Is CheckBox displayed? "+ tcCheckbox.isDisplayed());
         
         //execute JavaScript
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("arguments[0].click();", tcCheckbox );	
         
         //click checkBox
         tcCheckbox.click();
         
         //check whether CheckBox is selected or not
         //System.out.println("Selection status of 'CheckBox'  : "+ tcCheckbox.isSelected());
		
		
	}
	
	//@Method to Post the Note
	public void post(){
		
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(postButton));
		driver.findElement(postButton).click();
		wait = null;
		System.gc();
		
	}
	
	//@Method to Navigate to Logout
	public void dropDownList(){
		
		WebDriverWait wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserDropdownlist));
        driver.findElement(UserDropdownlist).click();
	
	}
	
	//@Method SmartIT 1908 LogOut 
	public void smartITLogout(){

     WebDriverWait wait1 = new WebDriverWait(driver,200);
	 wait1.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
     driver.findElement(logoutButton).click();
      
	}
}