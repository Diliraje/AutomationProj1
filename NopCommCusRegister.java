package StepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjectClass.AddCustomerPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given ;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NopCommCusRegister extends BaseClass{
	WebDriver driver =null;
	
	@Given("Admin  open chrome browser")
	public void admin_open_chrome_browser() throws InterruptedException {
	    
	    System.out.println("User opening browser");
	    
	    
	    System.getProperty("webDriver","C:/Users/DILIP SHINDE/eclipse-workspace/CucumberJava/src/test/resources/drivers/Firefox Installer.exe");
		driver = new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		driver.manage().window().maximize();    
	}

	@When("Admin opens URL {string}")
	public void admin_opens_url(String url) throws InterruptedException {
		url="https://admin-demo.nopcommerce.com/login";
	    System.out.println("Opening URL");
	    driver.navigate().to(url);  
	    Thread.sleep(2000);
	}

	@And("adminm enters user name {string} and password {string}")
	public void adminm_enters_user_name_and_password(String string, String string2) throws InterruptedException {
		
		System.out.println("User enters username and password");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		Thread.sleep(1000);
	
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
	
	}

	@And("click on login")
	public void click_on_login() throws InterruptedException {
		System.out.println("User clicks on login button");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
	
	}

	@Then("Admin view dashboard {string}")
	public void admin_view_dashboard(String title) throws InterruptedException {
		
		addcust =new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addcust.GetTitlePAge());
		
		 String t =  "Dashboard";
	        //WebElement textt =
	        // driver.findElement(By.xpath("//a[normalize-space()='Cypress Testing Tool']"));  
		 
	        if (driver.getPageSource().contains("Dashboard")) {
	            System.out.println("Text: " + t + " is present. ");
	        } else {
	            System.out.println("Text: " + t + " is not present.");
	        }
	        Thread.sleep(2000);
	    }
		

	@When("admins clicks on customer menu")
	public void admins_clicks_on_customer_menu() throws InterruptedException {
		System.out.println("User clicks customer menu"); 
		driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();
		//a[@href='#']//p[contains(text(),'Customers')]
		Thread.sleep(2000);
		
	}

	@And("clicks on customer menu item")
	public void clicks_on_customer_menu_item() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
		//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]
		
        Thread.sleep(2000);  
        String tx =  "Customers";
       
        if (driver.getPageSource().contains("Customers")) {
            System.out.println("Text: " + tx + " is present. ");
        } else {
            System.out.println("Text: " + tx + " is not present. ");
        }
        Thread.sleep(2000);
        //System.out.println("User clicks customer menu item");
	}

	@And("click on add new button")
	public void click_on_add_new_button() {
        // System.out.println("User click add new button");
         driver.findElement(By.xpath("//a[normalize-space()='Add new']")).click();
       
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		Assert.assertEquals("Condition true", actualTitle, expectedTitle);
		System.out.println("User view customer page"); 
	}

	@When("admin enters customer info")
	public void admin_enters_customer_info() throws InterruptedException {
		String month="January 2024";
		
		Thread.sleep(2000);
		System.out.println("User filling customer info");
		
		driver.findElement(By.id("Email")).sendKeys("ib3user2@yopmail.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.id("FirstName")).sendKeys("Test");
		driver.findElement(By.id("LastName")).sendKeys("user");
        driver.findElement(By.id("Gender_Male")).click();
        driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']\r\n")).click(); 
        Thread.sleep(2000);
        
        while(true)  
        {
        	String text=driver.findElement(By.xpath("//a[normalize-space()='January 2024']")).getText();
        	if(text.equals(month)){   //a[normalize-space()='January 2024']
        		break;
        	}
        	else {
        		driver.findElement(By.xpath("//a[@title='Wednesday, January 31, 2024']")).click();
        	}
        	Thread.sleep(2000); 
        }
       driver.findElement(By.xpath("//input[@id='DateOfBirth']")).sendKeys("1/31/2024");
        driver.findElement(By.id("Company")).sendKeys("Test company");
        driver.findElement(By.id("IsTaxExempt")).click();
        //driver.findElement(By.xpath("//div[@class='input-group-append']//div[@role='listbox']")).sendKeys("Testnewlatter");
        driver.findElement(By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']")).click();
        driver.findElement(By.id("VendorId")).click();
        driver.findElement(By.xpath("//select[@id='VendorId']")).click();
        
        
        driver.findElement(By.id("AdminComment")).sendKeys("Test comment");
        Thread.sleep(2000);
        
	}

	@And("click on save button")
	public void click_on_save_button() {
	    //System.out.println("User click on save button");
	    
	    driver.findElement(By.name("save")).click();
	}

	@Then("user can view message {string}")
	public void user_can_view_message(String msg) {
		
		String tt="The new customer has been added successfully";

        if (driver.getPageSource().contains("The new customer has been added successfully")) {
            System.out.println("Text: " + tt + " is present. ");
        } 
        else  {
        	 
        	System.out.println("Email is already registered");
        	
           //System.out.println("Text: " + tt + " is not present. ");
      }
	}

	@And("browser close")
	public void browser_close() {
		//System.out.println("browser close");
		
		
		//driver.manage().window().minimize();
	}
	//---------------Scenario-->Search customer by Email-------------

	@When("enter customer Email")
	public void enter_customer_email() throws InterruptedException {
		//System.out.println("user entering Email ID");
	   driver.findElement(By.id("SearchEmail")).sendKeys("ib3user2@yopmail.com");
	   Thread.sleep(1000);
	   driver.findElement(By.id("SearchFirstName")).sendKeys("Test");
	   Thread.sleep(1000);
	   driver.findElement(By.id("SearchLastName")).sendKeys("user");
	   Thread.sleep(1000);
	   
	}

	@And("click on search button")
	public void click_on_search_button() {
		System.out.println("user click search button");
		driver.findElement(By.id("search-customers")).click();
			
		//html/body/div[3]/div[1]/form/div[2]/ul/li
	}

	@Then("user should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		
	     
	}
	 public boolean SearchCustByEmailID(String email) throws InterruptedException {
		//div[@class='row']//div[@class='col-md-12']
		   boolean flag=false;
		   WebElement table= driver.findElement(By.xpath("//*[@id=\"customers-grid']"));
		   for(int i=1;i<=1000;i++) {
			   String emailid= table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
	      System.out.println(emailid);
	    
	      if(emailid.equals("ib3user2@yopmail.com")) {
	    	  System.out.println(emailid);  
	    	  
	    	flag=true;
	    	
	      }    
	      
   }
		   Thread.sleep(2000);
		
		   return flag;
		   
	 }
	 @Then("Click on logout")
	 public void click_on_logout() {    
		
	
	WebElement allHeaders=driver.findElement(By.xpath("//table[@id='customers-grid']//tr//th"));
	     System.out.println(allHeaders.getSize());
	     
		 
	 
	     
	 }
}


