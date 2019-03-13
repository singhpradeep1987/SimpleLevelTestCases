package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_016POM {

	private WebDriver driver; 

	public CYTC_016POM(WebDriver driver) {
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

	@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement accountInformationBtn;
	
	@FindBy(xpath="//td[contains(text(),'Search transactions of manzoor mehadi on Member ac')]")
	private WebElement Memberaccount;
	
	@FindBy(name="query(paymentFilter)")
	private WebElement dropPaymenttype;
	
	@FindBy(xpath="//select[@name='query(paymentFilter)']")
	private WebElement selectedPaymentType;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement SearchBtn;
	
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

	public void clickAccountInfo() {
		this.accountInformationBtn.click();	
	}
	
	public String memberAccount() {
		return this.Memberaccount.getText();
	}
	
	public String clickPaymenttype() {
		this.dropPaymenttype.click();
		Select Paymenttype = new Select(dropPaymenttype);
		Paymenttype.selectByVisibleText("Commission payments");
		return this.selectedPaymentType.getText();
	}
	
	public void clickSearchBtn() {
		this.SearchBtn.click();
	}
}
