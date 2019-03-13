package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_017POM {

	private WebDriver driver; 

	public CYTC_017POM(WebDriver driver) {
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
	
	@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")
	private WebElement paymentSystemBtn;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement paymentSystemTitle;
	
	@FindBy(name="amount")
	private WebElement amountText;
	
	@FindBy(xpath="//select[@name='type']")
	private WebElement transactionType;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(id="submitButton")
	private WebElement PaymentSubmit;
	
	@FindBy(xpath="//td[@class='label']")
	private WebElement transactionConfirmation;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement ConfirmTransaction;
	
	@FindBy(xpath="//td[@align='center']")
	private WebElement PaymentSuccessful;
	
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

	public void clickPaymentSystem() {
		this.paymentSystemBtn.click();
	}
	
	public String paymentSystemScreen() {
		return this.paymentSystemTitle.getText();
	}
	
	public void enterPaymentAmount(String amountText) {
		this.amountText.clear();
		this.amountText.sendKeys(amountText);
	}
	
	public String paymentAmount() {
		return this.amountText.getText();
	}
	
	public void transactionType() {
		this.transactionType.click();
		Select Transactiontype = new Select(transactionType);
		Transactiontype.selectByVisibleText("Debit to member");
	}	
	
	public void description(String description) {
		this.description.clear();
		this.description.sendKeys("description");
	}
	
	public void submitPayment() {
	    this.PaymentSubmit.click();
	}
	
	public String transactionConfirmationScreen() {
		return this.transactionConfirmation.getText();
	}
	
	public String confirmTransaction() {
		this.ConfirmTransaction.click();
		return this.PaymentSuccessful.getText();
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}

}
