package StepDefinations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver =null;
	                                  //Ib-web portal registeration process
	@SuppressWarnings("deprecation")
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
	System.out.println("user is on login page");
	//System.getProperty("webDriver", "C:/Users/DILIP SHINDE/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	System.getProperty("webDriver","C:/Users/DILIP SHINDE/eclipse-workspace/CucumberJava/src/test/resources/drivers/Firefox Installer.exe");
	driver = new ChromeDriver();
	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
	driver.navigate().to("https://admin-demo.nopcommerce.com/login");
	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	
	

	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
	  
		System.out.println("user entered username and password");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		Thread.sleep(1000);
	
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
			    
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		driver.findElement(By.cssSelector("button[type='submit']")).click(); 
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		//System.out.println("user select plan");
		//Select drpPlan =new Select(driver.findElement(By.id("SelectedPlanId_IbHomeA")));
		//drpPlan.selectByValue("2");
			
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		String t =  "Dashboard";
        //WebElement textt =
        // driver.findElement(By.xpath("//a[normalize-space()='Cypress Testing Tool']"));  
	 
        if (driver.getPageSource().contains("Dashboard")) {
            System.out.println("Text: " + t + " is present. ");
        } else {
            System.out.println("Text: " + t + " is not present. ");
        }
        Thread.sleep(2000); 
		
		}


}
