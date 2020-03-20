package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageGroupPage;

public class RemoveRoleFromGroupTest extends TestBase{
	// Variables used on this test
	String grpName = "New Group for";
	String msg = "Authorization Removed Successfully";
	
	@Test
	public void processes() throws Exception{
//		driver.navigate().refresh();
		ManageGroupPage mgpage =  PageFactory.initElements(driver,ManageGroupPage.class);
		
		mgpage.CollapseMenu();
		mgpage.GotoGroups();
		
		mgpage.SearchGroup(grpName);
		mgpage.ViewGroup();
		mgpage.ManageUserRoles();
		
		mgpage.RemoveRoleFromGroup();
	
		mgpage.Validation(msg);
	}

}
