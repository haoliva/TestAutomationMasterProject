package pageFactory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import testCases.TestBase;

public class WorkspacesPage {
	WebDriver driver;
	
	public WorkspacesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
	@FindBy(css = "#hide-menu > span:nth-child(1) > a:nth-child(1)") WebElement collapseMenu;
	@FindBy(linkText = "Home") WebElement homeLink;
	
	@FindBy(linkText = "Administration") WebElement administration;
	@FindBy(css="locale-picker.form-control > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > i:nth-child(3)") WebElement localeInNewWS;
	@FindBy(xpath="//div[contains(text(),'English')]") WebElement localeSelectionInWS;
	@FindBy(linkText="Content Administration") WebElement contentAdministration;
	@FindBy(linkText="Workspaces") WebElement workspaces;
	@FindBy(xpath="//button[contains(@tooltip,'New')]") WebElement newWorkspace;
	@FindBy(id="name") WebElement WsName;
	@FindBy(css="workspace-picker.form-control > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > i:nth-child(3)") WebElement parentWS;
//	@FindBy(css="div.ng-untouched > input:nth-child(2)") WebElement parentWSToSelect;
//	@FindBy(xpath="//*[@id=\"form-admin-ws-edit\"]/div/div[2]/div[2]/div[1]/form/div[2]/div/bs-form-group/div/workspace-picker/div/div/span") WebElement parentWSToSelect; 
	@FindBy(xpath="//*[@id=\"form-admin-ws-edit\"]/div/div[2]/div[2]/div[1]/form/div[2]/div/bs-form-group/div/workspace-picker/div/input[1]") WebElement parentWSToSelect;
//	@FindBy(xpath="//div[contains(text(),'Workspaces for Testing')]") WebElement parentWSToSelect;
	@FindBy(css=".btn-primary") WebElement saveWSButton;
	
	@FindBy(xpath="//button[@href='/admin/workspaces/WfT1/']") WebElement selectConfigureWS;
	@FindBy(xpath="//button[@href='/admin/workspaces/WfT/']") WebElement selectConfigureWS_WFT;
	
	@FindBy(xpath="//*[@id=\"form-admin-ws-edit\"]/div") WebElement wsDetailsForm;
	
	@FindBy(xpath="//h5[contains(text(),'Select Component')]") WebElement selectComponent;
	
	@FindBy(xpath="//*[@id=\"form-admin-ws-edit\"]/div/div[2]/div[2]") WebElement componentsTable;
	
