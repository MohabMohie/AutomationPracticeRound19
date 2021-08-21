package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class GoogleHome {
	// driver
	private WebDriver driver;

	// element locators
	private By googleLogo_image = By.xpath("//img[@alt='Google']");
	private By googleSearch_textBox = By.name("q");

	// constructor
	public GoogleHome(WebDriver driver) {
		this.driver = driver;
	}

	// methods/actions/keywords
	public void navigate() {
//		driver.navigate().to("https://www.google.com/ncr");
		BrowserActions.navigateToURL(driver, "https://www.google.com/ncr", "https://www.google.com");
	}

//	public String getPageTitle() {
//		return BrowserActions.getCurrentWindowTitle(driver);
////		return driver.getTitle();
//	}

//	public boolean isGoogleLogoDisplayed() {
//		return ElementActions.isElementDisplayed(driver, googleLogo_image);
////		return driver.findElement(googleLogo_image).isDisplayed();
//	}
	
	public By getGoogleLogo() {
		return googleLogo_image;
	}

	/**
	 * This method will search for any query you need and then press enter to
	 * execute the search process
	 * 
	 * @param query the search string that you need to look for
	 */
	public SearchResults searchForQuery(String query) {
//		driver.findElement(googleSearch_textBox).sendKeys(query + Keys.ENTER);
//		ElementActions.type(driver, googleSearch_textBox, query);
//		ElementActions.keyPress(driver, googleSearch_textBox, Keys.ENTER);
		new ElementActions(driver).type(googleSearch_textBox, query).keyPress(googleSearch_textBox, Keys.ENTER);
		return new SearchResults(driver);
	}
}
