package Week.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2_DeleteLead {

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
		
//		8. Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		
//		9. Enter phone number
		driver.findElement(By.xpath("//input[@name = 'phoneNumber']")).sendKeys("123456");
		
//		10. Click find leads button
		driver.findElement(By.xpath("//button[contains(.,'Find Leads')]")).click();
		
//		11.Capture lead ID of First Resulting lead
		WebElement elementLeadID = driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String leadID = elementLeadID.getText();
		
//		12. Click Leads link
		elementLeadID.click();
		
		System.out.println(leadID);
		
//		13. Click Delete
		driver.findElement(By.xpath("//a[@class = 'subMenuButtonDangerous']")).click();

//		14. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		System.out.println(leadID);
		
//		15. Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		
//		16. Click find leads button
		driver.findElement(By.xpath("//button[contains(.,'Find Leads')]")).click();
		
//		17. Verify message "No records to display" in the Lead List. This message confirms the successful deletion
//		String text = driver.findElement(By.xpath("//div[contains(text(), 'No records to display')]")).getText(););
		
		String elementLeadMessage = driver.findElement(By.xpath("//div[contains(text(), 'No records to display')]")).getText();
		
		if(elementLeadMessage.contains("No records")){
			System.out.println("Record delected sucessfully...");
		}
		
//		18. Close the browser (Do not log out)
		driver.close();
		
	}
}
