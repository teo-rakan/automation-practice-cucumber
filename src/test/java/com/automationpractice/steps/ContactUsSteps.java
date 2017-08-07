package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;
import com.automationpractice.pages.ContactUsPage;

public class ContactUsSteps extends BaseSteps {
    private final String SUBJECT_HEADING = "Customer service";
    private final String EMAIL = "test@gmail.com";
    private final String ORDER_REFERENCE = "ORDERREF - 01/01/2000";
    private final String FILE_PATH = "attachment.txt";

    public ContactUsSteps() {
        When("^I complete the contact us form$", () -> submitMessage("Some message text"));
        When("^I complete the contact us form except the message$", () -> submitMessage(""));
        Then("^Contact us page should have a success message$",
                () -> ((ContactUsPage) page()).shouldHaveSuccessMessage());
        Then("^Contact us page should have error message: (.*)$",
                (String message) -> ((ContactUsPage) page()).shouldHaveErrorMessage(message));
    }

    private void submitMessage(String message) {
        update(((ContactUsPage) page()).submitMessage(SUBJECT_HEADING, EMAIL, ORDER_REFERENCE, FILE_PATH, message));
    }
}
