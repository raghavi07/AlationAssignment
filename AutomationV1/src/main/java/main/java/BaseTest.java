package main.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver = null;
	Properties p = new Properties();

	// @BeforeTest()
	public void setUp() throws IOException {
		FileInputStream fi = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\config.properties");

		p.load(fi);
		System.out.println(p.getProperty("browser"));

		if (p.getProperty("browser").contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (p.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}
	}

	public void navigateToHomePage() throws InterruptedException {
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
