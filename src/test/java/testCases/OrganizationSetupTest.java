package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.OrganizationSetupPage;

public class OrganizationSetupTest  extends TestBase{
	@Test
	public void processes() throws Exception{
		OrganizationSetupPage orgsetuppage = PageFactory.initElements(driver, OrganizationSetupPage.class);
		
		orgsetuppage.CollapseMenu();
		orgsetuppage.AdministrationForm();
		
		orgsetuppage.Validation();		
	}
}
