package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClassPackage.BaseClass;

public class CreateAccount extends BaseClass   {
@FindBy(id="input-firstname")
public static WebElement fname;
@FindBy(id="input-lastname")
public static WebElement lname;
@FindBy(id="input-email")
public static WebElement email;
@FindBy(id="input-telephone")
public static WebElement phone;
@FindBy(id="input-address-1")
public static WebElement add1;
@FindBy(id="input-address-2")
public static WebElement add2;
@FindBy(id="input-city")
public static WebElement city;
@FindBy(id="input-postcode")
public static WebElement postcode;
@FindBy(id="input-country")
public static WebElement country;
@FindBy(id="input-zone")
public static WebElement state;
@FindBy(id="input-password")
public static WebElement pwd;
@FindBy(id="input-confirm")
public static WebElement confirmpwd;
@FindBy(xpath="//input[@name='agree']")
public static WebElement agreeterms;
@FindBy(xpath="//input[@value='Continue']")
public static WebElement continuebtn;
@FindBy(xpath="//div[@class='alert alert-danger']")
public static WebElement warnmess;

public CreateAccount()
{	
	PageFactory.initElements(driver, this);
}

public String createAccpageTitle()
{
	return elementpagetitle();
}

public static String createnewAcc(String fiName,String ltName,String email_id,
		String phone_No, String address_1, String address_2, 
		String cityvalue, String pin_code,String s_value,
		String s_text,String pass_d, String repass_d,String s_option)
{
	
	fname.sendKeys(fiName);
	lname.sendKeys(ltName);
	email.sendKeys(email_id);
	phone.sendKeys(phone_No);
	add1.sendKeys(address_1);
	add2.sendKeys(address_2);
	city.sendKeys(cityvalue);
	postcode.sendKeys(pin_code);
	Select s=new Select(country);
	s.selectByValue(s_value);
	Select sh=new Select(state);
	sh.selectByVisibleText(s_text);
	pwd.sendKeys(pass_d);
	confirmpwd.sendKeys(repass_d);
	while(s_option.equalsIgnoreCase("yes"))
	{agreeterms.click();
	continuebtn.click();
	return elementpagetitle();
	}
	
	continuebtn.click();
return elementgetText(warnmess);

}
}

