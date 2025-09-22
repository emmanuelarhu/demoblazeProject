package pages;

import com.codeborne.selenide.SelenideElement;
import data.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * HomePage class containing all elements and actions for the DemoBlaze homepage
 */
public class HomePage extends BasePage {

    // Navigation elements
    private final SelenideElement productStoreLink = $(".navbar-brand");
    private final SelenideElement homeLink = $("a[href='index.html']");
    private final SelenideElement contactLink = $("a[data-target='#exampleModal']");
    private final SelenideElement aboutUsLink = $("a[data-target='#videoModal']");
    private final SelenideElement cartLink = $("#cartur");
    private final SelenideElement loginLink = $("#login2");
    private final SelenideElement signupLink = $("#signin2");
    private final SelenideElement logoutLink = $("#logout2");
    private final SelenideElement welcomeUserLink = $("#nameofuser");

    // Category elements
    private final SelenideElement categoriesLink = $(byLinkText("CATEGORIES"));
    private final SelenideElement phonesLink = $(byLinkText("Phones"));
    private final SelenideElement laptopsLink = $(byLinkText("Laptops"));
    private final SelenideElement monitorsLink = $(byLinkText("Monitors"));

    // Product elements
    private final SelenideElement firstProductCard = $("#tbodyid .card:first-child");
    private final SelenideElement samsungGalaxyS6Link = $(byLinkText("Samsung galaxy s6"));
    private final SelenideElement nokiaLumiaLink = $(byLinkText("Nokia lumia 1520"));
    private final SelenideElement nexusLink = $(byLinkText("Nexus 6"));
    private final SelenideElement samsungGalaxyS7Link = $(byLinkText("Samsung galaxy s7"));
    private final SelenideElement iphone6Link = $(byLinkText("Iphone 6 32gb"));
    private final SelenideElement sonyXperiaZ5Link = $(byLinkText("Sony xperia z5"));
    private final SelenideElement htcOneM9Link = $(byLinkText("HTC One M9"));
    private final SelenideElement sonyVaioI5Link = $(byLinkText("Sony vaio i5"));
    private final SelenideElement sonyVaioI7Link = $(byLinkText("Sony vaio i7"));

    // Navigation buttons
    private final SelenideElement prevButton = $("#prev2");
    private final SelenideElement nextButton = $("#next2");

    // Footer elements
    private final SelenideElement aboutUsText = $(byText("About Us"));
    private final SelenideElement getInTouchText = $(byText("Get in Touch"));
    private final SelenideElement footerProductStoreHeading = $(byText("PRODUCT STORE"));
    private final SelenideElement addressText = $(byText("Address: 2390 El Camino Real"));
    private final SelenideElement phoneText = $(byText("Phone: +440"));
    private final SelenideElement emailText = $(byText("Email: demo@blazemeter.com"));

    /**
     * Navigate to the DemoBlaze homepage
     */
    @Step("Navigate to DemoBlaze homepage")
    public void navigateToHomePage() {
        logger.info("Navigating to DemoBlaze homepage");
        goTo(TestData.BASE_URL);
        waitForPageLoad();
    }

    /**
     * Click on Login link
     */
    @Step("Click Login link")
    public void clickLogin() {
        logger.info("Clicking Login link");
        clickElement(loginLink);
    }

    /**
     * Click on Signup link
     */
    @Step("Click Signup link")
    public void clickSignup() {
        logger.info("Clicking Signup link");
        clickElement(signupLink);
    }

    /**
     * Click on Contact link
     */
    @Step("Click Contact link")
    public void clickContact() {
        logger.info("Clicking Contact link");
        clickElement(contactLink);
    }

    /**
     * Click on About Us link
     */
    @Step("Click About Us link")
    public void clickAboutUs() {
        logger.info("Clicking About Us link");
        clickElement(aboutUsLink);
    }

    /**
     * Click on Cart link
     */
    @Step("Click Cart link")
    public void clickCart() {
        logger.info("Clicking Cart link");
        clickElement(cartLink);
    }

    /**
     * Click on Logout link
     */
    @Step("Click Logout link")
    public void clickLogout() {
        logger.info("Clicking Logout link");
        clickElement(logoutLink);
    }

    /**
     * Click on Welcome User link
     */
    public void clickWelcomeUser() {
        logger.info("Clicking Welcome User link");
        clickElement(welcomeUserLink);
    }

    // Getter methods for elements (for verification)
    public SelenideElement getProductStoreLink() { return productStoreLink; }
    public SelenideElement getHomeLink() { return homeLink; }
    public SelenideElement getContactLink() { return contactLink; }
    public SelenideElement getAboutUsLink() { return aboutUsLink; }
    public SelenideElement getCartLink() { return cartLink; }
    public SelenideElement getLoginLink() { return loginLink; }
    public SelenideElement getSignupLink() { return signupLink; }
    public SelenideElement getLogoutLink() { return logoutLink; }
    public SelenideElement getWelcomeUserLink() { return welcomeUserLink; }
    public SelenideElement getCategoriesLink() { return categoriesLink; }
    public SelenideElement getPhonesLink() { return phonesLink; }
    public SelenideElement getLaptopsLink() { return laptopsLink; }
    public SelenideElement getMonitorsLink() { return monitorsLink; }
    public SelenideElement getFirstProductCard() { return firstProductCard; }
    public SelenideElement getSamsungGalaxyS6Link() { return samsungGalaxyS6Link; }
    public SelenideElement getNokiaLumiaLink() { return nokiaLumiaLink; }
    public SelenideElement getNexusLink() { return nexusLink; }
    public SelenideElement getSamsungGalaxyS7Link() { return samsungGalaxyS7Link; }
    public SelenideElement getIphone6Link() { return iphone6Link; }
    public SelenideElement getSonyXperiaZ5Link() { return sonyXperiaZ5Link; }
    public SelenideElement getHtcOneM9Link() { return htcOneM9Link; }
    public SelenideElement getSonyVaioI5Link() { return sonyVaioI5Link; }
    public SelenideElement getSonyVaioI7Link() { return sonyVaioI7Link; }
    public SelenideElement getPrevButton() { return prevButton; }
    public SelenideElement getNextButton() { return nextButton; }
    public SelenideElement getAboutUsText() { return aboutUsText; }
    public SelenideElement getGetInTouchText() { return getInTouchText; }
    public SelenideElement getFooterProductStoreHeading() { return footerProductStoreHeading; }
    public SelenideElement getAddressText() { return addressText; }
    public SelenideElement getPhoneText() { return phoneText; }
    public SelenideElement getEmailText() { return emailText; }

    // Price getters with dynamic text selection
    public SelenideElement getPrice360() { return $(byText("$360")); }
    public SelenideElement getPrice820() { return $(byText("$820")); }
    public SelenideElement getPrice650() { return $(byText("$650")); }
    public SelenideElement getPrice800() { return $(byText("$800")); }
    public SelenideElement getPrice320() { return $(byText("$320")); }
    public SelenideElement getPrice700() { return $(byText("$700")); }
}