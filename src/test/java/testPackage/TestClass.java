package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.validation.ValidationEnums.BrowserAttribute;
import com.shaft.validation.ValidationEnums.ElementAttribute;
import com.shaft.validation.Validations;

import pages.GoogleHome;
import pages.SearchResults;

public class TestClass {
	private WebDriver driver;

	// regular page objects
//	private SearchResults resultsPage;

	@Test
	public void checkThatGooglePageTitleIsCorrect() {
//		String pageTitle = new GoogleHome(driver).getPageTitle();
//		Assert.assertEquals(pageTitle, "Google");
		Validations.assertThat().browser(driver).attribute(BrowserAttribute.TITLE).isEqualTo("Google")
		.withCustomReportMessage("Checking to see that the page title is equal to 'Google'").perform();
	}

	@Test
	public void checkThatGoogleLogoIsDisplayed() {
//		boolean isGoogleLogoDisplayed = new GoogleHome(driver).isGoogleLogoDisplayed();
//		Assert.assertTrue(isGoogleLogoDisplayed);
		Validations.assertThat()
		.element(driver, new GoogleHome(driver).getGoogleLogo())
		.matchesReferenceImage()
		.withCustomReportMessage("Checking to see that the Google logo image matches the reference image")
		.perform();
	}

	@Test
	public void checkThatTheResultStatsIsNotEmpty() {
		new GoogleHome(driver).searchForQuery("Selenium WebDriver");
//		String resultStatsText = resultsPage.getResultStatsText();
//		Assert.assertNotEquals("", resultStatsText);
		Validations.assertThat()
		.element(driver, new SearchResults(driver).getResultStats())
		.attribute(ElementAttribute.TEXT)
		.doesNotEqual("")
		.withCustomReportMessage("Checking to see that the result stats is not empty")
		.perform();
	}

	@Test
	public void checkThatTheResultStatsIsNotEmptyInCaseSearchingForSHAFT_Engine() {
		
		
		new GoogleHome(driver).searchForQuery("SHAFT_Engine");
		// fluent design
//		String resultStatsText = new GoogleHome(driver).searchForQuery("SHAFT_Engine").getResultStatsText();
//		Assert.assertNotEquals("", resultStatsText);
		Validations.assertThat()
		.element(driver, new SearchResults(driver).getResultStats())
		.attribute(ElementAttribute.TEXT).doesNotEqual("").perform();
		
	}

	@BeforeMethod
	public void beforeMethod() {
//		driver = new ChromeDriver();
		driver = DriverFactory.getDriver();

//		resultsPage = new SearchResults(driver);

		// Anonymous Object
		new GoogleHome(driver).navigate();

	}

	@AfterMethod
	public void afterMethod() {
//		driver.quit();
		DriverFactory.closeAllDrivers();
	}

}
