package net.phptravels.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.phptravels.base.TestBase;
import net.phptravels.pages.AccountPage;
import net.phptravels.pages.HomePage;
import net.phptravels.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;

	//To initialize parent class constructor
	public  HomePageTest(){
		super();
	}

	//To initialize Browser based on congif.properties
	@BeforeMethod
	public void setUp(){
		initialization(prop.getProperty("browser"));
		homepage=new HomePage();
	}

	//Test to display title of homepage
	//@Test(priority=1)
	public void displayTitleTest(){
		String title=homepage.displayTitle();
		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner");
	}

	//Test to navigate to Loginpage
	//@Test(priority=2)
	public void clickOnLoginTest(){
		loginpage=homepage.clickOnLogin();
	}

	//Test to search hotel after user logged in
	@Test(priority=3)
	public void searchHotelTest() throws InterruptedException{
		loginpage=homepage.clickOnLogin();
		accountpage=loginpage.loginPass(prop.getProperty("username"), prop.getProperty("password"));
		homepage=accountpage.clickOnHomeLogo();
		homepage.searchHotel("Dubai","17/04/2018","14/07/2018");
	}

	//Edge Case  with old dates
	@Test(priority=4)
	public void searchHotelTestEdgeCase1() throws InterruptedException{
		loginpage=homepage.clickOnLogin();
		accountpage=loginpage.loginPass(prop.getProperty("username"), prop.getProperty("password"));
		homepage=accountpage.clickOnHomeLogo();
		homepage.searchHotel("Montreal","15/03/2018","14/04/2018");
	}

	//edge case with past checkout date
	@Test(priority=5)
	public void searchHotelTestEdgeCase2() throws InterruptedException{
		loginpage=homepage.clickOnLogin();
		accountpage=loginpage.loginPass(prop.getProperty("username"), prop.getProperty("password"));
		homepage=accountpage.clickOnHomeLogo();
		homepage.searchHotel("Ottawa","16/04/2018","14/02/2018");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
