package testCases;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LoginPage;;

public class LoginTest extends TestBase{
	
	Workbook wb;
	Sheet sh;
	int nrows;
	int ncols;
	
	@DataProvider
	public Object[][]testDataFeed() throws Exception{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Hernan\\Selenium\\TestAutomationMasterProject\\src\\test\\resources\\data\\loginData.xlsx");
		                                           
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("loginData");
		
		nrows = sh.getLastRowNum()+1;
		
		ncols = sh.getRow(0).getLastCellNum();
		
		Object[][] loginData = new Object[nrows][ncols];
		
		for(int i=0;i<nrows; i++) {
			for(int j=0; j<ncols; j++) {
				loginData[i][j] = sh.getRow(i).getCell(j).toString();
				//System.out.println(loginData[i][j]);				
			}
		}

		return loginData;	
	}

	@Test(dataProvider="testDataFeed")
	public void processes(String URL,String userName,String passWord) throws Exception{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.getURL(URL);
		TestBase.weVisible(loginpage.username);
		loginpage.setUser(userName);
		loginpage.setPassword(passWord);
		loginpage.clickOnLoginButton();
		TestBase.weVisible(loginpage.homeLink);
		loginpage.HomePage();
		System.out.println("Test Successful: Login process is Complete!");
		
	}
}
