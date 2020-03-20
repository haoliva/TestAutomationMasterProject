package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageRolesPage;

public class CreateNewSystemRoleTest  extends TestBase{
	// Variables used on this test
	String roleNm = "New System Role for Testing";
	String roleDsc = "Role created by Automation Testing";
	
	@Test
	public void processes() throws Exception{
		ManageRolesPage mrpage =  PageFactory.initElements(driver,ManageRolesPage.class);
		
		mrpage.CollapseMenu();
		mrpage.GotoRoles();
		mrpage.AddRole(roleNm, roleDsc);
		
		mrpage.SearchRole(roleNm);
		
		mrpage.Validation(roleNm);
	}

}
