package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
	@FindBy(css = "input[placeholder=Username]")public WebElement username;
	@FindBy(css = "input[type=password]") WebElement password;
	@FindBy(css = "button[type=submit]") WebElement loginButton;
	@FindBy(linkText = "Home") public WebElement homeLink;
	
	// This method is to get URL
	public void getURL(String URL) {
		driver.get(URL);
	}
		
	// This method is to set Username in the Username text box 
	public void setUser(String userName) {
		((WebElement) username).sendKeys(userName);
	}
	
	// This method is to set Password in the password text box
	public void setPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	// This method is to click on Login Button
	public void clickOnLoginButton() {
		loginButton.click();
	}

	// This method is to verify Home Page is accessible
	public void HomePage() {
		homeLink.click();
	}
}
