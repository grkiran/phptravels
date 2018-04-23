package net.phptravels.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.phptravels.base.TestBase;
import net.phptravels.pages.AccountPage;
import net.phptravels.pages.HomePage;
import net.phptravels.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	AccountPage accountpage;
	HomePage homepage;

	//To initialize parent class constructor
	public LoginPageTest() {
		super();
	}

	//To initialize Browser name  based on congif.properties with navigation to loginpage
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("browser"));
		homepage=new HomePage();
		loginpage=homepage.clickOnLogin();
	}

	//Test to display title of Loginpage
	@Test(priority=1)
	public void displayTitleTest(){
		String title=loginpage.displayTitle();
		System.out.println(title);
	}

	//valid username and password
	@Test(priority=2)
	public void loginPassTest() throws InterruptedException{
		accountpage=loginpage.loginPass(prop.getProperty("username"), prop.getProperty("password"));
	}

	//valid username and invalid password
	@Test(priority=3)
	public void loginFailTest() throws InterruptedException{
		String errormsg =loginpage.loginFail(prop.getProperty("username"), prop.getProperty("wrongpassword"));
		Assert.assertEquals(errormsg, "Invalid Email or Password");
	}

	//close browser
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
