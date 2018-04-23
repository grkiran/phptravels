package net.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import net.phptravels.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement MyAccount;
	
	@FindBy(xpath="//html//div[@class='tbar-top hidden-sm hidden-xs']//li[@id='li_myaccount']//li[1]/a[1]")
	WebElement Login;

	//For Searching Hotels
	@FindBy(xpath="//span[@class='hidden-xs'][contains(text(),'Hotels')]")
	WebElement hotelLable;

	//enter location
	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/a[1]/span[1]")
	WebElement locationName;

	//select location
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//ul[@class='select2-results']")
	WebElement locationSelect;

	//Check-in date of hotel
	@FindBy(xpath="//input[@placeholder='Check in' and @class='form input-lg dpd1']")
	WebElement checkIn;

	//check out date of hotel
	@FindBy(xpath="//input[@placeholder='Check out' and @class='form input-lg dpd2']")
	WebElement checkOut;

	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/select[1]")
	WebElement adultSelect;

	//select number of adults
	@FindBy(xpath="//parent::select[@name='adults']//option[@value='1']")
	WebElement adultValue;

	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/select[1]")
	WebElement childSelect;

	//select number of children
	@FindBy(xpath="//parent::select[@name='child']//option[@value='1']")
	WebElement childValue;

	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[3]/button[1]")
	WebElement searchButton;

	//To Initialize Object Elements 
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Title Display
	public String displayTitle(){
		return driver.getTitle();
	}

	//to navigate to Login Page
	public LoginPage  clickOnLogin(){
		MyAccount.click();
		Login.click();
		return new LoginPage();
	}

	//To search a hotel
	public void searchHotel(String loc,String checkin,String checkout) throws InterruptedException{
		hotelLable.click();
		locationName.click();
		locationName.sendKeys(loc);
		locationSelect.click();
		locationSelect.click();
		checkIn.clear();
		checkIn.sendKeys(checkin);
		checkOut.clear();
		checkOut.sendKeys(checkout);
		adultSelect.click();
		adultValue.click();
		childSelect.click();
		childValue.click();
		searchButton.click();
	}

}