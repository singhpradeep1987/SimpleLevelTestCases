package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_020POM {

	private WebDriver driver; 

	public CYTC_020POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cyclosUsername")
	private WebElement userName; 

	@FindBy(id="cyclosPassword")
	private WebElement password;

	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn;
	
	@FindBy (xpath="//span[contains(text(),'Logged user: admin - admini')]")
	private WebElement user;

	@FindBy (id="memberUsername")
	private WebElement member;

	@FindBy(xpath="/html/body[@class='main']/div[@class='layoutMain']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='defaultTableContent'][2]/tbody/tr[2]/td[@class='tdContentTableForms innerBorder']/table[@class='defaultTable']/tbody/tr[1]/td[2]/div[@id='membersByUsername']/ul/li[@class='selected']")
	private WebElement memberLogin;
	
	@FindBy(xpath="//td[contains(text(),'Profile of manzoor mehadi')]")
	private WebElement profile;
	
	@FindBy (xpath="//tr[5]//td[1]//fieldset[1]")
	private WebElement account;

	@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement accountInformationBtn;
	
	@FindBy(xpath="//td[contains(text(),'Search results')]")
	private WebElement accountSearchResults;
	
	@FindBy(xpath="//tr[2]//td[5]//img[1]")
	private WebElement viewIcon;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement transaction;
	
	@FindBy(id = "backButton")
	private WebElement backBut;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	
	public String User() {
		return user.getText();
	}

	public void sendMemberLogin(String member) {
		this.member.clear();
		this.member.sendKeys(member);
		Actions action = new Actions(this.driver);
		action.moveToElement(memberLogin);
		action.click();
		action.perform();
	}
	
	public String memberProfile() {
		return this.profile.getText();
	}
	
	public void accountOptions() {
		this.account.isDisplayed();
		System.out.println("following links are getting displayed under" +  "\n" + account.getText());
	}
	
	public void clickAccountInfo() {
		this.accountInformationBtn.click();	
	}
	
	public String searchResult() {
		return this.accountSearchResults.getText();
	}
	
	public void clickViewIcon() {
		this.viewIcon.click();
	}
	
	public String transactionDetails() {
		return this.transaction.getText();
	}
	
	public void clickBackButton() {
		this.backBut.click();
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}
}
