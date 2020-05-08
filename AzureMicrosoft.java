package practicecases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class AzureMicrosoft {

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
		
		
		//1) Go to https://azure.microsoft.com/en-in/		
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		

		//2) Click on Pricing		
		driver.findElementById("navigation-pricing").click();
		System.out.println("Clicked on Pricing");
		
		//3) Click on Pricing Calculator
		driver.findElementByXPath("(//a[@data-bi-id='global-navigation-secondarynav-clicked-topmenu'])[2]").click();
		System.out.println("Clicked on Pricing Calculator");
		
		//4) Click on Containers
		driver.findElementByXPath("//button[text()='Containers']").click();
		System.out.println("Clicked on Containers");
		
		//5) Select Container Instances
		driver.findElementByXPath("(//span[text()='Easily run containers on Azure without managing servers'])[3]").click();
		System.out.println("Clicked on Container Instances");
		
		//6) Click on Container Instance Added View
		driver.findElementByLinkText("View").click();
		System.out.println("Clicked on view");
		
		//7) Select Region as "South India"
		WebElement region = driver.findElementByXPath("//select[@class='select'][1]");
		Select Region = new Select(region);
		Region.selectByVisibleText("South India");
		
		
		//8) Set the Duration as 180000 seconds
		driver.findElementByXPath("(//div[@class='wa-textNumber']//input[@name='seconds'])[1]").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("(//div[@class='wa-textNumber']//input[@name='seconds'])[1]").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("(//div[@class='wa-textNumber']//input[@name='seconds'])[1]").sendKeys("180000");
		System.out.println("Duration 180000 entered");
		
		
		//9) Select the Memory as 4GB
		WebElement memory = driver.findElementByXPath("(//select[@name='memory'])[1]");
		Select size = new Select(memory);
		size.selectByValue("4");		
		
		//10) Enable SHOW DEV/TEST PRICING
		Thread.sleep(3000);
		WebElement toggle = driver.findElementByXPath("(//label[@for='devtest-toggler']//div)[1]");
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", toggle);
		
		//11) Select Indian Rupee  as currency
		WebElement currency = driver.findElementByXPath("//select[@aria-label='Currency']");
		Select inr = new Select(currency);
		inr.selectByVisibleText("Indian Rupee (₹)");
		System.out.println("Indian Currency Selected");
		
		//12) Print the Estimated monthly price
		String text = driver.findElementByXPath("//span[text()='₹288.77']").getText();
		System.out.println("Estimated Monthly Cost is : " + text);
		
		//13) Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[text()='Export']").click();
		Thread.sleep(5000);
		
		//14) Verify the downloded file in the local folder
		File file = new File("C:\\Users\\Avinash\\Downloads\\ExportedEstimate.xlsx");
		if(file.exists())
		{
			System.out.println("Estimate file Downloaded successfully");
		}
		else
		{
			System.out.println("Estimate file does not exists in the folder");
		}
	
		//15) Navigate to Example Scenarios and Select CI/CD for Containers
		action.moveToElement(driver.findElementByXPath("//a[text()='Example Scenarios']")).click().build().perform();
		System.out.println("Example Scenarios Clicked");
		driver.findElementByXPath("//span[text()='CI/CD for Containers']").click();
		System.out.println("CI/CD for containers clicked");
		
		
		//driver.findElementByXPath("//img[@alt='End conversation']").click();

		//16) Click Add to Estimate
		Thread.sleep(3000);
		WebElement scroll = driver.findElementByXPath("//button[text()='Add to estimate']");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", scroll);
		
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to estimate']")));
//		action.moveToElement(driver.findElementByXPath("//button[text()='Add to estimate']")).click().build().perform();;
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Estimate added!']")));
//		System.out.println("Estimate Added");
//		Thread.sleep(2000);
//		driver.findElementByXPath("//button[text()='Add to estimate']").click();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='CI/CD for containers']")));
//		if(driver.findElementByXPath("//a[text()='CI/CD for containers']").isDisplayed())
//		{
//			System.out.println("CI/CD for Containers added to estimates");
//			System.out.println("CI/CD estimation process initiated");
//		}
		
		//17) Change the Currency as Indian Rupee
		WebElement currency1 = driver.findElementByXPath("//select[@aria-label='Currency']");
		Select inr1 = new Select(currency1);
		inr.selectByVisibleText("Indian Rupee (₹)");
		System.out.println("Indian Currency Selected");		
		
		//18) Enable SHOW DEV/TEST PRICING
		Thread.sleep(3000);
		WebElement toggle1 = driver.findElementByXPath("(//label[@for='devtest-toggler']//div)[1]");
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", toggle1);
		
		//19) Export the Estimate
		driver.findElementByXPath("//button[text()='Export']").click();
		Thread.sleep(5000);
		System.out.println("Estimation file has been downloaded");
		
		File file1 = new File("C:\\Users\\Avinash\\Downloads\\ExportedEstimate (1).xlsx");
		if(file1.exists())
		{
			System.out.println("Estimate export successful");
		}
		else
		{
			System.out.println("Estimate download is not successful");
		}

		driver.quit();
	}

}
