package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageGroupPage;

public class CreateNewGroupTest  extends TestBase{
	// Variables used on this test
	String grpName = "New Group for Testing";
	String grpDesc = "Group created by Automation Testing";
	String msg = "Group successfully saved";
	
	@Test
	public void processes() throws Exception{
		ManageGroupPage groupspage =  PageFactory.initElements(driver,ManageGroupPage.class);
		
		groupspage.CollapseMenu();
		groupspage.GotoGroups();
		groupspage.NewGroupCreation(grpName, grpDesc);
		
		groupspage.Validation(msg);
	}

}
