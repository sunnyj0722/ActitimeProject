package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;
import com.Actitime.pom.LogoutHomePage;

public class BaseClass {
	 public static WebDriver driver;
	 FileLibrary f=new FileLibrary();

	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
		
	}
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database diconnected",true);
		
	}
	@BeforeClass
	public void launchBrowser() throws IOException
	{
	     driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  FileLibrary f=new FileLibrary();
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("browser launched successfully ",true);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		
		Reporter.log("browser closed successfully ",true);
	}
	@BeforeMethod
	public void LoginToActitime() throws IOException {
		 String Un = f.readDataFromPropertyFile("username");
		 String PWD = f.readDataFromPropertyFile("password");
		 LoginPage lp =new LoginPage(driver);
		lp.login(Un, PWD);
		Reporter.log("logged in successfully",true);
	}
	@AfterMethod
	public void LogoutFromeActitime() throws InterruptedException {
		Thread.sleep(5000);
		LogoutHomePage hp=new LogoutHomePage(driver);
		Thread.sleep(3000);
		hp.getLogoutlnk().click();
		Reporter.log("logout successfully",true);
	}
	
}

