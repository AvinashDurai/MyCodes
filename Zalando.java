package practicecases;


	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Zalando {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions action = new Actions(driver);
			// go to url
			driver.manage().window().maximize();
			driver.get("https://www.zalando.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, 30);

			// Get the Alert text and print it
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			// Close the Alert box and click on Zalando.uk
			Thread.sleep(5000);
			driver.findElementByXPath("//a[text()='Zalando.uk']").click();
			// Click Women--> Clothing and click Coat
			Thread.sleep(5000);
			try {
				wait.until(
						ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[@id='uc-btn-accept-banner']")));
				driver.findElementByXPath("//button[@id='uc-btn-accept-banner']").click();
			} catch (Exception e) {
				System.out.println("msg not diplayed");
			}
			driver.findElementByXPath("//span[text()='Women']").click();
			action.moveToElement(driver.findElementByXPath("//span[text()='Clothing']")).perform();
			driver.findElementByXPath("//span[text()='Coats']").click();
			Thread.sleep(3000);
			// Choose Material as cotton (100%) and Length as thigh-length
			driver.findElementByXPath("//span[text()='Material']").click();
			driver.findElementByXPath("//span[text()='cotton (100%)']").click();
			driver.findElementByXPath("//button[text()='Save']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//span[text()='Length']").click();
			driver.findElementByXPath("//span[text()='thigh-length']").click();
			driver.findElementByXPath("//button[text()='Save']").click();
			Thread.sleep(3000);
			// Click on Q/S designed by MANTEL - Parka coat
			driver.findElementByXPath("//div[text()='Q/S designed by']").click();
			// Check the availability for Color as Olive and Size as 'M'
			driver.findElementByXPath("(//img[@alt='olive'])[2]").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='XS']").click();
			driver.findElementByXPath("//span[text()='M']").click();
			String msg = driver.findElementByXPath("//h2[text()='Out of stock']").getText();

			// If the previous preference is not available, check availability for Color
			// Navy and Size 'M'
			if (msg.contains("Out of stock")) {
				driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
			}
			Thread.sleep(3000);
			driver.findElementByXPath("//span[text()='Choose your size']").click();
			driver.findElementByXPath("//span[text()='M']").click();

			// Add to bag only if Standard Delivery is free
			String delivery = driver.findElementByXPath("(//span[@class='AtOZbZ'])[2]").getText();
			if (delivery.contains("Free")) {
				System.out.println("Standard delivery is : " + delivery);
				driver.findElementByXPath("//span[text()='Add to bag']").click();
			}
			// Mouse over on Your Bag and Click on "Go to Bag"
			driver.findElementByXPath("//div[text()='Go to bag']").click();
			// Capture the Estimated Deliver Date and print
			Thread.sleep(2000);
			String date = driver.findElementByXPath("//div[@data-id='delivery-estimation']/span").getText();
			System.out.println("Estimated delivery date is: " + date);
			// Mouse over on FREE DELIVERY & RETURNS*, get the tool tip text and print
			action.moveToElement(driver.findElementByXPath("//a[text()='Free delivery & returns*']")).perform();
			String title = driver.findElementByXPath("//a[text()='Free delivery & returns*']/ancestor::span")
					.getAttribute("title");
			System.out.println("Tool tip text is: " + title);
			// Click on Start chat in the Start chat and go to the new window
			driver.findElementByXPath("//a[text()='Free delivery & returns*']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='Start chat']").click();
			Set<String> set = driver.getWindowHandles();
			List<String> ls = new ArrayList<String>(set);
			driver.switchTo().window(ls.get(1));
			// Enter you first name and a dummy email and click Start Chat
			Thread.sleep(3000);
			driver.findElementByXPath("//input[@id='prechat_customer_name_id']").sendKeys("priya");
			driver.findElementByXPath("//input[@id='prechat_customer_email_id']").sendKeys("abc@gmail.com");
			driver.findElementByXPath("//button[@id='prechat_submit']").click();
			// Type Hi, click Send and print thr reply message and close the chat window.
			Thread.sleep(6000);
			driver.findElementByXPath("//textarea[@id='liveAgentChatTextArea']").sendKeys("Hi", Keys.ENTER);
			String replyMsg = driver.findElementByXPath("(//span[@class='messageText'])[4]").getText();
			System.out.println("Chat Msg: " + replyMsg);
			driver.close();
		}

	}


