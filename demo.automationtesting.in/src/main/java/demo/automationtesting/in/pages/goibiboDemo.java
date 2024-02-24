package demo.automationtesting.in.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import demo.automationtesting.in.util.ActionClass;

public class goibiboDemo {
	@Test
	public static void testing() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!617695092667!e!goibibo!c!&gad_source=1&gclid=Cj0KCQiA5rGuBhCnARIsAN11vgR7er8iuUHsNgmEgzFBhr9D6elLZH--7VLlwNXq2b3Ocp0okkblGGAaAnudEALw_wcB");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/span/span")).click();
		driver.findElement(By.xpath("//*[@id='root']/div[2]/p[1]")).click();
		//Thread.sleep(2000);
		List<WebElement> flightTypelist = driver.findElements(By.xpath("// p[@class='sc-gEvEer gpfTmR']"));
		ActionClass.groupElementClick(flightTypelist, "Round-trip");
		
		List<WebElement> fareTypelist = driver.findElements(By.xpath("// ul//span[starts-with(@class,'sc-12foipm-2')]"));
		ActionClass.groupElementClick(fareTypelist, "Regular");
		WebElement ele=driver.findElement(By.xpath("//a[@class='sc-12foipm-77 jYnAuG']"));
		ActionClass.click(ele);
		
		driver.findElement(By.xpath("//span[@class='sc-1f95z5i-6 kxwWAw header-sprite nav-icon-hotels']")).click();
		List<WebElement> country = driver.findElements(By.xpath("input[name='CountryType']"));
		ActionClass.radioClick(country, "India");
		
		
		
		
	}
}
