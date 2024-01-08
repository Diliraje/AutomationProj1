package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectClass.AddCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCustByName extends BaseClass {

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
}
