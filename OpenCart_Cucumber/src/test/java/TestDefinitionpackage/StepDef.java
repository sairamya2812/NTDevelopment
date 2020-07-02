package TestDefinitionpackage;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClassPackage.BaseClass;
import Pageobjects.HomePage;
import Pageobjects.Orderplacement_Menu;
import Pageobjects.Orderplacement_search;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends BaseClass{
	HomePage hp;
	Orderplacement_search ops;
	Orderplacement_Menu opm;
	
	public StepDef() {
	super();
	hp=new HomePage();
	ops=new Orderplacement_search();
	opm=new Orderplacement_Menu();
	}
@Given("^User on the Home Page$")
public void user_on_the_Home_Page() throws Throwable {
	String title = hp.validateHomepageTitle();
	
	Assert.assertEquals(title, "Your Store");
}

@When("^User enters valid login id and password and clicks login button$")
public void user_enters_valid_login_id_and_password_and_clicks_login_button() throws Throwable {
	hp=hp.login(prop.getProperty("username"), prop.getProperty("password"));
	
}


@Then("^User must be on page with title$")
public void user_must_be_on_page_with_title() throws Throwable {
	String name = new Object(){}.getClass().getEnclosingMethod().getName();
	String title=hp.loginpagetitle();
	Assert.assertEquals(title, "My Account");
	getScreenshotrobot(name);
	}

@Given("^User has logged in the app$")
public void user_has_logged_in_the_app() throws Throwable {
	hp=hp.login(prop.getProperty("username"), prop.getProperty("password"));
}

@When("^User enters a \"([^\"]*)\" name in search box$")
public void user_enters_a_name_in_search_box(String product) throws Throwable {
    ops.searchtext(product);
WebElement productlink = driver.findElement(By.partialLinkText("iPod"));
productlink.click();
}

@When("^User adds the product to Cart and checkout$")
public void user_adds_the_product_to_Cart() throws Throwable {
    ops.orderplacement();
    
    }

@Then("^User should be able to confirm the order placement$")
public void user_should_be_able_to_confirm_the_order_placement() throws Throwable {
	
	WebDriverWait wb=new WebDriverWait(driver, 10);
	wb.until(ExpectedConditions.titleContains("Your order has been placed"));
	String title=opm.orderconfirmtitle();
	Assert.assertTrue(title.contains("Your order has been placed"));
	String name=new Object() {}.getClass().getEnclosingMethod().getName();
	try {
		getScreenshot(name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@When("^User clicks logout button$")
public void user_clicks_logout_button() throws Throwable {
   hp.logout();
}

@Then("^User should be logged out$")
public void user_should_be_logged_out() throws Throwable {
 String title = driver.getTitle();
 Assert.assertTrue(title.contains("Account Logout"));
}


}
	