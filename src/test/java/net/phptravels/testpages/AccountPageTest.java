package net.phptravels.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.phptravels.base.TestBase;
import net.phptravels.pages.AccountPage;
import net.phptravels.pages.HomePage;
import net.phptravels.pages.LoginPage;

public class AccountPageTest extends TestBase{

	AccountPage accountpage;
	LoginPage loginpage;
	HomePage homepage;

	public AccountPageTest(){
		super();
	}

		
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization(prop.getProperty("browser"));
		homepage=new HomePage();
		loginpage= new LoginPage();
		loginpage=homepage.clickOnLogin();
		accountpage=loginpage.loginPass(prop.getProperty("username"), prop.getProperty("password"));
	}

	//To check verify username
	@Test(priority=1)
	public void verifyLoginNameTest() throws InterruptedException{
		String loginName=accountpage.verifyLoginName();
		Assert.assertEquals(loginName, "Hi, DVhbCERv IlqEZZxz");
	}
	
	//To navigate to home page
	@Test(priority=2)
	public void clickHomeLogoTest(){
		homepage=accountpage.clickOnHomeLogo();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
