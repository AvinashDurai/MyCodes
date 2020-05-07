package practicecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjioCase {

	public static void main(String[] args) throws InterruptedException {
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
		
		//1) Go to https:https://www.ajio.com/shop/sale
				driver.get("https://www.ajio.com/shop/sale");		
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				

		//2) Enter Bags in the Search field and Select Bags in Women Handbags
				driver.findElementByName("searchVal").sendKeys("Bags");
				driver.findElementByXPath("//span[text()='Women Handbags']").click();				

		//3) Click on five grid and Select SORT BY as "What's New"
				Thread.sleep(3000);
				driver.findElementByXPath("//div[@class='five-grid']").click();				
				WebElement dropdown = driver.findElementByTagName("select");
				Select select = new Select(dropdown);
				select.selectByVisibleText("What's New");
				
		//4) Enter Price Range Min as 2000 and Max as 5000
				driver.findElementByXPath("//span[text()='price']").click();
				driver.findElementById("minPrice").sendKeys("2000",Keys.TAB);
				driver.findElementById("maxPrice").sendKeys("5000",Keys.TAB);				
				driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
				
		//5) Click on the product "Puma Ferrari LS Shoulder Bag"
				Thread.sleep(2000);
				driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']").click();
				
		//6) Verify the Coupon code for the price above 2690 is applicable for your product, if applicable the get the Coupon Code and Calculate the discount price for the coupon
				Set<String> winSet = driver.getWindowHandles();
				List<String> winLis = new ArrayList<String>(winSet);
				driver.switchTo().window(winLis.get(1));
				String title = driver.getTitle();
				System.out.println(title);
				
				String price = driver.findElementByXPath("//div[text()='Rs. 2,974']").getText().replaceAll("\\D", "");
				int price1 = Integer.parseInt(price);
				System.out.println("The actual price of bag is : " + price1);
				
				String couponcode ="";
				if(price1>2690) {
//					String promocode = driver.findElementByXPath("//div[@class='promo-title']").getText();
//					String discd1 = promocode.replaceAll("Use", "");
//					String discd2 = discd1.replaceAll("Code", "");
//					String discd3 = discd2.replaceAll("\\s", "");
//					System.out.println(discd3);
					couponcode = driver.findElementByXPath("//div[@class=\"promo-title\"]").getText().substring(9);
					System.out.println(couponcode);
					
					String text = driver.findElementByXPath("//div[@class=\"promo-desc\"]").getText();
					String[] split = text.split(" ");
					String per = "";
					for (int i = 0; i <split.length; i++) {
						String s = split[i];
						if (s.endsWith("%")) {
							 per = split[i];
						}
					}
					int actualpercentage = Integer.parseInt(per.replaceAll("\\D", ""));
					float discount = price1*actualpercentage/100.0f;
					
					System.out.println("Discount is : " + discount);
//					String discout = driver.findElementByXPath("//div[@class='promo-desc']").getText();
//					System.out.println(discout);
//					
//					String discountedprice = driver.findElementByXPath("//span[text()='2141']").getText().replaceAll("\\D", "");
//					int price2 = Integer.parseInt(discountedprice);
//					int offer= price1-price2;
//					System.out.println("The amount saved is :" + offer);
				
	
				//7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
				driver.findElementByXPath("//span[contains(@class,'edd-pincode-msg')][2]").click();
				Thread.sleep(2000);
				driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("682001");
				driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
				System.out.println("Delivery Available at 682001");				
				String date = driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']").getText();
				System.out.println("The Expected Delivery is : " + date);
				

				//8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email
				WebElement info = driver.findElementByXPath("//div[text()='Other information']");
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();", info);
				Thread.sleep(3000);
				String carecustomer = driver.findElementByXPath("//span[text()='Customer Care Address']").getText();
				String otherinfo = driver.findElementByXPath("//span[text()='AJIO, c/o Reliance Retail Limited, SS Plaza, 74/2 Outer Ring Road, 29th Main Road, BTM 1st Stage, BTM Layout, Bangalore 560068, Karnataka, INDIA. Ph. 1800-889-9991, 1800-419-8998. E-mail - customercare@ajio.com']").getText();
				System.out.println(carecustomer  + otherinfo );
				
				//9) Click on ADD TO BAG and then GO TO BAG
				driver.findElementByXPath("//span[@class='ic-pdp-add-cart']").click();
				Thread.sleep(2000);
				driver.findElementByXPath("//span[text()='GO TO BAG']").click();
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='ic-cart ']")));
//				action.moveToElement(driver.findElementByXPath("//div[@class='ic-cart ']")).build().perform();	
//				Thread.sleep(3000);

				//10) Check the Order Total before apply coupon
				wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@class=\"price-value bold-font\"]")));
				int before = Integer.parseInt(driver.findElementByXPath("//span[@class=\"price-value bold-font\"]").getText().replaceAll("\\D", "").substring(0,4));
				if (price1 == before) {
					System.out.println("Order Total before apply coupon are equal");
				}else {
					System.out.println("Order Total before apply coupon are not equal");
				}
					//11) Enter Coupon Code and Click Apply
				driver.findElementById("couponCodeInput").sendKeys(couponcode);
				driver.findElementByXPath("//button[text()='Apply']").click();
				//Thread.sleep(2000);
				System.out.println("Coupon Code Applied");
				
				//12) Verify the Coupon Savings amount(round off if it in decimal) under
				//Order Summary and the matches the amount calculated in Product details
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Rs. 832.72']")));
				String coupondiscount = driver.findElementByXPath("//span[text()='Rs. 832.72']").getText().replaceAll("Rs.", "");
				float couponsavings = Float.parseFloat(coupondiscount);
				System.out.println("Coupon savings is :" + couponsavings);
				if(couponsavings == discount ) {
					System.out.println("Discount price matches");
				}
					else {
						System.out.println("Discount price does not match");
					}
					
				//3) Click on Delete and Delete the item from Bag
				driver.findElementByXPath("//div[@class=\"delete-btn\"]").click();
				driver.findElementByXPath("(//div[@class=\"delete-btn\"])[2]").click();
				
				//14) Close all the browsers
				driver.quit();
	}
	
		
	
}
	}

				



				
				



