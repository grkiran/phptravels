package net.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.phptravels.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(xpath="//input[@class='form-control padding-10'][@type='email']")
	WebElement email;

	@FindBy(xpath="//input[@class='form-control padding-10'][@type='password']")
	WebElement password;

	@FindBy(xpath="//button[@class='btn btn-action btn-lg btn-block loginbtn'][@type='submit']")
	WebElement loginButton;

	@FindBy(xpath="//div[contains(text(),'Invalid Email or Password') and @class='alert alert-danger']")
	WebElement errorMsg;

	//To Initialize Object Elements 
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Title Display
	public String displayTitle(){
		return driver.getTitle();
	}

	//Login details with valid username and password
	public AccountPage loginPass(String uname,String pwd) throws InterruptedException{
		email.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return new AccountPage();
	}

	//Login details with valid username and invalid password
	public String loginFail(String suname,String npwd) throws InterruptedException{
		email.sendKeys(suname);
		password.sendKeys(npwd);
		loginButton.click();
		String errormessage=errorMsg.getText();
		return errormessage;



	}

}
