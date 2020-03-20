package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.WorkspacesPage;

public class ArchivePurgeWorkspaceTest extends TestBase{
	// Variables used on this test
//	String usrID = "usertest01";
	String msg1 = "Workspace was successfully archived";
	String msg2 = "Workspace was successfully purged";
	
	@Test
	public void processes() throws Exception{
//		driver.navigate().refresh();
		WorkspacesPage wspage =  PageFactory.initElements(driver,WorkspacesPage.class);
		
		wspage.CollapseMenu();
		wspage.GotoWS();
		wspage.SelectConfigureWS();
		wspage.ArchiveWS();
		
		wspage.Validation(msg1);
		
		wspage.PurgeWS();
		
		wspage.Validation(msg2);
	}

}
