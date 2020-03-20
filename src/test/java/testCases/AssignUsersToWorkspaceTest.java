package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.WorkspacesPage;

public class AssignUsersToWorkspaceTest extends TestBase{
	// Variables used on this test
	String usrID = "usertest01";
	String msg = "Authorization Granted Successfully";
	
	@Test
	public void processes() throws Exception{
		WorkspacesPage wspage =  PageFactory.initElements(driver,WorkspacesPage.class);
		
		wspage.CollapseMenu();
		wspage.GotoWS();
		wspage.SelectConfigureWS();
		wspage.SelectManageUsrs();
		wspage.NewUserInWS(usrID);
		
		wspage.SaveUsersGroups();
		
		wspage.Validation(msg);
	}

}
