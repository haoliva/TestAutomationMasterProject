package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testCases.TestBase;

public class ManageUsersInGroupPage {
	WebDriver driver;
	
	public ManageUsersInGroupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Using FindBy for locating elements
	@FindBy(xpath="//i[@class='caret pull-right']") WebElement searchUserToAddInGroup;
//	@FindBy(css="#form-admin-group-user > div > div.form > table > tbody > tr > td:nth-child(1) > bs-form-group > div > user-picker > div > div > span") WebElement enterUserToAddInGroup;
	@FindBy(xpath="//*[@id=\"form-admin-group-user\"]/div/div[2]/table/tbody/tr/td[1]/bs-form-group/div/user-picker/div/input[1]") WebElement enterUserToAddInGroup;
//	@FindBy(xpath="//span[@tabindex='-1']") WebElement searchUsertoAdd;
	@FindBy(xpath="//input[@class='form-control ui-select-search ng-valid ng-dirty ng-valid-parse ng-touched']") WebElement searchUsertoAdd;
	@FindBy(xpath="//span[contains(text(),'Edit Group Users')]") WebElement editGroupUsersTitle;
	@FindBy(css="button.btn") WebElement addUserToGroup;
	@FindBy(xpath="//span[contains(text(),'BCV Reader')]") WebElement userToAdd;
	
	 @FindBy(xpath="//button[contains(@tooltip,'Remove User')]") WebElement removeUserButton;
	 @FindBy(xpath="/html/body/div[7]/div/div/div/div/p[2]/button[1]") WebElement confirmRemoveUserFromGroup;

	 @FindBy(xpath="//table[@class='table table-striped table-hover table-bordered']/tbody") WebElement table;
	 @FindBy(xpath="//button[contains(@tooltip,'Edit User')]") WebElement editGroupUsers;
	 
	 @FindBy(xpath="//a[contains(text(),'BCV Reader')]") WebElement userFullName;
	 @FindBy(xpath="//h4[contains(text(),'Confirm Action')]") WebElement confirmAction;
	 
	 @FindBy(xpath="/html/body/div[1]/div[1]/div[3]/section/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]") WebElement pleaseWait;

	 @FindBy(className = "toast-message") WebElement expectedMessage;
		
	public void UserInGroup() throws Exception {
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
		
//		new WebDriverWait(driver, 60).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
		try {
		 editGroupUsers.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			WebElement editGroupUsers1 = driver.findElement(By.xpath("//button[contains(@tooltip,'Edit User')]"));
			editGroupUsers1.click();
		}

	}
	
	
	public void AddUserToGroup(String usr) throws Exception {
		TestBase.weVisible(editGroupUsersTitle);
		searchUserToAddInGroup.click();
		enterUserToAddInGroup.sendKeys(usr);
		TestBase.weVisible(userToAdd);
		enterUserToAddInGroup.sendKeys(Keys.ENTER);
		addUserToGroup.click();
	}	
	
	public void RemoveUserFromGroup() throws Exception {
		TestBase.weVisible(editGroupUsersTitle);
		TestBase.weVisible(userFullName);
		TestBase.weClickeable(removeUserButton);
		removeUserButton.click();
		TestBase.weVisible(confirmAction);
		TestBase.weVisible(confirmRemoveUserFromGroup);
		confirmRemoveUserFromGroup.click();
	}
	
}
