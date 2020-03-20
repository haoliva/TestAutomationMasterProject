package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.LogoutPage;

public class LogoutTest extends TestBase{
	@Test
	public void processes() throws Exception{
		LogoutPage logoutpage = PageFactory.initElements(driver, LogoutPage.class);
		
		logoutpage.Logout();
		System.out.println("Test Successful: Logout process is Complete!");
		
	}
}
