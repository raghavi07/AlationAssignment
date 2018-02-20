package main.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class HomePage {

	@FindBy(id = "nav-logo")
	private WebElement navLogo;

	@FindBy(css = ".nav-searchbar")
	private WebElement searchBar;

	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdown;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement textBox;

	@FindBy(xpath = "//*[@class='nav-search-submit nav-sprite']/*[@class='nav-input']")
	private WebElement searchButton;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean isHomePageLoaded() {
		if (navLogo.isDisplayed()) {
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
		if (searchBar.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void selectProductCategory(String category) {
		Select oSelect = new Select(searchDropdown);
		oSelect.selectByVisibleText(category);
	}

	public void enterSearchText(String keyword) {
		textBox.sendKeys(keyword);
	}

	public void clickSearchButton() {
		searchButton.isDisplayed();
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
