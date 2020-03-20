package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageGroupPage;
import pageFactory.ManageUsersInGroupPage;

public class RemoveUserFromGroupTest  extends TestBase{
	// Variables used on this test
	String grp = "New Group for";
	String msg = "Removed User BCV Reader from Group";
	
	@Test
	public void processes() throws Exception{
		ManageGroupPage groupspage =  PageFactory.initElements(driver,ManageGroupPage.class);
		
//		groupspage.Groups();
//		groupspage.SearchGroup(grp);
		
		ManageUsersInGroupPage muingp = PageFactory.initElements(driver, ManageUsersInGroupPage.class);
		
//		muingp.UserInGroup();
		muingp.RemoveUserFromGroup();		
		groupspage.Validation(msg);
	}

}
