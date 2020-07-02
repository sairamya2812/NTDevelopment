package Pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackage.BaseClass;

public class Orderplacement_Menu extends BaseClass {

	@FindBy(linkText="Components")
	public WebElement component;
	@FindBy(partialLinkText="Monitors")
	public WebElement monitor;
	@FindBy(xpath="(//a[contains(text(),'Apple Cinema')])")
	public WebElement selectedMonitor;
	@FindBy(xpath="(//div[@class='radio']//following::input[@type='radio'])[1]")
	public WebElement size;
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	public WebElement quantity;
	@FindBy(xpath="//select[@id='input-option217']")
	public WebElement colour;
	@FindBy(xpath="//textarea[@id='input-option209']")
	public WebElement textarea;
	@FindBy(xpath="//input[@id='input-option222']")
	public WebElement upfile;
	@FindBy(id="button-upload222")
public WebElement uploadfile;
	@FindBy(xpath="//input[@id='input-option219']")
	public WebElement date;
	@FindBy(xpath="//input[@id='input-option221']")
	public WebElement time;
	@FindBy(xpath="//input[@id='input-quantity']")
	public WebElement quantit;
	@FindBy(id="button-cart")
	public WebElement add2cart;
	@FindBy(xpath="//a[text()='shopping cart']")
	public WebElement cart;
	@FindBy(xpath="//a[text()='Checkout']")
	public WebElement check1;
	@FindBy(id="button-payment-address")
	public WebElement billcontinue;
	@FindBy(id="button-shipping-address")
	public WebElement delicontinue;
	@FindBy(id="button-shipping-method")
	public WebElement deliMethod;
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	public WebElement agreeterms;
	@FindBy(id="button-payment-method")
	public WebElement paymentMethod;
	@FindBy(id="button-confirm")
	public WebElement confirmOrder;
	
	public Orderplacement_Menu() {
PageFactory.initElements(driver, this);}
	
public void addtocart() throws InterruptedException {
Actions ac=new Actions(driver);
ac.moveToElement(component).build().perform();
ac.moveToElement(monitor).build().perform();
ac.click(monitor).build().perform();
selectedMonitor.click();
size.click();
quantity.click();
elementdropdown("index", colour, "1");
textarea.sendKeys("SampleText");
JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value', 'C:\\Users\\admin\\Downloads\\HotelAppTestCases\\Sample-TestCases_HotelApplication.pdf')", upfile);

add2cart.click();
	Thread.sleep(6000);
	
	}
	
public void checkout() throws InterruptedException {
cart.click();
pagescroll("bottom");
check1.click();
billcontinue.click();
delicontinue.click();
deliMethod.click();
Thread.sleep(3000);
movetoelement(agreeterms);
agreeterms.click();

paymentMethod.click();
confirmOrder.click();
	}

public String orderconfirmtitle() {
return elementpagetitle();
}
}
