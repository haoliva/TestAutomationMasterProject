package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testCases.TestBase;

public class ManageRolesPage {
	WebDriver driver;
	
	public ManageRolesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
	@FindBy(css = "#hide-menu > span:nth-child(1) > a:nth-child(1)") WebElement collapseMenu;
	@FindBy(linkText = "Home") WebElement homeLink;
	
	@FindBy(linkText = "Administration") WebElement administration;
	@FindBy(linkText="Security Administration") WebElement securityAdministration;
	@FindBy(linkText="Roles") WebElement roles;
	
	@FindBy(xpath="//button[contains(@tooltip,'New Role')]") WebElement newRoleButton;
	@FindBy(id="name") WebElement roleName;
	@FindBy(id="description") WebElement roleDesc;
	@FindBy(id="role_type_system") WebElement roleTypeSystem;
	@FindBy(xpath="//*[@id='ADMIN']") WebElement administratorOnOff;
	@FindBy(css="button.btn:nth-child(1)") WebElement saveRoleButton;
	@FindBy(xpath="//span[contains(text(),'New System Role for Testing')]") WebElement systemRoleCreated;
	@FindBy(id="search") WebElement searchRole;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover table-bordered']/tbody") WebElement table;
	
	@FindBy(xpath="//button[contains(@tooltip,'Delete Role')]") WebElement selectDeleteRole;
	@FindBy(xpath="/html/body/div[7]/div/div/div/div/p[2]/button[1]") WebElement confirmDeleteRole;
	
	@FindBy(className = "toast-message") WebElement expectedMessage;
	
	public void CollapseMenu() {
		homeLink.click();
		Dimension menuActive = administration.getSize();
		if(menuActive.equals(null))
		{
			collapseMenu.click();
		}
	}
	
	public void GotoRoles() throws Exception {
		administration.click();
		TestBase.weVisible(securityAdministration);
		securityAdministration.click();
		TestBase.weVisible(roles);
		roles.click();		
	}
	
	public void AddRole(String roleNm, String roleDsc) throws Exception {
		TestBase.weClickeable(newRoleButton);
		newRoleButton.click();
		roleName.clear();
		roleName.sendKeys(roleNm);
		roleDesc.clear();
		roleDesc.sendKeys(roleDsc);
		roleTypeSystem.click();
		TestBase.weVisible(administratorOnOff);
//		Thread.sleep(1000);
		saveRoleButton.click();
//		Thread.sleep(1500);
	}	
	
	public void DeleteRole() throws Exception {
		TestBase.weClickeable(selectDeleteRole);
		selectDeleteRole.click();
		TestBase.weClickeable(confirmDeleteRole);
		confirmDeleteRole.click();
//		Thread.sleep(1000);
	}
	
	public void SearchRole(String roleNm) throws Exception {
		TestBase.weVisible(searchRole);
		searchRole.sendKeys(roleNm);
		int count = 0;
		do {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			count = rows.size();
		}while(count > 1);
		
		Boolean readyStateComplete = false;
        while (!readyStateComplete)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
        }
//		Thread.sleep(1000);
	}
	
	public void Validation(String msg) throws Exception {
		WebElement systemRoleCreated1 = null;
		int count = 0;
		do {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			count = rows.size();
		}while(count > 1);
		
		Boolean readyStateComplete = false;
        while (!readyStateComplete)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
        }
		try {
			TestBase.weVisible(systemRoleCreated);
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				systemRoleCreated1 = driver.findElement(By.xpath("//span[contains(text(),'New System Role for Testing')]"));
				TestBase.weVisible(systemRoleCreated1);
			}

		TestBase.ValidationByElement(msg, systemRoleCreated1);
	}	
	
	public void ValidationMsg(String msg) throws Exception {
		TestBase.weVisible(expectedMessage);
		TestBase.ValidationByMessage(msg, expectedMessage);
	}	
	
}
