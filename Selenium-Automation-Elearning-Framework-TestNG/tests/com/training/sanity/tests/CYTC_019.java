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

public class CYTC_019 {

/*To verify whether application allows admin to display the loans granted details for member based on 
 * the filtered criteria should get displayed*/
	
	private WebDriver driver;
	private String baseUrl;
	private com.training.pom.CYTC_019POM CYTC_019POM;
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
		CYTC_019POM = new com.training.pom.CYTC_019POM(driver); 
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
	public void viewLoanTest() {
		
		System.out.println("Loans granted details for member based on the filtered criteria test");
		
		CYTC_019POM.sendUserName("admin");
		CYTC_019POM.sendPassword("123456");
		CYTC_019POM.clickLoginBtn();
		screenShot.captureScreenShot("Test19_First_Login");
		String expected = "Logged user: admin - admini";
		String actual = CYTC_019POM.User();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
		CYTC_019POM.sendMemberLogin("manzoor");
		screenShot.captureScreenShot("Test19_Second_Memberlogin");
		String expected1 = "Profile of manzoor mehadi";
		String actual1;
		actual1 = CYTC_019POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are getting displayed !");
		
		CYTC_019POM.loangrantBtn();
		String expected2 = "Grant loan to manzoor mehadi";
		String actual2;
		actual2 = CYTC_019POM.grantLoanScreen();
		Assert.assertEquals(actual2, expected2);
		System.out.println("Grant loan to manzoor mehadi page is getting displayed !");
		
		CYTC_019POM.sendloanAmount("100000");
		CYTC_019POM.sendloanDescription("home loan");
		screenShot.captureScreenShot("Test19_Third_LoanRequest");
		CYTC_019POM.loansubmitBtn();
		String expected3 = "You are about to grant the following loan:";
		String actual3;
		actual3 = CYTC_019POM.loanConfirmationScreen();
		Assert.assertEquals(actual3, expected3);
		System.out.println("You are about to grant the following loan: with loan details is getting displayed !");
		
		CYTC_019POM.loanconfirmationsubmitBtn();
		String loangrantedmsg = driver.switchTo().alert().getText();
		Assert.assertEquals( "The loan was successfully granted", loangrantedmsg);
		System.out.println(loangrantedmsg);
		driver.switchTo().alert().accept();
		
		CYTC_019POM.loanviewBtn();
		String expected4 = "Loans of manzoor mehadi";
		String actual4 = CYTC_019POM.loanViewScreen();
		Assert.assertEquals(actual4, expected4);
		System.out.println(actual1 + "list of loans displayed which are in open status");
		
		CYTC_019POM.closedLoanradioBtn();
		System.out.println("loans closed by the member is getting displayed");
		
		CYTC_019POM.openedLoanBtn();
		System.out.println("loans opened by the member is getting displayed");
		
		CYTC_019POM.clickLogoutBtn();
		String logoutmsg = driver.switchTo().alert().getText();
		Assert.assertEquals( "Please confirm to logout", logoutmsg);
		driver.switchTo().alert().accept();		
	}
}

