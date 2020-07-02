package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackage.BaseClass;

public class Orderplacement_search extends BaseClass{
	Orderplacement_Menu op;
	
@FindBy(xpath="//input[@name='search']")
public WebElement searchbox;
@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
public WebElement searchbtn;
public Orderplacement_search() {
	op=new Orderplacement_Menu();
PageFactory.initElements(driver, this);}
  public void searchtext(String pname) throws InterruptedException
  {
	  searchbox.sendKeys(pname);
	  searchbtn.click();
	  Thread.sleep(3000);
  }
 
  
public void orderplacement() throws InterruptedException {
op.add2cart.click();
op.cart.click();
//pagescroll("bottom");
op.check1.click();
op.billcontinue.click();
op.delicontinue.click();
op.deliMethod.click();
Thread.sleep(3000);
movetoelement(op.agreeterms);
op.agreeterms.click();

op.paymentMethod.click();
op.confirmOrder.click();
}

}
