package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

/**
 * HomePage test class containing tests for homepage elements and layout
 */
public class HomePageTest extends BaseTest {

    @Test(description = "Verify homepage elements and layout")
    public void verifyHomepageElementsAndLayout() {
        logger.info("Starting homepage elements verification test");

        // Navigate to homepage
        pm.homePage.navigateToHomePage();

        // Verify navigation elements
        softly.assertThat(pm.homePage.getProductStoreLink().is(visible))
                .as("Product Store link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getHomeLink().is(visible))
                .as("Home link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getContactLink().is(visible))
                .as("Contact link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getAboutUsLink().is(visible))
                .as("About Us link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getCartLink().is(visible))
                .as("Cart link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getLoginLink().is(visible))
                .as("Login link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getSignupLink().is(visible))
                .as("Signup link should be visible")
                .isTrue();

        // Verify category elements
        softly.assertThat(pm.homePage.getCategoriesLink().is(visible))
                .as("Categories link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPhonesLink().is(visible))
                .as("Phones link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getLaptopsLink().is(visible))
                .as("Laptops link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getMonitorsLink().is(visible))
                .as("Monitors link should be visible")
                .isTrue();

        // Verify product elements
        softly.assertThat(pm.homePage.getFirstProductCard().is(visible))
                .as("First product card should be visible")
                .isTrue();

        // Samsung Galaxy S6
        softly.assertThat(pm.homePage.getSamsungGalaxyS6Link().is(visible))
                .as("Samsung Galaxy S6 link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPrice360().is(visible))
                .as("$360 price should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.SAMSUNG_GALAXY_S6)).is(visible))
                .as("Samsung Galaxy S6 description should be visible")
                .isTrue();

        // Nokia Lumia
        softly.assertThat(pm.homePage.getNokiaLumiaLink().is(visible))
                .as("Nokia Lumia link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPrice820().is(visible))
                .as("$820 price should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.NOKIA_LUMIA)).is(visible))
                .as("Nokia Lumia description should be visible")
                .isTrue();

        // Nexus
        softly.assertThat(pm.homePage.getNexusLink().is(visible))
                .as("Nexus link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPrice650().is(visible))
                .as("$650 price should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.NEXUS)).is(visible))
                .as("Nexus description should be visible")
                .isTrue();

        // Samsung Galaxy S7
        softly.assertThat(pm.homePage.getSamsungGalaxyS7Link().is(visible))
                .as("Samsung Galaxy S7 link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPrice800().is(visible))
                .as("$800 price should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.SAMSUNG_GALAXY_S7)).is(visible))
                .as("Samsung Galaxy S7 description should be visible")
                .isTrue();

        // iPhone 6
        softly.assertThat(pm.homePage.getIphone6Link().is(visible))
                .as("iPhone 6 link should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.IPHONE_6)).is(visible))
                .as("iPhone 6 description should be visible")
                .isTrue();

        // Sony Xperia Z5
        softly.assertThat(pm.homePage.getSonyXperiaZ5Link().is(visible))
                .as("Sony Xperia Z5 link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPrice320().is(visible))
                .as("$320 price should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.SONY_XPERIA_Z5)).is(visible))
                .as("Sony Xperia Z5 description should be visible")
                .isTrue();

        // HTC One M9
        softly.assertThat(pm.homePage.getHtcOneM9Link().is(visible))
                .as("HTC One M9 link should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPrice700().is(visible))
                .as("$700 price should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.HTC_ONE_M9)).is(visible))
                .as("HTC One M9 description should be visible")
                .isTrue();

        // Sony Vaio i5
        softly.assertThat(pm.homePage.getSonyVaioI5Link().is(visible))
                .as("Sony Vaio i5 link should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.SONY_VAIO_I5)).is(visible))
                .as("Sony Vaio i5 description should be visible")
                .isTrue();

        // Sony Vaio i7
        softly.assertThat(pm.homePage.getSonyVaioI7Link().is(visible))
                .as("Sony Vaio i7 link should be visible")
                .isTrue();

        softly.assertThat($(byText(TestData.Descriptions.SONY_VAIO_I7)).is(visible))
                .as("Sony Vaio i7 description should be visible")
                .isTrue();

        // Verify navigation buttons
        softly.assertThat(pm.homePage.getPrevButton().is(visible))
                .as("Previous button should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getNextButton().is(visible))
                .as("Next button should be visible")
                .isTrue();

        // Verify footer elements
        softly.assertThat(pm.homePage.getAboutUsText().is(visible))
                .as("About Us text should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getGetInTouchText().is(visible))
                .as("Get in Touch text should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getFooterProductStoreHeading().is(visible))
                .as("Footer Product Store heading should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getAddressText().is(visible))
                .as("Address text should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getPhoneText().is(visible))
                .as("Phone text should be visible")
                .isTrue();

        softly.assertThat(pm.homePage.getEmailText().is(visible))
                .as("Email text should be visible")
                .isTrue();

        logger.info("Homepage elements verification test completed");
    }
}