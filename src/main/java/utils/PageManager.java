package utils;

import pages.*;

/**
 * PageManager class - Central manager for all page objects
 * Provides single access point to all page object instances
 */
public class PageManager {

    public final HomePage homePage;
    public final LoginModal loginModal;
    public final SignUpModal signUpModal;
    public final ContactModal contactModal;
    public final AboutUsModal aboutUsModal;
    public final CartPage cartPage;
    public final PlaceOrderModal placeOrderModal;
    public final PurchaseConfirmationModal purchaseConfirmationModal;

    /**
     * Constructor initializes all page objects
     */
    public PageManager() {
        this.homePage = new HomePage();
        this.loginModal = new LoginModal();
        this.signUpModal = new SignUpModal();
        this.contactModal = new ContactModal();
        this.aboutUsModal = new AboutUsModal();
        this.cartPage = new CartPage();
        this.placeOrderModal = new PlaceOrderModal();
        this.purchaseConfirmationModal = new PurchaseConfirmationModal();
    }
}