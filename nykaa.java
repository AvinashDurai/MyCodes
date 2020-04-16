package practicecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver(options);
		
		//1) Open https:https://www.nykaa.com/		
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//2) Mouseover on Brands and Mouseover on Popular
		Actions action = new Actions(driver);
		//WebElement women = driver.findElementByLinkText("Women");
		action.moveToElement(driver.findElementByXPath("(//a[@href='#'])[2]")).perform();
		Thread.sleep(3000);
		
		//3) Click L'Oreal Paris
		action.moveToElement(driver.findElementByXPath("//a[text()='Popular']")).perform();
		driver.findElementByXPath("(//li[@class='brand-logo menu-links']//img)[5]").click();
		
		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> winSet = driver.getWindowHandles();
		List<String> winLis = new ArrayList<String>(winSet);
		driver.switchTo().window(winLis.get(1));
		String title = driver.getTitle();
		
		String title1="Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
		
		if(title1.equals(title)) {
		System.out.println("Title is matching"+ title);
		}
		else {
			System.out.println("Title not matched");
		}
		
		//5) Click sort By and select customer top rated
		driver.findElementByXPath("//div[@class='sort-btn clearfix']").click();
		driver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
		
		//6) Click Category and click Shampoo
		driver.findElementByXPath("//div[@class=\"filter-sidebar__filter-title pull-left\"][1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined']//div)[1]").click();
		
		//7) check whether the Filter is applied with Shampoo
		String text = driver.findElementByXPath("//li[text()='Shampoo']").getText();
		if(text.contains("Shampoo")) {
			System.out.println("Filtered product is Shampoo");
		}
		else {
			System.out.println("Filtered product is not Shampoo");
		}
		
		//8) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("(//div[@class='card-img']//img)[4]").click();
		
		//9) GO to the new window and select size as 175ml
		Set<String> winSet1 = driver.getWindowHandles();
		List<String> winLis1 = new ArrayList<String>(winSet1);
		driver.switchTo().window(winLis1.get(2));
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		Thread.sleep(3000);		
		driver.findElementByXPath("//span[text()='175ml']").click();
		
		//10) Print the MRP of the product
		String productMRP = driver.findElementByXPath("//span[@class=\"mrp-tag\"]").getText();
		System.out.println(productMRP + "is 150");
		
		//11) Click on ADD to BAG
		driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();
		
		//12) Go to Shopping Bag
		driver.findElementByClassName("AddBagIcon").click();
		
		
		//13) Print the Grand Total amount
		String Grandtotal = driver.findElementByXPath("//div[text()='249'][1]").getText();
		System.out.println("GrandTotal is" + Grandtotal);
		
		//14) Click Proceed
		driver.findElementByXPath("//span[text()='Proceed']").click();
		
		//15) Click on Continue as Guest
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
		
		//16) Print the warning message (delay in shipment)
		String message = driver.findElementByXPath("//div[@class=\"message\"]").getText();
		System.out.println(message);
		
		//17) Close all windows
		driver.quit();

		
//			1) Go to https://www.nykaa.com/
//
//			2) Mouseover on Brands and Mouseover on Popular
//
//			3) Click L'Oreal Paris
//
//			4) Go to the newly opened window and check the title contains L'Oreal Paris
//
//			5) Click sort By and select customer top rated
//
//			6) Click Category and click Shampoo
//
//			7) check whether the Filter is applied with Shampoo
//
//			8) Click on L'Oreal Paris Colour Protect Shampoo
//
//			9) GO to the new window and select size as 175ml
//
//			10) Print the MRP of the product
//
//			11) Click on ADD to BAG
//			12) Go to Shopping Bag 
//
//			13) Print the Grand Total amount
//
//			14) Click Proceed
//
//			15) Click on Continue as Guest
//
//			16) Print the warning message (delay in shipment)
//
//			17) Close all windows


			


		

	}

}
