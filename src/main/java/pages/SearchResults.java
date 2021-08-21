package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
	//driver
	private WebDriver driver;
	private By searchResult;
	
	//locators
	private By resultStats_label = By.id("result-stats");
	
	//constructor
	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}
	
//	//keywords/actions/methods
//	public String getResultStatsText() {
////		return driver.findElement(resultStats_label).getText();
//		return ElementActions.getText(driver, resultStats_label);
//	}
	
	public By getResultStats () {
		return resultStats_label;
	}
	
	public String getSearchResultText(int resultNumber) {
		searchResult = By.xpath("(//div[@id='rso']/div[@class='g']//h3)["+resultNumber+"]");
		return driver.findElement(searchResult).getText();
	}
	
	public By getSearchResult(int resultNumber) {
		return By.xpath("(//div[@id='rso']/div[@class='g']//h3)["+resultNumber+"]");
	}
}
