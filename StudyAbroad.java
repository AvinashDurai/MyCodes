package practicecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class StudyAbroad {

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
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
//			1) Go to https://studyabroad.shiksha.com/
			driver.get("https://studyabroad.shiksha.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("URL loaded");
			
//			2) Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges//
			action.moveToElement(driver.findElementByXPath("//label[text()='Colleges ']")).build().perform();
			driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
			
//			3) Select GRE under Exam Accepted and Score 300 & Below//
			Thread.sleep(3000);
			driver.findElementByXPath("//p[text()='GRE']").click();
			System.out.println("Clicked on GRE");
			Thread.sleep(2000);
			WebElement ele1 = driver.findElementByXPath("//select[@class='score-select-field']");
			Select score = new Select(ele1);
			score.selectByVisibleText("284 & below");
			System.out.println("284 & below selected");
			
//			4) Max 10 Lakhs under 1st year Total fees, USA under countries
			Thread.sleep(3000);
			driver.findElementByXPath("//p[text()='Max 10 Lakhs']").click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='USA']/ancestor::label/span")));
			WebElement ele = driver.findElementByXPath("//a[text()='USA']/ancestor::label/span");
			executor.executeScript("arguments[0].click()", ele);
			System.out.println("USA selected");
			
			//Verify if above filters are applied
//			WebElement eleGRE = driver.findElementByXPath("//div[@class='selected-items']/p[text()='GRE']");
//			if(eleGRE.isDisplayed()) 
//				{
//				System.out.println("GRE filter applied");
//				}
//			WebElement eleFirstyrFee = driver.findElementByXPath("//div[@class='selected-items']/p[text()='Max 10 Lacs']");
//			if(eleFirstyrFee.isDisplayed()) 
//				{
//				System.out.println("Max 10 Lakhs exam fee filter applied");
//				}
//			WebElement eleCountry = driver.findElementByXPath("//div[@class='selected-items']/p[text()='USA']");
//			if(eleCountry.isDisplayed()) 
//				{
//				System.out.println("USA filter applied");
//				}
			
//			driver.findElementByXPath("(//ul[@class='refine-list']//a)[4]").click();
//			System.out.println("Fees and Country selected");
			
//			5) Select Sort By: Low to high 1st year total fees//
			//wait.until(ExpectedConditions.elementToBeSelected(driver.findElementById("categorySorter")));
			Thread.sleep(3000);
			WebElement ele2 = driver.findElementByXPath("//select[@class='sort-select']");
			wait.until(ExpectedConditions.visibilityOfAllElements(ele2));
			Select fees = new Select(ele2);
			fees.selectByVisibleText("Low to high 1st year total fees");
			System.out.println("Fees sorted by asc");	
			
//			Thread.sleep(3000);
//			driver.findElementByXPath("//a[text()='OK']").clear();
			
//			6) Click Add to compare of the College having least 
		//fees with Public University, Scholarship and Accomadation//
			String collegesCount = driver.findElementByXPath("//span[@id='foundCoursesCount']").getText();
			System.out.println(collegesCount);
			List<WebElement> eleColleges = driver.findElementsByXPath("//div[contains(@class,'univ-tab-details')]//div[contains(@id,'categoryPageListing')]");
			//System.out.println(eleColleges);
			if(eleColleges.size()==Integer.parseInt(collegesCount.replaceAll("\\D", "")))
			{
				System.out.println("Number of colleges returned for the filters applied: "+eleColleges.size());
			}
			
			Map<String,Float> Lmap= new LinkedHashMap();
			for(int i=1; i<=eleColleges.size();i++) {
				Thread.sleep(3000);
				String PublicUniv = driver.findElementByXPath("//p[text()='Public university']/span["+i+"]").getAttribute("class");
				String Scholarship = driver.findElementByXPath("//p[text()='Scholarship']/span["+i+"]").getAttribute("class");
				String Accomodation = driver.findElementByXPath("//p[text()='Accommodation']/span["+i+"]").getAttribute("class");
				if(PublicUniv.equalsIgnoreCase("tick-mark")&& Scholarship.equalsIgnoreCase("tick-mark") && Accomodation.equalsIgnoreCase("tick-mark")) {
					String AnuualFees = driver.findElementByXPath("(//strong[text()=' 1st Year Total Fees']/following-sibling::p)["+i+"]").getText();
					float AnnualFee = Float.parseFloat(AnuualFees.replaceAll("[^0-9.]",""));
					System.out.println(AnnualFee);
					Lmap.put(""+i, AnnualFee);
					float TotalNumberofcollegeshavingllfeatures = Lmap.size();
					
					

					 List<Float> listAnnualFee = new ArrayList<Float>();
					 System.out.println("Total number of colleges having all the 3 options: "+Lmap.size());
					 System.out.println("Displaying the annual fees of the colleges having all the 3 options---->");
					 	 for (Entry<String, Float> eachEle : Lmap.entrySet()) {		 
							 System.out.println(eachEle);
							listAnnualFee.add(eachEle.getValue());	
					 	 }
							
					Collections.sort(listAnnualFee);
					Float lowestFloat = listAnnualFee.get(0);
					for (Entry<String, Float> eachEle : Lmap.entrySet()) {		 
					if(eachEle.getValue().equals(lowestFloat)) {
					String key = eachEle.getKey();
					Thread.sleep(3000);
					driver.findElementByXPath("(//p[text()='Add to compare'])["+key+"]").click();
					break;
				}

					System.out.println("Best College: Selected and the Annual fee is "+listAnnualFee.get(0));
			}
			//System.out.println(collegesCount);
			
//			7) Select the first college under Compare with similar colleges//
					Thread.sleep(3000);
					driver.findElementByXPath("(//div[@id='recommendationDiv']//a)[1]").click();
					System.out.println("Selected another college to compare");
					
					
//			8) Click on Compare College>					
					driver.findElementByXPath("//strong[text()='Compare Colleges >']").click();
					System.out.println("Compare button : clicked");
					
//			9) Select When to Study as 2021//
					driver.findElementByXPath("//label[@for='year1']/span").click();
					System.out.println("Year: Selected");
					
//			10) Select Preferred Countries as USA//
					driver.findElementByXPath("//div[text()='Preferred Countries']").click();
					driver.findElementByXPath("//label[contains(@for,'USA')]").click();
					driver.findElementByLinkText("ok").click();
					System.out.println("Preferred country: selected");
					
//			11) Select Level of Study as Masters//
					driver.findElementByXPath("//strong[text()='Masters']").click();
					System.out.println("Study level: selected");
					driver.findElementByXPath("//div[text()='Preferred Course']").click();
					driver.findElementByXPath("//li[text()='MS']").click();
					System.out.println("Preferred course: selected");
					Thread.sleep(3000);
					
//			12) Select Preferred Course as MS
					driver.findElementByXPath("//li[text()='MS']").click();
					System.out.println("Preferred course: selected");
					
					
////		13) Select Specialization as "Computer Science & Engineering"//
					Thread.sleep(3000);
					driver.findElementByXPath("//li[text()='Computer Science & Engineering']").click();
					System.out.println("Computer Science & Engineering Selected");
					
//			14) Click on Sign Up//
					driver.findElementById("signup").click();
					
//			15) Print all the warning messages displayed on the screen for missed mandatory fields
					List<WebElement> listofErrorMsgs = driver.findElementsByXPath("//div[contains(@id,'error')]/div[@class='helper-text' and contains(text(),'Please')]");
					for (WebElement eacherrormsg : listofErrorMsgs) {
						System.out.println(eacherrormsg.getText());
						
					}
					

				}
			}
	}
}
			

