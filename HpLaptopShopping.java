package practicecases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HpLaptopShopping {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String url ="https://store.hp.com/in-en/";
		
		//1) Go to https://store.hp.com/in-en/
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//2) Mouse over on Laptops menu and click on Pavilion
		wait.until(ExpectedConditions.visibilityOf
				(driver.findElementByXPath("//button[@class=\"optanon-allow-all accept-cookies-button\"]")));
		driver.findElementByXPath("//button[@class=\"optanon-allow-all accept-cookies-button\"]").click();
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElementByXPath("//span[text()='Laptops'][1]")).click().perform();
		driver.findElementByXPath("(//span[text()='Pavilion'])[1]").click();	
		
		//3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
//		WebElement element=driver.findElementByXPath("//div[@class=\"inside_closeButton fonticon icon-hclose\"]");
//		wait.until(ExpectedConditions.visibilityOf(element));
//		element.click();
//		Thread.sleep(5000);
//		String mainWinHandle = driver.getWindowHandle(); // Get your main window
//		String subWinHandle = null;
//
//		Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
//		Iterator<String> iterator = allHandle.iterator();
//		while (iterator.hasNext()){
//			subWinHandle = iterator.next();
//		}
//		driver.switchTo().window(subWinHandle); // switch to popup 
//
//		//Write code to close Ad or skip                                            
//
//		driver.switchTo().window(mainWinHandle);
//		Thread.sleep(3000);
//		//driver.findElementByXPath("//span[text()='Processor'][2]").click();
//		driver.findElementByXPath("(//dt[@role='tab']//span)[5]").click();
//		//driver.findElementByXPath("//input[@class=\"product-filter-checkbox\"][2]").click();
//		driver.findElementByXPath("//span[text()='Intel Core i7']").click();
		
		//4) Hard Drive Capacity -->More than 1TB
//		Thread.sleep(3000);
//		driver.findElementByXPath("//span[text()='More than 1 TB']").click();		
		
		//5) Select Sort By: Price: Low to High
		WebElement sort=driver.findElementByXPath("(//select[@id='sorter'])[1]");
		Select SORT =new Select(sort);
		SORT.selectByValue("price_asc");
		Thread.sleep(3000);
		driver.findElementByXPath("(//dt[@role='tab']//span)[5]").click();
		driver.findElementByXPath("//span[text()='Intel Core i7']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='More than 1 TB']").click();

	}

}
