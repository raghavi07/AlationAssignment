package test.java;

import java.io.FileWriter;
import java.io.IOException;

import main.java.BaseTest;
import main.java.HomePage;
import main.java.ListingDetailPage;

public class AppPage extends BaseTest{

	HomePage homePage;
	ListingDetailPage listingPage;
	public final String pageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	AppPage() {
		try {
			setUp();
			homePage = new HomePage(driver);
			listingPage = new ListingDetailPage(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeToFile(String result) throws IOException {
		FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\test-output\\Automation_Test_Result.txt");
		fw.append(result);
		fw.close();
	}
}
