package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;


public class ContactUsPage extends BasePage {
    private final By SUBJECT_SELECT = getLocator("ContactUs.SubjectSelect");
    private final By EMAIL_INPUT = getLocator("ContactUs.EmailInput");
    private final By ORDER_REF_INPUT = getLocator("ContactUs.OrderRefInput");
    private final By MESSAGE_TEXTAREA = getLocator("ContactUs.MessageTextarea");
    private final By FILENAME_INPUT = getLocator("ContactUs.FileNameInput");
    private final By SUBMIT_BUTTON = getLocator("ContactUs.SubmitButton");
    private final By ERROR_MESSAGE_ALERT = getLocator("ContactUs.ErrorMessageAlert");
    private final By SUCCESS_MESSAGE_ALERT = getLocator("ContactUs.SuccessMessageAlert");

    public ContactUsPage submitMessage(String subject, String email, String orderReference,
                                       String filepath, String message) {
        $(SUBJECT_SELECT).selectOption(subject);
        $(EMAIL_INPUT).val(email);
        $(ORDER_REF_INPUT).val(orderReference);
        $(FILENAME_INPUT).uploadFromClasspath(filepath);
        $(MESSAGE_TEXTAREA).val(message);
        $(SUBMIT_BUTTON).click();
        return page(ContactUsPage.class);
    }

    public void shouldHaveErrorMessage(String message) {
        $(ERROR_MESSAGE_ALERT).shouldHave(text(message));
    }

    public void shouldHaveSuccessMessage() {
        $(SUCCESS_MESSAGE_ALERT).shouldBe(appear);
    }
}
