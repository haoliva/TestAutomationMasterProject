package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.WorkspacesPage;

public class CreateNewWorkspaceTest  extends TestBase{
	// Variables used on this test
	String wsName = "Workspace for Testing 1";
	String parentName = "Workspaces for Testing";
//	String msg = "Successfully saved workspace: Workspace for Testing 1.";
	String msg = "Successfully saved workspace: undefined.";
	
	@Test
	public void processes() throws Exception{
//		driver.navigate().refresh();
		WorkspacesPage wspage =  PageFactory.initElements(driver,WorkspacesPage.class);
		
		wspage.CollapseMenu();
		wspage.GotoWS();
		wspage.NewWSCreation(wsName,parentName);
		
		wspage.Validation(msg);
	}

}
