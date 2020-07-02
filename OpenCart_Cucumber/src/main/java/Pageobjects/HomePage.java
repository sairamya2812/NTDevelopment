package Pageobjects;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackage.BaseClass;

public class HomePage extends BaseClass {
	HomePage hp;
	public static CreateAccount cap;
	
	@FindBy(xpath="//img[@title='Your Store']")
	public WebElement opencartlogo;
	@FindBy(linkText="My Account")
	public WebElement myaccount;
	@FindBy(linkText="Register")
	public WebElement register;
	@FindBy(linkText="Login")
	public WebElement login;
	@FindBy(id="input-email")
	public WebElement email;
	@FindBy(id="input-password")
	public WebElement pwd;
	@FindBy(xpath="//input[@type='submit']")
	public WebElement LoginBtn;
@FindBy(id="details-button")
public WebElement advanced;
@FindBy(linkText="Logout")
public WebElement logoutlink;
@FindBy(id="proceed-link")
public WebElement proceedtolink;
	 public HomePage() {

		PageFactory.initElements(driver, this);
	}
	 public void proceedToLink()
	 
	 {
		 advanced.click();
		 proceedtolink.click();
	 }
public String validateHomepageTitle()
{return elementpagetitle();
}
public boolean opencartLogo()
{return elementgetdisplayed(opencartlogo);}
 
public HomePage login(String emailadd, String password)
{
	myaccount.click();
	login.click();
	elementsendkeys(emailadd, email);
	elementsendkeys(password, pwd);
	LoginBtn.click();;
	return new HomePage();
}

	public CreateAccount createAcc()
{
	myaccount.click();
	register.click();
	return new CreateAccount();
	
}

	public String loginpagetitle() {
return elementpagetitle();
	}

	public void logout()
	{
	myaccount.click();
	logoutlink.click();
	}
	
		}

