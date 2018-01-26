package main.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	// WebElement categoryDropdown =
	// driver.findElement(By.id("searchDropdownBox"));
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean isHomePageLoaded() {
		if (driver.findElement(By.id("nav-logo")).isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public Boolean isSearchTextBoxPresent() {
		if (driver.findElement(By.cssSelector(".nav-searchbar")).isDisplayed()) {
			return true;
		}
		return false;
	}

	public void selectProductCategory(String category) {
		Select oSelect = new Select(driver.findElement(By.id("searchDropdownBox")));
		oSelect.selectByVisibleText(category);
	}

	public void enterSearchText(String keyword) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
	}

	public void clickSearchButton() {
		driver.findElement(By.xpath("//*[@class='nav-search-submit nav-sprite']/*[@class='nav-input']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
