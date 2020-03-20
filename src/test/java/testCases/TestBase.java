package testCases;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static WebDriver driver = null;
	static WebDriverWait wait;
	
	public static boolean waitUntilElementNotDisplayed(final WebElement webElement, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return false;
				} catch (NoSuchElementException e) {
					return true;
				} catch (StaleElementReferenceException f) {
					return true;
				}
			}
		};
		return wait.until(elementIsDisplayed);
	}
	
	public static void ValidationByMessage(String msg, WebElement expectedMsg) {
		//Check if the message returned by application is the expected one

		if(msg.equalsIgnoreCase(expectedMsg.getText()))
		{
			System.out.println("Test Successful: "+msg);
			// Verify if message is not displayed anymore
			if (waitUntilElementNotDisplayed(expectedMsg, driver)) 
			{
				System.out.println("Msg is not displayed: "+msg);	
			}
		}
		else
		{
			System.out.println("Test Failure: "+msg);
		}
	}
	
	public static void ValidationByElement(String msg, WebElement wElementText) {
		//Check if the text recovered from the WebElement is the expected one

		if(msg.equalsIgnoreCase(wElementText.getText()))
		{
			System.out.println("Test Successful: "+msg);
		}
		else
		{
			System.out.println("Test Failure: "+msg);
		}
	}
	
	public static void weVisible(WebElement wElement) throws Exception{
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(wElement));
	}
	
	public static void weClickeable(WebElement wElement) throws Exception{
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(wElement));
	}
			
	@BeforeSuite
	public void initialize() throws IOException{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium Training\\Installation Stuff\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS );
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
	}
		
	@AfterSuite
	 //Test cleanup
	 public void TeardownTest()
	    {
	        TestBase.driver.quit();
	    }
}
