package net.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.phptravels.base.TestBase;

public class AccountPage extends TestBase {

	@FindBy(xpath="//h3[@class='RTL'and contains(text(),'Hi, DVhbCERv IlqEZZxz')]")
	WebElement loginName;
	
	@FindBy(xpath="//div[@class='col-md-4 col-sm-3 col-xs-7 go-right']//a//img[@src='http://www.phptravels.net/uploads/global/logo.png' and @class='logo']")
	WebElement homeLogo;
		
	//To Initialize Object Elements 
	public AccountPage(){
		PageFactory.initElements(driver,this);
	}
	
	//Title Display
	public String pageTitle(){
		return driver.getTitle();
	}
	
	//Login name verification
	public String verifyLoginName() throws InterruptedException{
		return loginName.getText();
	}
	
	//to navigate to home page
	public HomePage clickOnHomeLogo(){
		homeLogo.click();
		return new HomePage();
		
	}
	
}
