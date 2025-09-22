package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * CartPage class containing all elements and actions for the cart page
 */
public class CartPage extends BasePage {

    private final SelenideElement productsHeading = $("h2").$(byText("Products"));
    private final SelenideElement picColumn = $("th").$(byText("Pic"));
    private final SelenideElement titleColumn = $("th").$(byText("Title"));
    private final SelenideElement priceColumn = $("th").$(byText("Price"));
    private final SelenideElement deleteColumn = $("th").$(byText("x"));
    private final SelenideElement totalHeading = $("h3").$(byText("Total"));
    private final SelenideElement placeOrderButton = $("button").$(byText("Place Order"));

    /**
     * Click Place Order button
     */
    public void clickPlaceOrder() {
        logger.info("Clicking Place Order button");
        clickElement(placeOrderButton);
    }

    // Getter methods for verification
    public SelenideElement getProductsHeading() { return productsHeading; }
    public SelenideElement getPicColumn() { return picColumn; }
    public SelenideElement getTitleColumn() { return titleColumn; }
    public SelenideElement getPriceColumn() { return priceColumn; }
    public SelenideElement getDeleteColumn() { return deleteColumn; }
    public SelenideElement getTotalHeading() { return totalHeading; }
    public SelenideElement getPlaceOrderButton() { return placeOrderButton; }
}