	@FindBy(linkText="Manage Groups") WebElement selectManageGroups;
	@FindBy(css=".ink-reaction") WebElement selectNewGroupInWS;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[1]/bs-form-group/div/div[1]/group-picker/div/div/span/i") WebElement authorityGrantGroup;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[1]/bs-form-group/div/div[1]/group-picker/div/input[1]") WebElement EnterAuthorityGrantGroup;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[2]/bs-form-group/div/div[1]/div/span/i") WebElement searchAuthorityGrantRole;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[2]/bs-form-group/div/div[1]/ul/li/div[5]/a/div") WebElement selectAuthorityGrantRole;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[3]/button[1]") WebElement saveAGButton;
	
	@FindBy(xpath="//a[@href='/admin/workspaces/WfT1/components']") WebElement selectWSComponents;
	@FindBy(xpath="//strong[text()='FEMA BCP']") WebElement selectFemaBcpComponent;
	@FindBy(xpath="//strong[text()='BIA Implementation']") WebElement selectBIAComponent;
	@FindBy(xpath="//label[text()='BCP Default Dynamic Guidelines']") WebElement selectFemaBcpGuideline;
	@FindBy(xpath="//label[text()='BIA Default Guidelines']") WebElement selectBIAGuideline;
	@FindBy(xpath="//*[@class='btn btn-primary']") WebElement saveWSComponentsButton;
	
	@FindBy(xpath="//span[contains(text(),'Authority Grant')]") WebElement authorityGrantForm;
	
	@FindBy(xpath="//a[@href='/admin/workspaces/WfT1/authUser']") WebElement selectManageUsers;
	@FindBy(xpath="//*[@class='btn ink-reaction btn-icon-toggle']") WebElement selectNewUserInWS;
	@FindBy(xpath="//span[contains(text(),'usertest01')]") WebElement userToAdd;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[1]/bs-form-group/div/div[1]/user-picker/div/div/span/i") WebElement authorityGrantUser;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[1]/bs-form-group/div/div[1]/user-picker/div/input[1]") WebElement enterAuthorityGrantUser;
	@FindBy(xpath="/html/body/div[7]/div/div/form/div[2]/div[2]/bs-form-group/div/div[1]/ul/li/div[4]/a/div") WebElement selectAuthorityGrantUserRole;
	
	@FindBy(xpath="//span[contains(text(),'Workspaces for Testing')]") WebElement parentWSselect;
	
	@FindBy(xpath="//button[contains(@ng-click-confirm-ok-label,'Archive')]") WebElement archiveWS;
	@FindBy(xpath="/html/body/div[7]/div/div/div/div/p[2]/button[1]") WebElement confirmTask;
	@FindBy(xpath="//button[contains(@ng-click-confirm-ok-label,'purge')]") WebElement purgeWS;

	@FindBy(className = "toast-message") WebElement expectedMessage;
	
	public void CollapseMenu() {
		homeLink.click();
		
		Dimension menuActive = administration.getSize();
		if(menuActive.equals(null))
		{
			collapseMenu.click();
		}
	}
	
	public void GotoWS() throws Exception {
		administration.click();	
		TestBase.weVisible(contentAdministration);
		contentAdministration.click();
		TestBase.weVisible(workspaces);
		workspaces.click();
		TestBase.weVisible(selectConfigureWS_WFT);
	}
	
	public void Workspaces() {
		workspaces.click();		
	}
	
	public void SelectConfigureWS() throws Exception {
		selectConfigureWS.click();
		TestBase.weVisible(wsDetailsForm);
	}
	
	public void SelectWSComponents() throws Exception {
		selectWSComponents.click();
	}
	
	public void SelectManageUsrs() {
		selectManageUsers.click();
	}
	
	public void SelectBCMComponents() throws Exception {
		TestBase.weVisible(selectComponent);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//This will scroll the page till the element is found
//		jse.executeScript("arguments[0].scrollIntoView(false);", selectFemaBcpComponent);
		TestBase.weClickeable(selectFemaBcpComponent);
		selectFemaBcpComponent.click();
		jse.executeScript("arguments[0].scrollIntoView(false);", selectBIAComponent);
		selectBIAComponent.click();
		TestBase.weVisible(selectFemaBcpGuideline);
		selectFemaBcpGuideline.click();
		TestBase.weVisible(selectBIAGuideline);
		selectBIAGuideline.click();
	}
	
	public void NewWSCreation(String wsName, String parentName) throws Exception {
		Actions make = new Actions(driver);
		
		newWorkspace.click();
		WsName.clear();
		WsName.sendKeys(wsName);
		
		Actions msEvent = make.moveToElement(localeInNewWS).click();
		msEvent.perform();
		
		localeSelectionInWS.click();
		
		msEvent = make.moveToElement(parentWS).click();
		msEvent.perform();
		
//		parentWSToSelect.click();
		parentWSToSelect.sendKeys(parentName);
		TestBase.weVisible(parentWSselect);
//		parentWSToSelect.sendKeys(Keys.ENTER);
		parentWSselect.click();
		saveWSButton.click();
	}
	
	public void AssignGroup(String grpName) {
		selectManageGroups.click();
		selectNewGroupInWS.click();
		selectNewGroupInWS.click();
		EnterAuthorityGrantGroup.sendKeys(grpName);
		EnterAuthorityGrantGroup.sendKeys(Keys.ENTER);
		searchAuthorityGrantRole.click();
		selectAuthorityGrantRole.click();
	}
	
	public void NewUserInWS(String usrID) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//This will scroll the page till the element is found
		jse.executeScript("arguments[0].scrollIntoView(false);", selectNewUserInWS);
		selectNewUserInWS.click();
		TestBase.weVisible(authorityGrantForm);
		TestBase.weClickeable(authorityGrantUser);
		authorityGrantUser.click();
//		Thread.sleep(1000);
		enterAuthorityGrantUser.sendKeys(usrID);
		TestBase.weVisible(userToAdd);
//		Thread.sleep(1000);
		enterAuthorityGrantUser.sendKeys(Keys.ENTER);
		searchAuthorityGrantRole.click();
		selectAuthorityGrantUserRole.click();
	}
	
	public void ArchiveWS() throws Exception {
		archiveWS.click();
		TestBase.weClickeable(confirmTask);
		confirmTask.click();
	}
	
	public void PurgeWS() throws Exception {
		TestBase.weClickeable(purgeWS);
		purgeWS.click();
		TestBase.weClickeable(confirmTask);
		confirmTask.click();
	}
	
	public void SaveUsersGroups() {
		saveAGButton.click();
	}
	
	public void SaveWSComponents() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(false);", saveWSComponentsButton);
		saveWSComponentsButton.click();
		Thread.sleep(1500);
	}
		
	public void Validation(String msg) throws Exception {
		TestBase.weVisible(expectedMessage);
		TestBase.ValidationByMessage(msg, expectedMessage);
	}	
}
