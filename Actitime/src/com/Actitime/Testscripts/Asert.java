package com.Actitime.Testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asert {
	@Test
	public void Demoassertion() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String expectedTitle = "soogle";
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(expectedTitle,actualTitle);
		SoftAssert s= new SoftAssert();
		s.assertEquals(expectedTitle,actualTitle );
		driver.close();
		s.assertAll();
	}

}
