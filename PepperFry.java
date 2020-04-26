package practicecases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PepperFry {
	
	public ChromeDriver driver;

@Test
public void loadurl() throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
	options.merge(cap);
	ChromeDriver driver = new ChromeDriver();
	driver = new ChromeDriver(options);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions action = new Actions(driver);
	
	//1) Go to https://www.honda2wheelersindia.com/
			driver.get("https://www.pepperfry.com/");		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByClassName("close").click();

	//2) Mouseover on Furniture and click Office Chairs under Chairs
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//a[text()='Furniture']")));
			WebElement url = driver.findElementByXPath("//a[text()='Furniture']");
			action.moveToElement(url).build().perform();
			Thread.sleep(3000);
			driver.findElementByXPath("//a[text()='Office Chairs']").click();
			
	//3) click Executive Chairs
			Thread.sleep(8000);
			
			try {
				driver.findElementByXPath("//div[@id='regPopUp']//a[@class='popup-close']").click(); 
				System.out.println("Login popup closed.");
			} catch (Exception e) {
				System.out.println("Login popup not found.");
				e.printStackTrace();
				
			}
			//Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='container']//img[@alt='Executive Chairs']")));
			WebElement chair = driver.findElementByXPath("//div[@class='container']//img[@alt='Executive Chairs']");
			action.moveToElement(chair).click().build().perform();
			System.out.println("Executive chair clicked");
			
	//4) Change the minimum Height as 50 in under Dimensions
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']")));
			driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']").clear();
			//Thread.sleep(2000);
			driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']").sendKeys("50",Keys.ENTER);
			
	//5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
			Thread.sleep(3000);
			driver.findElementByXPath("(//a[@id='clip_wishlist_'])[2]").click();
			
	//6) Mouseover on Homeware and Click Pressure Cookers under Cookware
			//wait.until(ExpectedConditions.elementToBeSelected(driver.findElementByTagName("//div[@id='menu_wrapper']//a[text()='Homeware']")));
			WebElement Homeware = driver.findElementByLinkText("Homeware");
			action.moveToElement(Homeware).build().perform();
			driver.findElementByXPath("//a[text()='Pressure Cookers']").click();
			
	//7) Select Prestige as Brand			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//label[text()='Prestige']")));
			driver.findElementByXPath("//label[text()='Prestige']").click();
			
	//8) Select Capacity as 1-3 Ltr
			Thread.sleep(3000);
			driver.findElementByXPath("//label[text()='1 Ltr - 3 Ltr']").click();
			
	//9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.elementToBeSelected(driver.findElementByXPath("(//a[contains(@class,'clip-heart-icn pf-right')])[5]")));
			WebElement cooker = driver.findElementByXPath("(//a[contains(@class,'clip-heart-icn pf-right')])[5]");
			action.moveToElement(cooker).click().build().perform();
			
	//10) Verify the number of items in Wishlist
			String wishlistcount = driver.findElementByXPath("//span[text()='2']").getText();
			System.out.println("Total items added to wishlist is :" + wishlistcount);
			
	//11) Navigate to Wishlist
			Thread.sleep(500);
			driver.findElementByXPath("//a[contains(@class,'pf-icon pf-icon-heart')]").click();
			
	//12) Move Pressure Cooker only to Cart from Wishlist
			Thread.sleep(2000);			
			//wait.until(ExpectedConditions.elementToBeSelected(driver.findElementByXPath("(//a[@class='addtocart_icon'])[2]")));
			//driver.findElementByXPath("(//a[@class='addtocart_icon'])[2]").click();
			WebElement addtocart = driver.findElementByXPath("(//a[@class='addtocart_icon'])[2]");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", addtocart);
			
	//13) Check for the availability for Pincode 600128
			Thread.sleep(2000);
			driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600069");
			driver.findElementByXPath("//a[@class='check_available']").click();
			System.out.println("Delivery verified");
			
	//14) Click Proceed to Pay Securely		
			Thread.sleep(2000);
			driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
			
	//15 Click Proceed to Pay
			Thread.sleep(3000);
			driver.findElementByXPath("//a[text()='PLACE ORDER']").click();
			
	//16) Capture the screenshot of the item under Order Item
			driver.findElementByXPath("//span[text()='ORDER SUMMARY']").click();
			WebElement image = driver.findElementByXPath("//li[@role='option']//img[1]");
			File src = image.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/img.png");
			FileUtils.copyFile(src,dest);
			System.out.println("Cart screenshot has been captured and save in screenshot folder");
			
	//17) Close the browser			
			driver.close();
			
}
}
