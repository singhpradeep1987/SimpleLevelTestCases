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
import com.training.pom.CYTC_020POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_020 {

	/*To verify whether application displays Account information of member*/
		
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
	    private com.training.pom.CYTC_020POM CYTC_020POM;

		@BeforeTest
		public static void setUpBeforeTest() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeClass
		public void setUpClass() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			CYTC_020POM = new CYTC_020POM(driver); 
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
		public void accountInformationTest() {
			
			System.out.println("Account Information Test");
			
			CYTC_020POM.sendUserName("admin");
			CYTC_020POM.sendPassword("123456");
			CYTC_020POM.clickLoginBtn();
			screenShot.captureScreenShot("Test20_First_Login");
			String expected = "Logged user: admin - admini";
			String actual = CYTC_020POM.User();
			Assert.assertEquals(actual, expected);
			System.out.println(actual);
			
			CYTC_020POM.sendMemberLogin("manzoor");
			screenShot.captureScreenShot("Test20_Second_Memberlogin");
			String expected1 = "Profile of manzoor mehadi";
			String actual1;
			actual1 = CYTC_020POM.memberProfile();
			Assert.assertEquals(actual1, expected1);
			System.out.println("Registered member details are getting displayed !");
			
			CYTC_020POM.accountOptions();
			CYTC_020POM.clickAccountInfo();
			String expected2 = "Search results";
			String actual2 = CYTC_020POM.searchResult();
			Assert.assertEquals(actual2, expected2);
			System.out.println("Search transactions on Member account page with all the transactions is getting displayed !");
			
			CYTC_020POM.clickViewIcon();
			String expected3 = "Transaction details";
			String actual3;
			actual3 = CYTC_020POM.transactionDetails();
			Assert.assertEquals(actual3, expected3);
			System.out.println("Transaction details page containing detailed transaction is getting displayed!");
			
			CYTC_020POM.clickBackButton();
			String expected4 = "Search results";
			String actual4 = CYTC_020POM.searchResult();
			Assert.assertEquals(actual4, expected4);
			System.out.println("Search transactions on Member account page with all the transactions is getting displayed !");
			
			CYTC_020POM.clickLogoutBtn();
			String logoutmsg = driver.switchTo().alert().getText();
			Assert.assertEquals( "Please confirm to logout", logoutmsg);
			driver.switchTo().alert().accept();
	}
		
}

