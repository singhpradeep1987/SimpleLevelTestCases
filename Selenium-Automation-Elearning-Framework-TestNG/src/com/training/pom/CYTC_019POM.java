package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_019POM {

	private WebDriver driver; 

	public CYTC_019POM(WebDriver driver) {
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

	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement GrantloanBtn;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement grantLoanText;
	
	@FindBy(name="loan(amount)")
	private WebElement loanamountText;
	
	@FindBy(name="loan(description)")
	private WebElement loandescriptionText;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement loanSubmitBtn;
	
	@FindBy(xpath="//td[@class='label']")
	private WebElement loanConfirmationmessage;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement loanConfirmSubmitBtn;
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement viewloanBtn;
	
	@FindBy(xpath="//td[contains(text(),'Loans of manzoor mehadi')]")
	private WebElement loanList;
	
	@FindBy(xpath="//input[@value='CLOSED']")
	private WebElement ClosedradioBtn;
	
	@FindBy(xpath="//input[@value='OPEN']")
	private WebElement OpenedradioBtn;
	
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

	public void loangrantBtn() {
		this.GrantloanBtn.click();
	}
	
	public String grantLoanScreen() {
		return this.grantLoanText.getText();
	}
	
	public void sendloanAmount(String loanamountText) {
		this.loanamountText.clear();
		this.loanamountText.sendKeys(loanamountText);
	}
	
	public void sendloanDescription(String loandescription) {
		this.loandescriptionText.clear();
		this.loandescriptionText.sendKeys(loandescription);
	}
	
	public void loansubmitBtn() {
		this.loanSubmitBtn.click();
	}
	
	public String loanConfirmationScreen() {
		return this.loanConfirmationmessage.getText();
	}
	
	public void loanconfirmationsubmitBtn() {
		this.loanConfirmSubmitBtn.click();
	}
	
	public void loanviewBtn() {
		this.viewloanBtn.click();
	}
	
	public String loanViewScreen() {
		return this.loanList.getText();
	}
	
	public void closedLoanradioBtn() {
		this.ClosedradioBtn.click();
	}
	
	public void openedLoanBtn() {
		this.OpenedradioBtn.click();
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}

}
