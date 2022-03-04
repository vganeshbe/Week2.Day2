package Week.Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1_FaceBook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//a[@role = 'button'])[2]")).click();
		driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("Hrithika");
		driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("GL");
		driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys("hrithikagl@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys("Test12345");
		
		WebElement elementDay = driver.findElement(By.xpath("//select[@id = 'day']"));
		Select day = new Select(elementDay);
		day.selectByValue("19");
		
		WebElement elementMonth = driver.findElement(By.xpath("//select[@id = 'month']"));
		Select month = new Select(elementMonth);
		month.selectByValue("1");

		WebElement elementYear = driver.findElement(By.xpath("//select[@id = 'year']"));
		Select year = new Select(elementYear);
		year.selectByValue("2008");

		driver.findElement(By.xpath("//input[@value='1']")).click();		
		
	}
}
