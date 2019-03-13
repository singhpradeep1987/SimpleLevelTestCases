package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_016 {
	
    /* To Verify whether application allows admin to display Accounts details of a particular member
       based on the search criteria*/
	
	private WebDriver driver;
	private String baseUrl;
	private com.training.pom.CYTC_016POM CYTC_016POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeTest() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUpClass() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		CYTC_016POM = new com.training.pom.CYTC_016POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void displayAccountdetailsTest() {
		System.out.println("Display Account Details Test");
		
		CYTC_016POM.sendUserName("admin");
		CYTC_016POM.sendPassword("123456");
		CYTC_016POM.clickLoginBtn();
		screenShot.captureScreenShot("Test16_First_Login");
		String expected = "Logged user: admin - admini";
		String actual = CYTC_016POM.User();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
		CYTC_016POM.sendMemberLogin("manzoor");
		screenShot.captureScreenShot("Test16_Second_Memberlogin");
		String expected1 = "Profile of manzoor mehadi";
		String actual1;
		actual1 = CYTC_016POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are getting displayed !");
		
		CYTC_016POM.clickAccountInfo();
		screenShot.captureScreenShot("Test16_Third_Accountinfo");
		String expected2 = "Search transactions of manzoor mehadi on Member account";
		String actual2;
		actual2 = CYTC_016POM.memberAccount();
		Assert.assertEquals(actual2, expected2);
		System.out.println("Account transactions of manzoor mehadi on Member account page with transaction details is getting displayed !");
		
		CYTC_016POM.clickPaymenttype();
		screenShot.captureScreenShot("Test16_Forth_Paymenttype");
		
		CYTC_016POM.clickSearchBtn();
		screenShot.captureScreenShot("Test16_Fifth_Searchresult");
		System.out.println("Transaction details matching search criteria is getting displayed");
	}
}
