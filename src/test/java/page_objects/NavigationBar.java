package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");

    WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    // Mouse Hover to Rates Link
    public NavigationBar mouseHoverToRates() {
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }

    // Clicking on Real Apr Link from the Rates
    public RealApr clickOnRealApr() {
        ActOn.element(driver, RealAprLink).click();
        return new RealApr(driver);
    }

    public Home navigateToHome() {
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }
}
