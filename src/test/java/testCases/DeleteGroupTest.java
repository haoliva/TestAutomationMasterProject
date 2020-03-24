package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageGroupPage;

public class DeleteGroupTest  extends TestBase{
	// Variables used on this test
	String grp = "New Group for";
	String msg = "Group deleted successfully";
	
	@Test
	public void processes() throws Exception{
		ManageGroupPage groupspage =  PageFactory.initElements(driver,ManageGroupPage.class);
		
//		groupspage.CollapseMenu();
//		groupspage.GotoGroups();
		
		groupspage.SearchGroup(grp);
		
		groupspage.EditGroup();
		
		groupspage.DeleteGroup();
		
		groupspage.Validation(msg);
	}

}
