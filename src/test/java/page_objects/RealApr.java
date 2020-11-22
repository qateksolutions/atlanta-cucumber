package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private final By CalculateTab = By.xpath("//*[@id='CalcForm']//label[text()='Calculator']");
    private final By HomeValue = By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAPR = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[contains(text(),'Actual APR')]/../../td[2]/strong");
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver) {
        super(driver);
    }

    // Wait for the element to be visible
    public RealApr waitForPageToLoad() {
        ActOn.wait(driver, CalculateTab).waitForElementToBeVisible();
        return this;
    }

    // Enter Home Value
    public RealApr typeHomePrice(String value) {
        ActOn.element(driver, HomeValue).setValue(value);
        LOGGER.debug("Entered Home Price is: " + value);
        return this;
    }

    // Enter DownPayment
    public RealApr typeDownPayment(String value) {
        ActOn.element(driver, DownPayment).setValue(value);
        LOGGER.debug("Entered Down Payment is: " + value);
        return this;
    }

    // Click on DownPayment in $ Radio Button
    public RealApr selectDownPaymentInDollar() {
        ActOn.element(driver, DownPaymentInDollar).click();
        LOGGER.debug("Select Down Payment in $");
        return this;
    }

    // Enter Interest Rate
    public RealApr typeInterestRate(String value) {
        ActOn.element(driver, InterestRate).setValue(value);
        LOGGER.debug("Entered Interest Rate is: " + value);
        return this;
    }

    // Click on Calculate Button
    public RealApr clickOnCalculateButton() {
        ActOn.element(driver, CalculateButton).click();
        LOGGER.debug("Clicked on Calculate Button");
        return this;
    }

    // Validate the APR
    public RealApr validateAprRate(String expectedValue) {
        LOGGER.debug("Validating that Real APR rate is: " + expectedValue);
        String aprRate = ActOn.element(driver, ActualAPR).getTextValue();
        Assert.assertEquals(aprRate, expectedValue);
        return this;
    }
}
