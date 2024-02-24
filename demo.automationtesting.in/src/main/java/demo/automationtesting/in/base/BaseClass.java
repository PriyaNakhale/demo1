package demo.automationtesting.in.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Utilities/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void intilization() {
		String browsername = prop.getProperty("browser");
		System.out.println("initializing a browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")  + "/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")  + "/Driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

}
