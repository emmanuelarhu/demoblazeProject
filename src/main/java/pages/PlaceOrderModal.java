package pages;

import com.codeborne.selenide.SelenideElement;
import data.TestData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * PlaceOrderModal class containing all elements and actions for the place order modal
 */
public class PlaceOrderModal extends BasePage {

    private final SelenideElement modalTitle = $(byText("Place order ×"));
    private final SelenideElement totalLabel = $(byText("Total:"));
    private final SelenideElement nameField = $("#name");
    private final SelenideElement countryField = $("#country");
    private final SelenideElement cityField = $("#city");
    private final SelenideElement creditCardField = $("#card");
    private final SelenideElement monthField = $("#month");
    private final SelenideElement yearField = $("#year");
    private final SelenideElement nameLabel = $("[aria-labelledby='orderModalLabel']").$("form").$("div").$(byText("Name:"));
    private final SelenideElement countryLabel = $("[aria-labelledby='orderModalLabel']").$("form").$("div").$(byText("Country:"));
    private final SelenideElement cityLabel = $("[aria-labelledby='orderModalLabel']").$("form").$("div").$(byText("City:"));
    private final SelenideElement creditCardLabel = $("[aria-labelledby='orderModalLabel']").$("form").$("div").$(byText("Credit card:"));
    private final SelenideElement monthLabel = $("[aria-labelledby='orderModalLabel']").$("form").$("div").$(byText("Month:"));
    private final SelenideElement yearLabel = $("[aria-labelledby='orderModalLabel']").$("form").$("div").$(byText("Year:"));
    private final SelenideElement purchaseButton = $("button").$(byText("Purchase"));
    private final SelenideElement closeButton = $("[aria-labelledby='orderModalLabel']").$(byText("Close"));

    /**
     * Fill order details with provided data
     */
    public void fillOrderDetails() {
        logger.info("Filling order details");
        fillInput(nameField, TestData.Order.NAME);
        fillInput(countryField, TestData.Order.COUNTRY);
        fillInput(cityField, TestData.Order.CITY);
        fillInput(creditCardField, TestData.Order.CREDIT_CARD);
        fillInput(monthField, TestData.Order.MONTH);
        fillInput(yearField, TestData.Order.YEAR);
    }

    /**
     * Fill order details with custom data
     * @param name Customer name
     * @param country Country
     * @param city City
     * @param creditCard Credit card number
     * @param month Expiry month
     * @param year Expiry year
     */
    public void fillOrderDetails(String name, String country, String city, String creditCard, String month, String year) {
        logger.info("Filling order details with custom data");
        fillInput(nameField, name);
        fillInput(countryField, country);
        fillInput(cityField, city);
        fillInput(creditCardField, creditCard);
        fillInput(monthField, month);
        fillInput(yearField, year);
    }

    /**
     * Click Purchase button
     */
    public void clickPurchase() {
        logger.info("Clicking Purchase button");
        clickElement(purchaseButton);
    }

    /**
     * Close the place order modal
     */
    public void close() {
        logger.info("Closing place order modal");
        clickElement(closeButton);
    }

    // Getter methods for verification
    public SelenideElement getModalTitle() { return modalTitle; }
    public SelenideElement getTotalLabel() { return totalLabel; }
    public SelenideElement getNameField() { return nameField; }
    public SelenideElement getCountryField() { return countryField; }
    public SelenideElement getCityField() { return cityField; }
    public SelenideElement getCreditCardField() { return creditCardField; }
    public SelenideElement getMonthField() { return monthField; }
    public SelenideElement getYearField() { return yearField; }
    public SelenideElement getNameLabel() { return nameLabel; }
    public SelenideElement getCountryLabel() { return countryLabel; }
    public SelenideElement getCityLabel() { return cityLabel; }
    public SelenideElement getCreditCardLabel() { return creditCardLabel; }
    public SelenideElement getMonthLabel() { return monthLabel; }
    public SelenideElement getYearLabel() { return yearLabel; }
    public SelenideElement getPurchaseButton() { return purchaseButton; }
    public SelenideElement getCloseButton() { return closeButton; }
}