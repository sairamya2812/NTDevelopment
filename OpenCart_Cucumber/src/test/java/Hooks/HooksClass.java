package Hooks;

import BaseClassPackage.BaseClass;
import Pageobjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass {
HomePage hp;

public HooksClass() {
super();
hp=new HomePage();
}
	@Before
	public void Login() throws InterruptedException {
browserlaunch();
	}
	
@After
public void teardown() {
driver.quit();
}
}
