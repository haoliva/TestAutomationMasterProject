package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageGroupPage;
import pageFactory.ManageUsersInGroupPage;

public class AddUserToGroupTest  extends TestBase{
	// Variables used on this test
	String grp = "New Group for";
	String usr = "bcv reader";
	String msg = "Added User undefined to Group";
	
	@Test
	public void processes() throws Exception{
		ManageGroupPage groupspage =  PageFactory.initElements(driver,ManageGroupPage.class);
		
		groupspage.CollapseMenu();
		groupspage.GotoGroups();
		
		groupspage.SearchGroup(grp);
		
		ManageUsersInGroupPage muigp = PageFactory.initElements(driver, ManageUsersInGroupPage.class);
		
		muigp.UserInGroup();
		muigp.AddUserToGroup(usr);		
		groupspage.Validation(msg);
	}

}
