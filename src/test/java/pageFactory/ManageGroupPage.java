package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testCases.TestBase;

public class ManageGroupPage {
	WebDriver driver;
	//String msg = "Group successfully saved";
	
	public ManageGroupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
	@FindBy(css = "#hide-menu > span:nth-child(1) > a:nth-child(1)") WebElement collapseMenu;
	@FindBy(linkText = "Home") WebElement homeLink;
	
	@FindBy(linkText = "Administration") WebElement administration;
	@FindBy(linkText="Security Administration") WebElement securityAdministration;
	@FindBy(linkText="Groups") WebElement groups;
	
	@FindBy(xpath="//button[contains(@tooltip,'New Group')]") WebElement newGroupButton;
	@FindBy(id="groupName") WebElement groupName;
	@FindBy(id="groupDesc") WebElement groupDesc;
	@FindBy(css="button.btn:nth-child(1)") WebElement saveGroupButton;
	
	@FindBy(id="search") WebElement searchGroup;
	@FindBy(xpath="//button[contains(@tooltip,'Edit User')]") WebElement editGroupUsers;
	@FindBy(xpath="//span[contains(text(),'New Group for Testing')]") WebElement grpFound;
	@FindBy(xpath="//*[@id=\"form-admin-group-list\"]/div/div[2]/div[2]/div[1]/div/div[1]/span") WebElement totalGrps;
	@FindBy(xpath="//i[@class=\"caret pull-right\"]") WebElement searchUserToAddInGroup;
	@FindBy(css="input.form-control:nth-child(2)") WebElement enterUserToAddInGroup;
	@FindBy(css="button.btn") WebElement addUserToGroup;
	
	@FindBy(xpath="//strong[contains(text(),'1')]") WebElement totalGroups;
	
	@FindBy(xpath="//*[contains(text(),'New Group for Testing')]") WebElement linkViewGroup;
	@FindBy(xpath="//a[contains(@tooltip,'Manage Users')]") WebElement manageUsers;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover table-bordered']/tbody") WebElement table;
		
	@FindBy(xpath="//button[contains(@tooltip,'View Group')]") WebElement viewGroup;
	@FindBy(xpath="//button[contains(@tooltip,'Edit Group')]    ") WebElement selectEditGroup;
	@FindBy(xpath="//button[contains(@ng-click-confirm-ok-label,'Delete')]") WebElement selectDeleteGroup;

	@FindBy(xpath="//a[contains(@tooltip,'Manage User Roles')]") WebElement selectManageUserRoles;
	@FindBy(xpath="//a[contains(@tooltip,'Grant System Role')]") WebElement selectGrantSystemRole;
//	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[2]/bs-form-group/div/div[1]/div/span") WebElement selectRole;
	@FindBy(xpath="//i[@class=\"caret pull-right\"]") WebElement selectRole;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[2]/bs-form-group/div/div[1]/ul/li/div[3]/a/div") WebElement selectRoleSystemAdministrator;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[3]/button[1]") WebElement addRoleSave;
	
	@FindBy(xpath="//span[contains(text(),'Editing')]") WebElement editing;
	@FindBy(xpath="//span[contains(text(),'Authority Grant')]") WebElement authorityGrant;
	
	@FindBy(xpath="//button[contains(@tooltip,'Remove Group Authorization Grant')]") WebElement selectRemoveGroupAuthorizationGrant;
	@FindBy(xpath="//h4[contains(text(),'Remove Group Authorization Grant')]") WebElement confirmationRemoveGroupAuthorization;
	@FindBy(xpath="/html/body/div[7]/div/div/div/div/p[2]/button[1]") WebElement confirmRemoveGroupAuthorizationGrant;
	
	@FindBy(xpath="//p[contains(text(),'There are currently no authorization granted to this group')]") WebElement grantedAuthorizationsMessage;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/section/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]") WebElement pleaseWait;
	@FindBy(xpath="/html/body/div[7]/div/div/div/div/p[2]/button[1]") WebElement confirmTask;
		
	@FindBy(className = "toast-message") WebElement expectedMessage;
	
	public void CollapseMenu() {
		homeLink.click();
		Dimension menuActive = administration.getSize();
		if(menuActive.equals(null))
		{
			collapseMenu.click();
		}
	}
	
	public void GotoGroups() throws Exception {
		administration.click();
		TestBase.weVisible(securityAdministration);
		securityAdministration.click();
		TestBase.weVisible(groups);
		groups.click();		
	}
	
	public void Groups() {
		groups.click();		
	}
	
	public void NewGroupCreation(String grpName, String grpDesc) throws Exception {
		TestBase.weVisible(newGroupButton);
		newGroupButton.click();
		groupName.clear();
		groupName.sendKeys(grpName);
		groupDesc.clear();
		groupDesc.sendKeys(grpDesc);		
		saveGroupButton.click();
	}
	
	public void SearchGroup(String grpName) throws Exception {
		searchGroup.sendKeys(grpName);
		int count = 0;
		do {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			count = rows.size();
//			System.out.println("table rows: "+count);
		}while(count > 1);
		
		Boolean readyStateComplete = false;
        while (!readyStateComplete)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
        }
	}
	
	public void ViewGroup() throws Exception {
		Actions make = new Actions(driver);
/*		try {
			viewGroup.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement viewGroup1 = driver.findElement(By.xpath("//button[contains(@tooltip,'View Group')]"));
			viewGroup1.click();
		}
*/
		TestBase.weVisible(viewGroup);
		TestBase.weClickeable(viewGroup);
//		viewGroup.click();
		
		Actions msEvent = make.moveToElement(viewGroup).click();
		msEvent.perform();	
	}
	
	public void EditGroup() throws Exception {
		Actions make = new Actions(driver);
		TestBase.weVisible(selectEditGroup);
		TestBase.weClickeable(selectEditGroup);	
		Actions msEvent = make.moveToElement(selectEditGroup).click();
		msEvent.perform();	
	}
	
	public void DeleteGroup() throws Exception {
		TestBase.weVisible(selectDeleteGroup);
		TestBase.weClickeable(selectDeleteGroup);
		selectDeleteGroup.click();
		TestBase.weClickeable(confirmTask);
		confirmTask.click();
	}
	
	
	public void ManageUserRoles() throws Exception {
		TestBase.weClickeable(selectManageUserRoles);
		selectManageUserRoles.click();
		TestBase.weVisible(editing);
//		Thread.sleep(500);		
	}
	
	public void AddRoleToGroup() throws Exception {
		Actions make = new Actions(driver);
		
		selectGrantSystemRole.click();
		TestBase.weVisible(authorityGrant);
//		Thread.sleep(1500);
		Actions msEvent = make.moveToElement(selectRole).click();
		msEvent.perform();
		
		TestBase.weVisible(selectRoleSystemAdministrator);
		selectRoleSystemAdministrator.click();
		
		addRoleSave.click();
//		Thread.sleep(500);
	}
	
	public void RemoveRoleFromGroup() throws Exception {
		selectRemoveGroupAuthorizationGrant.click();
		TestBase.weVisible(confirmationRemoveGroupAuthorization);
		TestBase.weClickeable(confirmRemoveGroupAuthorizationGrant);
		confirmRemoveGroupAuthorizationGrant.click();
		TestBase.weVisible(grantedAuthorizationsMessage);
//		Thread.sleep(500);
	}
		
	public void Validation(String msg) throws Exception {
		TestBase.weVisible(expectedMessage);
		TestBase.ValidationByMessage(msg, expectedMessage);
	}	
}
