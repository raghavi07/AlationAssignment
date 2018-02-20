package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingDetailPage extends HomePage {

	String result = "result_INDEX";
	String resultInfoBar = "s-result-info-bar";
	String titleText = ".a-size-medium.s-inline.s-access-title.a-text-normal";
	String priceInfo = "//*[@class='a-fixed-left-grid-col a-col-right']/div[2]";

	public ListingDetailPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isListingPageLoaded() {
		if (driver.findElement(By.id(resultInfoBar)).isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getProductTitleByIndex(int index) {
		index = index - 1;
		result = result.replace("INDEX", String.valueOf(index));
		WebElement propertyIndex = driver.findElement(By.id(result));
		String title = propertyIndex.findElement(By.cssSelector(titleText)).getText();
		return title;
	}

	public String getProductPriceInfoByIndex(int index) {
		index = index - 1;
		result = result.replace("INDEX", String.valueOf(index));
		WebElement propertyIndex = driver.findElement(By.id(result));
		String info = null;
		info = propertyIndex.findElement(By.xpath(priceInfo)).getText();
		return info;
	}

	public void selectProductByIndex(int index) throws InterruptedException {
		index = index - 1;
		result = result.replace("INDEX", String.valueOf(index));
		WebElement propertyIndex = driver.findElement(By.id(result));
		propertyIndex.findElement(By.cssSelector(titleText)).click();
		System.out.println("Product at Index --> " + index + "  is selected");
	}
}
