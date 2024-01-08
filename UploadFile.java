package PageObjectClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {
	
	
	WebDriver driver =null;

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.foundit.in/");
		System.out.println("Browser opening website");
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();
		System.out.println("User clicks upload file button");
		Thread.sleep(2000);
		
		//by sendKey method
		
		//driver.findElement(By.xpath("//*[@id=\"file-upload\"]"))
		//.sendKeys("C:\\Users\\DILIP SHINDE\\OneDrive\\TestingData\\Sample testing files\\Sample_PDF_500_kB.pdf");
		//Thread.sleep(3000);
		//System.out.println("user select path for file and upload it");
        
		//driver.findElement(By.id("pop_upload")).click();
		//System.out.println("User click submit button");

		//Using robot class method
		
		WebElement butn= driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",butn );  //click action on the button
		
     // perform 3 actions 1) Copy the path 2) Paste the path 3) Press enter key
		
		Robot rb= new Robot();
		
		rb.delay(2000);
		
		//Put the path of file in a clipboard
		StringSelection ss= new StringSelection("C:\\Users\\DILIP SHINDE\\OneDrive\\TestingData\\Sample testing files\\Sample_PDF_500_kB.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		System.out.println("Given file path");
		
		//control+V method
		rb.keyPress(KeyEvent.VK_CONTROL);   //press control key  on board
		rb.keyPress(KeyEvent.VK_V);       //press key V on board
		rb.delay(2000);
		//Release control and V key
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.delay(2000);
		
		// Enter key press
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		System.out.println("File uploaded succssfully");
		rb.delay(1000);
		
		driver.findElement(By.id("pop_upload")).click();
		
		System.out.println("user click on submit button");
		
		
	}

}
