package PageObjectClass;

import java.util.List;

import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StepDefinations.BaseClass;

public class AddCustomerPage extends BaseClass {     //This is page object model class
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		 PageFactory.initElements(ldriver, this);
		
	}
	
   By text_email=By.xpath("//input[@id='Email']");
   By text_password=By.xpath("//input[@id='Password']");
   
   By Login_btn=By.xpath("//button[@type='submit']");
   By customers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
   By customer_menuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
   By AddNewBtn=By.xpath("//a[@class='btn btn-primary']");
    By CustEmail = By.xpath("//input[@id='Email']");
    By CustPass = By.xpath("//input[@id='Password']");
    By CustFirstName =By.xpath("//input[@id='FirstName']");
    By CustLatstName =By.xpath("//input[@id='LastName']");
    By GenderMale = By.id("Gender_Male");
    
    By OpenClaender = By.xpath("//span[@aria-label='select']");  
    By SelectDate=By.xpath("a[title='Tuesday, December 12, 2023']");  
    By CompName=By.xpath("//input[@id='Company']");
    By TaxExcept =By.xpath("//input[@id='IsTaxExempt']");
    By NewsList =By.xpath("//div[@class='input-group-append']//div[@role='listbox']");
    By RoleListItem = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");  
    By CustRoleadmin= By.xpath("//li[normalize-space()='Administrators']");  
    By CustRoleGuest = By.xpath("//li[normalize-space()='Guests']");
  By custRoleRegister= By.xpath("//li[normalize-space()='Registered']");
  By custRoleVendor= By.xpath("//li[contains(text(),'Vendors')]");  
  
     By drpVendoMsng= By.xpath("//select[@id='VendorId']"); 
     By MaleGender= By.xpath("//input[@id='Gender_Male']");
     By AdminComment =By.xpath("//textarea[@id='AdminComment']");
     By ClickSaveBtn= By.xpath("//button[@name='save']");
     
     By table =By.xpath("//table[@id='customers-grid']");  //table 
     By Tblrow =By.xpath("//table[@id='customers-grid']//tbody/tr[2]]");  // tablerows
   //TableBody
     //*[@id="customers-grid"]/tbody
     //Table2ndrow
   //table[@id='customers-grid']//tr//td[2] 
     
  //Action method
     
     public String  GetTitlePAge() {
    	 
    	 return ldriver.getTitle();
     }
     
   public void ClickOncustMenu() {
	   
	   ldriver.findElement(customers_menu).click();
   }
  public void clickOnCustMenuItem() {
	  
	  ldriver.findElement(customer_menuItem).click();
	 
  }
  public void ClickAddNewBtn() {
	  
	  ldriver.findElement(AddNewBtn).click();
	  
  }
  public void SetEmail(String email) {
    	 
    	 ldriver.findElement(CustEmail).sendKeys(email);
    	 
     }
     public void SetPassword(String password) {
    	 
    	 ldriver.findElement(CustPass).sendKeys(password);
     }
     
     public void SetCustRole(String role) throws InterruptedException {
    	 
    	 if(!role.equals("Vendors")) {
    		 
    		 ldriver.findElement(By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-down']//div[@role='listbox']"));
    	 }
    	 ldriver.findElement(RoleListItem).click();
    	 
    	 WebElement listitem;
    	 
    	 Thread.sleep(2000);
    	 
    	 if(role.equals("Administrators")) {
    		 
    		 listitem=ldriver.findElement(CustRoleadmin);
    	
    	 }
    	 else if(role.equals("Guests")){
    		 
    		 listitem= ldriver.findElement(CustRoleGuest);
    	 }
    	 else if(role.equals("Registered")) {
    		 
    		 listitem=ldriver.findElement(custRoleRegister);
    		 
    	 }
    	 else  {
    		 
    		 listitem=ldriver.findElement(custRoleVendor);	 
    	 }
    	 listitem.click();
    	 Thread.sleep(3000);
     } 
     public void SetMangOfVendor(String value) {
    	 Select drp=new Select(ldriver.findElement(drpVendoMsng));
		 drp.selectByVisibleText(value); 	 
     }
     public void setGender() {
    	 ldriver.findElement(MaleGender).click();
     }
     public void SetFirstName(String fname) {
    	 
    	 ldriver.findElement(CustFirstName).sendKeys(fname);
    	 
     }
     public void SetLastName(String lname) {
    	 
    	 ldriver.findElement(CustLatstName).sendKeys(lname);
     }
     public void SetDOB(String dob) {
    	 ldriver.findElement(OpenClaender).click();
    	 ldriver.findElement(SelectDate).click();
     }
     public void SetCompName(String ComName) {
    	 ldriver.findElement(CompName).sendKeys(ComName); 
     }
     public void AdmiComment(String Comment) {
    	 
    	 ldriver.findElement(AdminComment).sendKeys(Comment);
     }
     public void ClickOnSave() {
    	 
    	 ldriver.findElement(ClickSaveBtn).click();
     }
    
	 
    	 
     
     
  }