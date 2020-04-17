package practicecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//1) Go to https://www.makemytrip.com/		
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//2) Click Hotels
		driver.findElementByXPath("//span[@class=\"chNavIcon appendBottom2 chSprite chHotels\"]").click();
		
		//3) Enter city as Goa, and choose Goa, India
		driver.findElementByXPath("//span[text()='City / Hotel / Area / Building']").click();
		driver.findElementByXPath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]").sendKeys("Goa");
		driver.findElementByXPath("//p[text()='Goa, India']").click();
		
		//4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5		
		driver.findElementById("checkin").click();
		WebElement Startdate= driver.findElementByXPath("(//div[text()='15'])[2]");
		
		String StartDate= driver.findElementByXPath("(//div[text()='15'])[2]").getText();
		System.out.println(StartDate);
		Startdate.findElement(By.xpath("(//div[text()='15'])[2]")).click();
		
		int checkindate = Integer.parseInt(StartDate);
		
		driver.findElementByXPath("//input[@id=\"checkout\"]").click();
		WebElement eleMonth = driver.findElementByXPath("//div[@class='DayPicker-Month'][2]");		
		eleMonth.findElement(By.xpath("(//div[text()='"+(checkindate+5)+"'])[2]")).click();
		
		//5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.		
		driver.findElementById("guest").click();
		driver.findElementByXPath("//li[@class=\"selected\"][1]").click();
		driver.findElementByXPath("(//li[text()='1'])[2]").click();
		WebElement childage =driver.findElementByClassName("ageSelectBox");
		childage.findElement(By.xpath("//select[@class=\"ageSelectBox\"]")).click();
		Select age=new Select(childage);
		age.selectByIndex(11);
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='APPLY']").click();
		
		//6) Click Search button
		driver.findElementByXPath("//button[text()='Search']").click();
		
		//7) Select locality as Baga
		driver.findElementByXPath("//body[@class=\"bodyFixed overlayWholeBlack\"]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[text()='Baga']").click(); 
		
		//8) Select 5 start in Star Category under Select Filters		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[text()='5 Star'])[1]").click();		
		
		//9) Click on the first resulting hotel and go to the new window
		driver.findElementByXPath("//p[@id=\"hlistpg_hotel_name\"][1]").click();
		Set <String> Window = driver.getWindowHandles();
		List <String> WinList=new ArrayList(Window);
		Thread.sleep(3000);
		driver.switchTo().window(WinList.get(1));
		String PageName = driver.getTitle();
		System.out.println(PageName);
		
		//10) Print the Hotel Name		
		String HotelName=driver.findElementByXPath("//h1[text()='Acron Waterfront Resort-Member ITC Hotel Group']").getText();
		System.out.println("HotelName is " + HotelName );
		
		//11) Click MORE OPTIONS link and Select 3Months plan and close
		driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();
		driver.findElementByXPath("//span[text()='SELECT'][1]").click();
		Thread.sleep(2000);
		driver.findElementByClassName("close").click();		
	
		//12) Click on BOOK THIS NOW
		driver.findElementByLinkText("BOOK THIS NOW").click();
		
		//13) Print the Total Payable amount
		String totalbill=driver.findElementById("revpg_total_payable_amt").getText();
		System.out.println("The Total Payable Amount is " + totalbill);
		
		//14) Close the browser
		Thread.sleep(3000);
		driver.quit();
		
		
	
	}

}
