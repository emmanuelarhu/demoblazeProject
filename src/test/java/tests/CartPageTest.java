package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

/**
 * CartPage test class containing tests for cart page elements and complete purchase flow
 */
public class CartPageTest extends BaseTest {

    @Test(description = "Verify cart page elements and complete purchase flow")
    public void verifyCartPageElementsAndCompletePurchaseFlow() {
        logger.info("Starting cart page verification and purchase flow test");

        // Navigate to homepage and open cart
        pm.homePage.navigateToHomePage();
        pm.homePage.clickCart();

        // Verify cart page elements
        softly.assertThat(pm.cartPage.getProductsHeading().is(visible))
                .as("Products heading should be visible")
                .isTrue();

        softly.assertThat(pm.cartPage.getPicColumn().is(visible))
                .as("Pic column should be visible")
                .isTrue();

        softly.assertThat(pm.cartPage.getTitleColumn().is(visible))
                .as("Title column should be visible")
                .isTrue();

        softly.assertThat(pm.cartPage.getPriceColumn().is(visible))
                .as("Price column should be visible")
                .isTrue();

        softly.assertThat(pm.cartPage.getDeleteColumn().is(visible))
                .as("Delete column should be visible")
                .isTrue();

        softly.assertThat(pm.cartPage.getTotalHeading().is(visible))
                .as("Total heading should be visible")
                .isTrue();

        softly.assertThat(pm.cartPage.getPlaceOrderButton().is(visible))
                .as("Place Order button should be visible")
                .isTrue();

        // Click place order to open modal
        pm.cartPage.clickPlaceOrder();

        // Verify place order modal elements
        softly.assertThat(pm.placeOrderModal.getModalTitle().is(visible))
                .as("Place order modal title should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getTotalLabel().is(visible))
                .as("Total label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getNameLabel().is(visible))
                .as("Name label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getCountryLabel().is(visible))
                .as("Country label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getCityLabel().is(visible))
                .as("City label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getCreditCardLabel().is(visible))
                .as("Credit card label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getMonthLabel().is(visible))
                .as("Month label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getYearLabel().is(visible))
                .as("Year label should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getCloseButton().is(visible))
                .as("Close button should be visible")
                .isTrue();

        softly.assertThat(pm.placeOrderModal.getPurchaseButton().is(visible))
                .as("Purchase button should be visible")
                .isTrue();

        // Fill order details with test data
        pm.placeOrderModal.fillOrderDetails(
                TestData.Order.NAME,
                TestData.Order.COUNTRY,
                TestData.Order.CITY,
                TestData.Order.CREDIT_CARD,
                TestData.Order.MONTH,
                TestData.Order.YEAR
        );

        // Complete purchase
        pm.placeOrderModal.clickPurchase();

        // Verify purchase confirmation
        softly.assertThat(pm.purchaseConfirmationModal.getThankYouHeading().is(visible))
                .as("Thank you heading should be visible")
                .isTrue();

        softly.assertThat(pm.purchaseConfirmationModal.getOkButton().is(visible))
                .as("OK button should be visible")
                .isTrue();

        // Close confirmation modal
        pm.purchaseConfirmationModal.clickOk();

        logger.info("Cart page verification and purchase flow test completed");
    }
}