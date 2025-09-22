package tests;

import data.TestData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

/**
 * ContactModal test class containing tests for contact modal elements and functionality
 */
public class ContactModalTest extends BaseTest {

    @Test(description = "Verify contact modal elements and send message functionality")
    public void verifyContactModalElementsAndSendMessageFunctionality() {
        logger.info("Starting contact modal verification and send message test");

        // Navigate to homepage and verify product store link
        pm.homePage.navigateToHomePage();
        softly.assertThat(pm.homePage.getProductStoreLink().is(visible))
                .as("Product Store link should be visible")
                .isTrue();

        // Open contact modal
        pm.homePage.clickContact();

        // Verify contact modal elements
        softly.assertThat(pm.contactModal.getModalTitle().is(visible))
                .as("Contact modal title should be visible")
                .isTrue();

        softly.assertThat(pm.contactModal.getContactEmailLabel().is(visible))
                .as("Contact email label should be visible")
                .isTrue();

        softly.assertThat(pm.contactModal.getContactNameLabel().is(visible))
                .as("Contact name label should be visible")
                .isTrue();

        softly.assertThat(pm.contactModal.getMessageLabel().is(visible))
                .as("Message label should be visible")
                .isTrue();

        softly.assertThat(pm.contactModal.getCloseButton().is(visible))
                .as("Close button should be visible")
                .isTrue();

        softly.assertThat(pm.contactModal.getSendMessageButton().is(visible))
                .as("Send message button should be visible")
                .isTrue();

        // Send message with test data
        pm.contactModal.sendMessage(
                TestData.Contact.EMAIL,
                TestData.Contact.NAME,
                TestData.Contact.MESSAGE
        );

        logger.info("Contact modal verification and send message test completed");
    }
}