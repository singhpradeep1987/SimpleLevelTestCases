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

public class CYTC_017 {

	  /*To Verify whether application allows admin to make the payment for member*/
	
	private WebDriver driver;
	private String baseUrl;
	private com.training.pom.CYTC_017POM CYTC_017POM;
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
		CYTC_017POM = new com.training.pom.CYTC_017POM(driver); 
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
	public void makePaymentTest() {
		
		System.out.println("Making Payment Test");
		
		CYTC_017POM.sendUserName("admin");
		CYTC_017POM.sendPassword("123456");
		CYTC_017POM.clickLoginBtn();
		screenShot.captureScreenShot("Test17_First_Login");
		String expected = "Logged user: admin - admini";
		String actual = CYTC_017POM.User();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
		CYTC_017POM.sendMemberLogin("manzoor");
		screenShot.captureScreenShot("Test17_Second_Memberlogin");
		String expected1 = "Profile of manzoor mehadi";
		String actual1;
		actual1 = CYTC_017POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are getting displayed !");
		
		CYTC_017POM.clickPaymentSystem();
		screenShot.captureScreenShot("Test17_Third_PaymentSystem");
		String expected2 = "Payment system to member";
		String actual2;
		actual2 = CYTC_017POM.paymentSystemScreen();
		Assert.assertEquals(actual2, expected2);
		System.out.println("Payment system to member page is getting displayed !");
		
		CYTC_017POM.enterPaymentAmount("5,00");
		screenShot.captureScreenShot("Test17_Fourth_enterPaymentAmount");
		CYTC_017POM.transactionType();
		CYTC_017POM.description("bonus");
		System.out.println("Payment description added sucessfully");
		
		CYTC_017POM.submitPayment();
		String expected3 = "You are about to perform the following payment:";
		String actual3;
		actual3 = CYTC_017POM.transactionConfirmationScreen();
		Assert.assertEquals(actual3, expected3);
		System.out.println("You are about to perform the following payment: page with entered details is getting displayed !");
		
		CYTC_017POM.confirmTransaction();
		screenShot.captureScreenShot("Test17_Fifth_Transactionconfirm");
		String expected4 = "The payment has been performed";
		String actual4;
		actual4 = CYTC_017POM.confirmTransaction();
		Assert.assertEquals(actual4, expected4);
		System.out.println("The payment has been performed  message is getting displayed !");
		
		CYTC_017POM.clickLogoutBtn();
		String logoutmsg = driver.switchTo().alert().getText();
		Assert.assertEquals( "Please confirm to logout", logoutmsg);
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("Test17_Sixth_LogoutSucessfull");
	}
}