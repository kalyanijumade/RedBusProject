package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.sun.jmx.mbeanserver.GetPropertyAction;

public class TestBase {
	
	 public  WebDriver driver;
	 public Properties pro ;
	 public  FileInputStream fis;
	 public ChromeOptions options;
	
	 
	@BeforeMethod
	public WebDriver initializeDriver() throws IOException {
		//chrome option for disabling the Notification Alert
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		fis = new FileInputStream("D:\\KalyaniWorkspace\\AutomationTesting\\RedBusProject\\src\\main\\java\\com\\config\\config.properties");
		pro = new Properties(); 
		 pro.load(fis);
	String browserName = pro.getProperty("Browser");
	
	if(browserName.equals("Chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\KalyaniWorkspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
	}
	else if(browserName.equals("firefox")) {
		
		System.setProperty("webdriver.", "");
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
	}

	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
