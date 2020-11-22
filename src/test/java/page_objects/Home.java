package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private final By HomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By DownPaymentInDollar = By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By MonthDropDown = By.name("param[start_month]");
    private final By Year = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HOI = By.id("hoi");
    private final By HOA = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By RefiOrBuy = By.name("param[refiorbuy]");
    private final By Calculate = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public Home(WebDriver driver) {
        super(driver);
    }

    // Enter Home Value
    public Home typeHomePrice(String value) {
        LOGGER.debug("Entered Home Price is: " + value);
        ActOn.element(driver, HomeValue).setValue(value);
        return this;
    }

    // Enter downpayment
    public Home typeDownPayment(String value) {
        LOGGER.debug("Entered DownPayment is: " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    // Select the radio button $
    public Home clickDownPaymentInDollar() {
        LOGGER.debug("Clicked on DownPayment in Dollar radio button");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    // Enter Loan Amount
    public Home typeLoanAmount(String value) {
        LOGGER.debug("Entered Loan Amount is: " + value);
        ActOn.element(driver, LoanAmount).setValue(value);
        return this;
    }

    // Enter the interest rate
    public Home typeInterestRate(String value) {
        LOGGER.debug("Entered Interest Rate is: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    // Enter loan term in years
    public Home typeLoanTermYears(String value) {
        LOGGER.debug("Entered Loan Term years: " + value);
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;
    }

    // Select the month
    public Home selectMonth(String month) {
        LOGGER.debug("Selected Month is: " + month);
        ActOn.element(driver, MonthDropDown).selectValue(month);
        return this;
    }

    // Select the year
    public Home selectYear(String year) {
        LOGGER.debug("Selected Year is: " + year);
        ActOn.element(driver, Year).setValue(year);
        return this;
    }

    // Enter property tax
    public Home typePropertyTax(String value) {
        LOGGER.debug("Entered Property Tax is: " + value);
        ActOn.element(driver, PropertyTax).setValue(value);
        return this;
    }

    // Enter PMI
    public Home typePmi(String value) {
        LOGGER.debug("Entered PMI is: " + value);
        ActOn.element(driver, PMI).setValue(value);
        return this;
    }

    // Enter Homeowner Insurance
    public Home typeHomeOwnerInsurance(String value) {
        LOGGER.debug("Entered Home Owner Insurance is: " + value);
        ActOn.element(driver, HOI).setValue(value);
        return this;
    }

    // Enter Monthly HOA
    public Home typeMonthlyHoa(String value) {
        LOGGER.debug("Entered Monthly HOA: " + value);
        ActOn.element(driver, HOA).setValue(value);
        return this;
    }

    // Select Loan Type
    public Home selectLoanType(String value) {
        LOGGER.debug("Selected Loan Type is: " + value);
        ActOn.element(driver, LoanType).selectValue(value);
        return this;
    }

    // Select "Buy or Refi" option
    public Home selectBuyOrRefinance(String value) {
        LOGGER.debug("Selected Buy or Refi option is: " + value);
        ActOn.element(driver, RefiOrBuy).selectValue(value);
        return this;
    }

    // Click on Calculate Button
    public Home clickOnCalculateButton() {
        LOGGER.debug("Clicked on Calculate Button");
        ActOn.element(driver,Calculate).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String totalMonthlyPayment) {
        LOGGER.info("Expected Total monthly payment is: " + totalMonthlyPayment);
        By monthlyPaymentLocator = By.xpath("//*[@id='calc']//h3[text()='" + totalMonthlyPayment + "']");
        AssertThat.elementAssertions(driver, monthlyPaymentLocator).elementExist();
        return this;
    }
}
