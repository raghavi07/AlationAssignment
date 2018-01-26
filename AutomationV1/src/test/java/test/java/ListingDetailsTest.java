package test.java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListingDetailsTest extends AppPage {

	@Test()
	public void booksSearchtest() throws InterruptedException, IOException {
		// Navigate to Home Page
		navigateToHomePage();
		// Validate if home page is loaded
		Assert.assertTrue(homePage.isHomePageLoaded(), "Home Page is not loaded");
		// Select any Product Category by passing as argument
		homePage.selectProductCategory("Books");
		// Validate if page title is as expected
		Assert.assertEquals(homePage.getPageTitle(), pageTitle, "Page Title is not as expected");
		// Validate if search text box is present
		Assert.assertTrue(homePage.isSearchTextBoxPresent(), "Search Text Box is not present");
		// Enter Search keyword by passing as argument
		homePage.enterSearchText("data catalog");
		// Click Search button
		homePage.clickSearchButton();
		// Validate if Listing page is loaded
		Assert.assertTrue(listingPage.isListingPageLoaded(), "Listing Detail Page is not loaded");
		String info = "Book Title : " + listingPage.getProductTitleByIndex(1);
		String priceinfo = "\nPrice Info : " + listingPage.getProductPriceInfoByIndex(1);
		info = info + "\n" + priceinfo;
		System.out.println(info);
		// Write result in the text file which is in the path ->.\\test-output\\Automation_Test_Result.txt
		writeToFile(info);
	}
}
