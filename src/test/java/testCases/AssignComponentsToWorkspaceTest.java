package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.WorkspacesPage;

public class AssignComponentsToWorkspaceTest extends TestBase{
	// Variables used on this test
	// This test is going to run against "Workspace for Testing 1" WS
	String msg = "Successfully added Component";
	
	@Test
	public void processes() throws Exception{
//		driver.navigate().refresh();
		WorkspacesPage wspage =  PageFactory.initElements(driver,WorkspacesPage.class);
		
		wspage.CollapseMenu();
		wspage.GotoWS();
		wspage.SelectConfigureWS();
		wspage.SelectWSComponents();
		
		wspage.SelectBCMComponents();
		
		wspage.SaveWSComponents();
		
		wspage.Validation(msg);
	}

}
