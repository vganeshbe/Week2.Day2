package Week.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2_Duplicate {

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
		
//		8. Click on Email
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		
//		9. Enter Email
		driver.findElement(By.xpath("//input[@name = 'emailAddress']")).sendKeys("");
		
//		10. Click find leads button
		driver.findElement(By.xpath("//button[contains(.,'Find Leads')]")).click();
		
//		11. Capture name of First Resulting lead
		WebElement elementFirstName = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String firstName = elementFirstName.getText();
		System.out.println(firstName);
		
//		12. Click First Resulting lead
		elementFirstName.click();
		
//		13. Click Duplicate Lead
		driver.findElement(By.xpath("//a[text() = 'Duplicate Lead']")).click();

//		14. Verify the title as 'Duplicate Lead'
		WebElement elementHeaderTitle = driver.findElement(By.xpath("//div[@id = 'sectionHeaderTitle_leads']"));
		String headerTitle = elementHeaderTitle.getText();
		System.out.println(headerTitle);

		if(headerTitle.contains("Duplicate")){
		System.out.println("We are in Duplicate Lead creation...");
		}
		
//		15. Click Create Lead
		driver.findElement(By.xpath("//input[@value = 'Create Lead']")).click();
		
		
//		16. Confirm the duplicated lead name is same as captured name
		String text = driver.findElement(By.xpath("//span[@id = 'viewLead_firstName_sp']")).getText();
		
		System.out.println(text + " = " + firstName);
		
		if(text == firstName){
			System.out.println("Duplicate Lead Created...");
		}
		
//		18. Close the browser (Do not log out)
		driver.close();
		
	}
}
