package BaseClassPackage;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtilpackage.TestUtil;



public class BaseClass extends TestUtil
{
public static WebDriver driver;
	
	public static Properties prop;
	public static String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	public BaseClass() 	{
	try {
		prop=new Properties();
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Configprop\\config.properties");
		prop.load(fin);
	}
	catch(FileNotFoundException fe)
	{
	fe.printStackTrace();
	}
	catch(IOException ie) {
		ie.printStackTrace();
	}
			}
	public static void browserlaunch() {

		String browsername = prop.getProperty("browser");
		
		String driverpath=prop.getProperty("driverlocation");
		String url=prop.getProperty("url");
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverpath);
			ChromeOptions options=new ChromeOptions();
			ChromeOptions option = options.addArguments("ignore-certificate-errors");
			driver=new ChromeDriver(option);

		}
		else if(browsername.equalsIgnoreCase("firefox"))
				{	
			System.setProperty("webdriver.gecko.driver", driverpath);
			driver=new FirefoxDriver();}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait_time, TimeUnit.SECONDS);

		driver.get(url);
		
		
	}
	
	public static void elementtextclear(WebElement element) {
		if(!element.getText().isEmpty())
	element.clear();
	}
	public static String elementgettext(WebElement element) 
	{
	String text = element.getText();
	return text;
	}

	public static String elementpagetitle() {
	String title = driver.getTitle();
	return title;
	}
	public static void elementdropdown(String option,WebElement element,String val) 
	{
		Select s=new Select(element);
		
		if(option.equalsIgnoreCase("index"))
	{
			int index=Integer.parseInt(val);
		s.selectByIndex(index);
	}
		else if(option.equalsIgnoreCase("value"))
		{
			s.selectByValue(val);
	}
		else if(option.equalsIgnoreCase("visibletext"))
		{
			s.selectByVisibleText(val);
		}
	}
	public static boolean elementgetdisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static void elementisenabled(WebElement element) {
		elementgetdisplayed(element);
		element.isEnabled();
	}

	public static void elementselected(WebElement element) {
		elementgetdisplayed(element);
		elementisenabled(element);
		element.isSelected();
	}


	public static String pagetitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String elementgetText(WebElement element)
	{
		String text = element.getText();
		return text;
	}
	
	public static void getScreenshot(String ssname) throws IOException  {
		
String screenshotpath = prop.getProperty("Screenshotpath");
TakesScreenshot ss=(TakesScreenshot)driver;
File src=ss.getScreenshotAs(OutputType.FILE);
File dest=new File(screenshotpath+ssname+timestamp+".png");
FileUtils.copyFile(src, dest);
	}

public static void getScreenshothandler(String ssname) {
		String screenshotpath = prop.getProperty("Screenshotpath");
		TakesScreenshot ss=(TakesScreenshot)driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		File dest=new File(screenshotpath+ssname+timestamp+".png");
try {
	FileHandler.copy(src, dest);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}			}
	
	public static void getScreenshotrobot(String ssname) throws IOException, AWTException
	{
		String screenshotpath = prop.getProperty("Screenshotpath");
		Robot r= new Robot();
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec=new Rectangle(d);
		BufferedImage src = r.createScreenCapture(rec);
		File dest=new File(screenshotpath+ssname+timestamp+".png");
		ImageIO.write(src, "png", dest);
		}
	
			
	public static void elementclick(WebElement element, String val) {
Actions ac=new Actions(driver);
ac.click(element).build().perform();
	}

	public static void elementsendkeys(String value,WebElement element)
	{
		if(element.isDisplayed() && element.isEnabled())
		{
			element.sendKeys(value);
		}
	}

	public static void elementsendkeys(WebElement element,String value)
	{
		Actions ac=new Actions(driver);
		ac.sendKeys(element, value);
	}

	public static String elementgetAttribute(WebElement element,String attribute) 
	{
	String value = element.getAttribute(attribute);
	return value;
	}

	public static String elementpageurl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}
	public static String elementselectedValue(WebElement element) {

		Select s=new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
	public static void pagescrollvertical(String scrolltype,int height) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	if(scrolltype.equalsIgnoreCase("down"))
	{
	js.executeScript("window.scrollTo(0,"+height+")");
	}
	if(scrolltype.equalsIgnoreCase("up"))
	{
		
	js.executeScript("window.scrollTo(0,"+(-height)+")");
	}
	}
	public static void pagescroll(String scrolltype) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		if(scrolltype.equals("bottom")) {
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");}
		else if(scrolltype.equals("top")) {
			js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");}
	}

	public static void pagescrollhorizontal(String scrolltype,int height) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		if(scrolltype.equalsIgnoreCase("right"))
		js.executeScript("window.scrollTo("+height+",0)");
		if(scrolltype.equalsIgnoreCase("left"))
			js.executeScript("window.scrollTo("+(-height)+",0)");
	}

	public static void pagescrollbyview(WebElement element1,WebElement element2) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element1);
		js.executeScript("arguments[0].scrollIntoView();", element2);
	}
	public static void movetoelement(WebElement element)
	{
	if(element.isDisplayed()) {
	Actions ac=new Actions(driver);
	ac.moveToElement(element).build().perform();
	}

	}
	public static void elementDoubleClick(WebElement element)
	{
		Actions ac=new Actions(driver);
		WebDriverWait wb=new WebDriverWait(driver, 3000);
		wb.until(ExpectedConditions.elementToBeClickable(element));
		ac.doubleClick(element).build().perform();
	}

	public static void elementRightClick(WebElement element)
	{
		Actions ac=new Actions(driver);
		WebDriverWait wb=new WebDriverWait(driver, 3000);
		wb.until(ExpectedConditions.elementToBeClickable(element));
		ac.contextClick(element).build().perform();
	}
	public static void elementDragandDrop(WebElement element1,WebElement element2)
	{
		Actions ac=new Actions(driver);
		WebDriverWait wb=new WebDriverWait(driver, 3000);
		wb.until(ExpectedConditions.elementToBeClickable(element1));
		wb.until(ExpectedConditions.visibilityOf(element2));
		ac.dragAndDrop(element1, element2);
	}
	public static void alertHandle(String alerttype) {
	Alert alert=driver.switchTo().alert();
	if(alerttype.equalsIgnoreCase("simple"))
	{
		alert.accept();
	}
	else if(alerttype.equalsIgnoreCase("confirmaccept"))
	{
		alert.accept();
	}
	if(alerttype.equalsIgnoreCase("confirmdismiss"))
	{
		alert.dismiss();
	}
	driver.switchTo().defaultContent();
	}
	public static void alertHandle(String alerttype,WebElement element,String text) {
		Alert alert=driver.switchTo().alert();
		if(alerttype.equalsIgnoreCase("prompt"))
		{
			elementsendkeys(text, element);
			alert.accept();
		}
	driver.switchTo().defaultContent();

	}
	public static void navigationHandle(String option)
	{
		if(option.equalsIgnoreCase("back")) {
		driver.navigate().back();}
		else if(option.equalsIgnoreCase("forward")) {
			driver.navigate().forward();}
		else if(option.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();}
		
	}
	public static void navigationHandle(String option,String url)
	{
		if(option.equalsIgnoreCase("url")) {
		driver.navigate().to(url);
		}
			
	}
	public static void pagewindowhandle() {
	String windowHandle = driver.getWindowHandle();
	driver.switchTo().window(windowHandle);
	}




	}
	
	
	
	
	
	
	
