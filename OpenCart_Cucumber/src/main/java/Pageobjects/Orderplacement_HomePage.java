package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orderplacement_HomePage {


	@FindBy(xpath="//img[@alt='MacBookAir']")
	public WebElement macBooklink;
	@FindBy(xpath="//button[@id='button-cart']")
	public WebElement addtocart_1;

}
