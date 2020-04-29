package practicecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("Webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		System.setProperty("Webdriver.chrome.silentOutput", "true");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		ChromeDriver driver = new ChromeDriver();
//		driver = new ChromeDriver(options);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		Actions action = new Actions(driver);	
		
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
		
		//1) Go to https://www.snapdeal.com/
		String url="https://www.snapdeal.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("URL loaded");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[contains(text(),'Toys, Kids')]")));
		WebElement Toys = driver.findElementByXPath("//span[contains(text(),'Toys, Kids')]");
		action.moveToElement(Toys).build().perform();
		
		driver.findElementByXPath("//span[text()='Toys']").click();
		System.out.println("Toys clicked");
		
		//3) Click Educational Toys in Toys & Games		
		driver.findElementByXPath("//div[text()='Educational Toys']").click();
		System.out.println("Clicked on Educational Toys");
		
		driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
		System.out.println("Clicked on ratings 4 and above");
		
		Thread.sleep(2000);
		//driver.findElementByXPath("//input[@value='40%20-%2050']/following-sibling::label[1]").click();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//label[@for='discount-40%20-%2050']")));
		driver.findElementByXPath("//label[@for='discount-40%20-%2050']").click();
		//driver.findElementByXPath("//a[text()=' 40 - 50']").click();
		System.out.println("Clicked on discount 40-50%");
		
		driver.findElementByXPath("//input[@placeholder='Enter your pincode']").sendKeys("600069");
		driver.findElementByXPath("//button[text()='Check']").click();
		System.out.println("Pincode verified");
		
		//wait.until(ExpectedConditions.elementToBeSelected(driver.findElementByXPath("//p[@class='product-title']")));
		Thread.sleep(3000);
		action.moveToElement(driver.findElementByXPath("//p[@class='product-title']")).build().perform();
		driver.findElementByXPath("//div[text()[normalize-space()='Quick View']]").click();
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeSelected(driver.findElementByXPath("//a[@href='/product/invento-4pcs-dc-37v-716/664932693810']")));
		driver.findElementByXPath("//a[@href='/product/invento-4pcs-dc-37v-716/664932693810']").click();
		System.out.println("View Details Clicked");
		
		String price1 = driver.findElementByXPath("//span[@class='payBlkBig']").getText().replaceAll("/d", "");
		int product1 = Integer.parseInt(price1);
		System.out.println("The price of Toy is :" + product1);
		
		Thread.sleep(2000);
		WebElement chargedelivery = driver.findElementByXPath("(//span[@class='head']/following-sibling::span)[2]");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", chargedelivery);
		String deliverycharge = chargedelivery.getText().replaceAll("\\D", "");
		
		//String deliverycharge = driver.findElementByXPath("//span[@class='availCharges'][2]").getText().replaceAll("/d", "");
		int Dcharge = Integer.parseInt(deliverycharge);
		System.out.println("Delivery Charge of Toy is :" + Dcharge);
		int Totalofproduct1= product1+Dcharge;
		System.out.println("The total price of the product is :" + Totalofproduct1);
		
		driver.findElementByXPath("//span[text()='add to cart']").click();
		String youpay = driver.findElementByXPath("//span[text()='Rs. 468']").getText().replaceAll("\\D", "");
		int youprice = Integer.parseInt(youpay);
		if(youprice==Totalofproduct1) {
			System.out.println("Price is marching");
					}
		else
		{
			System.out.println("Price Not matching");
		}
		
		driver.findElementById("inputValEnter").sendKeys("Sanitizer");
		driver.findElementByXPath("//span[@class='searchTextSpan']").click();
		System.out.println("Sanitizer searched");
		
		Thread.sleep(1000);
		WebElement sanitizer = driver.findElementByXPath("(//p[@class='product-title'])[1]");
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", sanitizer);
		
		
		//driver.findElementByTagName("//a[contains(@class,'dp-widget-link noUdLine')]//p[1]").click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winLis = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winLis.get(1));
		System.out.println(driver.getTitle());
		
		String price2 = driver.findElementByXPath("//span[text()='247']").getText().replaceAll("\\D", "");
		int product2 = Integer.parseInt(price2);
		System.out.println("The price of Sanitizer is :" + product2);
		
		String Dcharge1 = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText().replaceAll("\\D", "");
		int Dcharge2 = Integer.parseInt(Dcharge1);
		System.out.println("Delivery charge of Sanitizer is :" + Dcharge2);
		
		int TotalAmount=product2+Dcharge2;
		System.out.println("The total amount of Sanitizer is :" + TotalAmount);
		
		int Total = youprice+TotalAmount;
		System.out.println("The Total cart amount is :" + Total);
		
		driver.findElementByXPath("//span[text()='ADD TO CART']").click();
		
		driver.findElementByXPath("//span[text()='Cart']").click();
		
//		String cart = driver.findElementByXPath("//input[@value='PROCEED TO PAY Rs. 744']").getText().trim();
//		cart.replaceAll("/d", "");
		
		String cart = driver.findElementByXPath("//input[@type='button']").getAttribute("value").replaceAll("\\D","");
		int Totalcartamount = Integer.parseInt(cart);
		
		if(Totalcartamount==Total) {
			System.out.println("Total Amount Matched");
			driver.findElementByXPath("//input[@value='PROCEED TO PAY Rs. 744']").click();
		}
		
		driver.quit();
	}

}
