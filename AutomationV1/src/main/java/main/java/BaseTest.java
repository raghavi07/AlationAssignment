package main.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {

	public static WebDriver driver = null;
	Properties p = new Properties();
	static final String configPath = "\\src\\main\\java\\config.properties";
	static final String chromeDriverPath = "\\resources\\drivers\\chromedriver.exe";

	// This method called for the browser init
	public void setUp() throws IOException {
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + configPath);

		p.load(fi);
		System.out.println(p.getProperty("browser"));

		if (p.getProperty("browser").contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (p.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);

			driver = new ChromeDriver();
		}
	}

	public void navigateToHomePage() throws InterruptedException {
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
