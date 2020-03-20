package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testCases.TestBase;

public class LogoutPage extends TestBase{
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
//	@FindBy(css = "img.ng-isolate-scope") WebElement avatar;
	@FindBy(xpath="//img[@alt='Avatar']") WebElement avatar;
	@FindBy(linkText = "Logout") WebElement logoutButton;
	@FindBy(css = "button[id=bot2-Msg1]") WebElement confirmLogout;

	public void Logout() throws Exception {
		TestBase.weClickeable(avatar);
		avatar.click();
		TestBase.weClickeable(logoutButton);
		logoutButton.click();
		TestBase.weClickeable(confirmLogout);
		confirmLogout.click();
	}
}
