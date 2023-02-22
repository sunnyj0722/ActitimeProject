package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.LogoutHomePage;
import com.Actitime.pom.TaskPage;

public class CreateCustomer extends BaseClass {
	FileLibrary flib=new FileLibrary();
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException {
		LogoutHomePage hp=new LogoutHomePage(driver);
		hp.getTasklnk().click();
		TaskPage tp=new TaskPage(driver);
	     String Custname = flib.readDataFromExcelFile("Sheet1", 2, 1);
		 String Description = flib.readDataFromExcelFile("Sheet1",2,1);
		tp.completetask(Custname, Description);
		  
	}
	

		
	}
	
	


