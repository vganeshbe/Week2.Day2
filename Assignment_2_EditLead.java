package Week.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2_EditLead {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		1. Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
//		2. Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
//		3. Enter the password		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
//		4. Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		5. Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
//		6. Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
//		7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
//		8. Enter first name
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='lastName']")).sendKeys("Vasudevan");
		
//		9. Click find leads button
		driver.findElement(By.xpath("//button[contains(.,'Find Leads')]")).click();
		
//		10. Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
//		11. Verify title of the page
		System.out.println(driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText()); 

//		12. Click Edit
		driver.findElement(By.xpath("//a[text() = 'Edit']")).click();
		
//		13. Change the company name
		String newCompanyName = "Copybook Copy Centre";
		WebElement elementCompanyName =  driver.findElement(By.xpath("(//input[@name='companyName'])[2]"));
		elementCompanyName.clear();
		elementCompanyName.sendKeys(newCompanyName);
		
//		14. Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
//		15. Capture name of First Resulting lead
		WebElement elementCompanyName1 = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String companyName = elementCompanyName1.getText();
		System.out.println(companyName);

		if(companyName.contains(newCompanyName)){
		System.out.println("Company name is updated...");
		}
		
//		18. Close the browser (Do not log out)
		driver.close();
		
	}
}
