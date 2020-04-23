package practicecases;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HondaAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
		driver.get("https://www.honda2wheelersindia.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByClassName("close").click();
		
		//2) Click on scooters and click dio
		Thread.sleep(3000);
		driver.findElementById("link_Scooter").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//img[@src='/assets/images/thumb/dioBS6-icon.png']").click();
		
		//3) Click on Specifications and mouseover on ENGINE
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='Specifications']").click();
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Engine = driver.findElementByXPath("//a[text()='ENGINE']");
		Thread.sleep(5000);
		action.moveToElement(Engine).build().perform();
		
		//4) Get Displacement value
		String dioDisplacement = driver.findElementByXPath("(//ul[@class='tab_content']/li/span)[22]").getText();
		System.out.println("Displacement value of Dio : "+(dioDisplacement));
		float Displacement1 = Float.parseFloat(dioDisplacement.replaceAll("c", ""));
		System.out.println(Displacement1);
		
		//5) Go to Scooters and click Activa 125
		driver.findElementById("link_Scooter").click();
		driver.findElementByXPath("//img[@src='/assets/images/thumb/activa-125new-icon.png']").click();
		
		//6) Click on Specifications and mouseover on ENGINE
//		Thread.sleep(3000);
//		driver.findElementByXPath("//a[text()='Specifications']").click();
//		WebElement activaEngine = driver.findElementByXPath("//a[text()='ENGINE']");
//		action.moveToElement(activaEngine).build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='Specifications']")));
		
		action.moveToElement(driver.findElementByXPath("//a[text()='Specifications']")).click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='ENGINE']")));
		
		//action = new Actions(driver);
		
		action.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).build().perform();
		
		//7) Get Displacement value
		String activaDisplacement = driver.findElementByXPath("//span[text()='124 cc']").getText();
		System.out.println("Diplacement value of Activa is : " + activaDisplacement);
		float actdis1 = Float.parseFloat(activaDisplacement.replaceAll("c",""));
		System.out.println(actdis1);
		
		//8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
		if(Displacement1>actdis1) {
			System.out.println("Dio has better diplacement");
		}
			else
			{
				System.out.println("Activa has better displacement");
			}
		//9) Click FAQ from Menu 
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='FAQ']").click();;
		
		//10) Click Activa 125 BS-VI under Browse By Product
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollToElemnt()");
//        js.executeScript("javascript:window.scrollBy(250,350)");
		driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
		
		//11) Click  Vehicle Price 
		Thread.sleep(3000);		
		driver.findElementByXPath("//a[@href='#6a']").click();
		
		//12) Make sure Activa 125 BS-VI selected and click submit
		//String model = driver.findElementByXPath("//select[@id='ModelID6']").getText();
		WebElement ele = driver.findElementByXPath("//select[@id='ModelID6']");
		Select bikemodel = new Select(ele);
		bikemodel.selectByVisibleText("Activa 125 BS-VI");
		//System.out.println(ele);
		driver.findElementByXPath("//button[@id='submit6']").click();
		
		//13) click the price link
		driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
		
		
		//14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winLis = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winLis.get(1));
		
		Thread.sleep(5000);
		WebElement statepage = driver.findElementById("StateID");
		Select state = new Select(statepage);
		state.selectByVisibleText("Tamil Nadu");
		
		WebElement city = driver.findElementById("CityID");
		Select cityarea = new Select(city);
		cityarea.selectByVisibleText("Chennai");
		
		//15) Click Search
		driver.findElementByXPath("//button[text()='Search']").click();
		
		
		//16) Print all the 3 models and their prices
		
		List<WebElement> list = driver.findElementsByXPath("//table[@id='gvshow']/tbody/tr");
		int size = list.size();
		List<WebElement> model = driver.findElementsByXPath("//table[@id='gvshow']//tbody//tr//td[contains(text(),'ACTIVA')]");
		List<WebElement> price = driver.findElementsByXPath("//table[@id='gvshow']//tbody//tr//td[contains(text(),'Rs')]");
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i < size; i++) {
			String nameOfModel = model.get(i).getText();
			String priceOfModel = price.get(i).getText();
			map.put(nameOfModel , priceOfModel);
		}
		System.out.println("all the 3 models and their respective prices");
		for (Entry<String, String> eachEntry : map.entrySet() ) {
			System.out.println(eachEntry.getKey()+"-->"+eachEntry.getValue());
		}
		
//		WebElement table = driver.findElement(By.id("gvshow"));
//		List<WebElement> models = table.findElements(By.tagName("td"));
//		for (WebElement model : models) {
//			System.out.println(model.getText());
//		}

		//17) Close the Browser
		driver.quit();
		

		
		


	}
}

