package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.WorkspacesPage;

public class AssignGroupsToWorkspaceTest extends TestBase{
	// Variables used on this test
	String grpName = "New Group for Testing";
	String msg = "Authorization Granted Successfully";
	
	@Test
	public void processes() throws Exception{
		driver.navigate().refresh();
		WorkspacesPage wspage =  PageFactory.initElements(driver,WorkspacesPage.class);
		
		wspage.CollapseMenu();
		wspage.AssignGroup(grpName);
		
		wspage.SaveUsersGroups();
		
		wspage.Validation(msg);
	}

}
