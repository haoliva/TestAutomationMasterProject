package pageFactory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testCases.TestBase;

public class OrganizationSetupPage {
	WebDriver driver;
	String msg = "Organization Infused Solutions Dev Env saved successfully";
	
	public OrganizationSetupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
	@FindBy(css = "#hide-menu > span:nth-child(1) > a:nth-child(1)") WebElement collapseMenu;
	@FindBy(linkText = "Home") WebElement homeLink;

	@FindBy(linkText = "Administration") WebElement administration;
	@FindBy(linkText = "Organization Administration") WebElement organizationAdministration;
	@FindBy(linkText = "Organization Setup") WebElement organizationSetup;
	@FindBy(css = "timezone-picker.form-control > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > i:nth-child(3)") WebElement organizationTimeZone;
	@FindBy(linkText = "GMT+5") WebElement organizationTimeZoneSelection;
	@FindBy(css = "button.ng-binding") WebElement saveOrganizationButton;
	@FindBy(id = "organization_name") WebElement organizationName;
	@FindBy(className = "toast-message") WebElement expectedMessage;
	
	public void CollapseMenu() {
		homeLink.click();
		Dimension menuActive = administration.getSize();
		if(menuActive.equals(null))
		{
			collapseMenu.click();
		}
	}
	
	public void AdministrationForm() throws Exception {
		administration.click();
		TestBase.weVisible(organizationAdministration);
		organizationAdministration.click();
		TestBase.weVisible(organizationSetup);
		organizationSetup.click();
	
		TestBase.weVisible(organizationName);
		organizationName.clear();
		organizationName.sendKeys("Infused Solutions Dev Env");
		organizationTimeZone.click();
		organizationTimeZoneSelection.click();
	
		TestBase.weVisible(saveOrganizationButton);
		saveOrganizationButton.click();
	}
	
	public void Validation() throws Exception {
		TestBase.weVisible(expectedMessage);
		TestBase.ValidationByMessage(msg, expectedMessage);
	}	
	
}
