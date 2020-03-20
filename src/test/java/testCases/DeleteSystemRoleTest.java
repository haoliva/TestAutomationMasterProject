package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ManageRolesPage;

public class DeleteSystemRoleTest  extends TestBase{
	// Variables used on this test
	String roleNm = "New System Role";
	String msg = "Role New System Role for Testing deleted successfully";
	
	@Test
	public void processes() throws Exception{
//		driver.navigate().refresh();
		ManageRolesPage mrpage =  PageFactory.initElements(driver,ManageRolesPage.class);
		
		mrpage.CollapseMenu();
		mrpage.GotoRoles();
		
		mrpage.SearchRole(roleNm);

		mrpage.DeleteRole();
		
		mrpage.ValidationMsg(msg);
	}

}
