package net.phptravels.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	//to load and initialize config.properties
	public TestBase(){

		try {
			prop = new Properties();
			FileInputStream fileobj = new FileInputStream("C:/Users/GRK/testhome/phptravels1/src/main/java/net/phptravels/config/cofig.properties");
			prop.load(fileobj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Select browser name from config.properties
	public void initialization(String browser){
		switch (browser) {
		case "ff":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:/Users/GRK/testhome/phptravels/src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:/Users/GRK/testhome/phptravels/src/test/resources/chromedriver1.exe" );
			driver = new ChromeDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Please select browsers : ff or chrome or ie");
			break;
		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	}


}
