package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListingDetailPage extends HomePage {

	public ListingDetailPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isListingPageLoaded() {
		if (driver.findElement(By.id("s-result-info-bar")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public String getProductTitleByIndex(int index) {
		index = index - 1;
		WebElement propertyIndex = driver.findElement(By.id("result_" + index));
		String title = propertyIndex.findElement(By.cssSelector(".a-size-medium.s-inline.s-access-title.a-text-normal")).getText();
		return title;
	}
	
	public String getProductPriceInfoByIndex(int index) {
		index = index - 1;
		WebElement propertyIndex = driver.findElement(By.id("result_" + index));
		String info = null;
		info = propertyIndex.findElement(By.xpath("//*[@class='a-fixed-left-grid-col a-col-right']/div[2]")).getText();
		return info;
	}
}

