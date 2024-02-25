package demo.automationtesting.in.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import demo.automationtesting.in.util.ActionClass;

public class DemoWebsite {
	@Test
	public static void testing() {
		//String path=System.getProperty("user.dir");
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///G:/selenium%20software/Offline%20Website/index.html");

		WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		emailElement.sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();

		// for click on "users"
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a")).click();
		//
		// for Add user button
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//input[@name='gender']"));
		ActionClass.radioClick(list, "female");
	}
}
