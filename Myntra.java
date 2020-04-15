package myntra;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver(options);
		
		//1) Open https://www.myntra.com/		
		driver.get("https://www.myntra.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//2) Mouse over on WOMEN (Actions -> moveToElement
		Actions action = new Actions(driver);
		//WebElement women = driver.findElementByLinkText("Women");
		action.moveToElement(driver.findElementByXPath("(//a[text()='Women'])[1]")).perform();
		Thread.sleep(3000);
		
		//3) Click Jackets & Coats
		driver.findElementByXPath("//a[text()='Jackets & Coats'][1]").click();
		
		//4) Find the total count of item (top) -> getText -> String
		String count = driver.findElementByClassName("title-count").getText();
		String count1 = count.replaceAll("\\D", "");
		int totalcount=Integer.parseInt(count1);
		System.out.println(count1);
		String jackets = driver.findElementByClassName("categories-num").getText();
		System.out.println(jackets);
		String jackcount = jackets.replaceAll("\\D", "");
		int jacketcount=Integer.parseInt(jackcount);
		System.out.println(jacketcount);
		Thread.sleep(3000);
		String coats = driver.findElementByXPath("//span[text()='645']").getText();
		String coatcount = coats.replaceAll("\\D", "");
		int coatscount=Integer.parseInt(coatcount);
		
		//5) Validate the sum of categories count matches
		int categorycount=jacketcount+coatscount;
		if(totalcount==categorycount) {
		System.out.println("Count is matching");
		
		}
		else {
			System.out.println("Count is not matching");
		}
		
		//6) Check Coats		
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		
		//7) Click + More option under BRAND			
		driver.findElementByClassName("brand-more").click();
		
		//8) Type MANGO and click checkbox	
		Thread.sleep(3000);
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div[1]").click();
		
		//9) Close the pop-up x
		driver.findElementByXPath("//span[@class=\"myntraweb-sprite FilterDirectory-close sprites-remove\"]").click();
		
		//10) Confirm all the Coats are of brand MANGO		
		List<WebElement> listofproducts = driver.findElementsByXPath("//h3[text()='MANGO']");
		int brandCount=0;
		for (WebElement eachproduct : listofproducts) {
			if(eachproduct.getText().equals("MANGO"))
			{
				brandCount=brandCount+1;
			}}
		
		if(brandCount==listofproducts.size())
		{
		System.out.println("All products are Mango brands");
		}
		
		//11) Sort by Better Discount
		action.moveToElement(driver.findElementByClassName("sort-sortBy")).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		
		//12) Find the price of first displayed item		 
		List<WebElement> price = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		System.out.println("Price is : " + price.get(0).getText());
	
//		WebElement ele= driver.findElementByXPath("(//h4[@class='product-sizes'])[1]");
//		action.moveToElement(ele).perform();
//		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		
		//13) Mouse over on size of the first item
		action.moveToElement(driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]")).perform();
		
		//14) Click on WishList Now
		driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']").click();
		
		//15) Close Browser
		driver.close();
		
	}

}
