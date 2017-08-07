package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import com.automationpractice.utils.RandomDataGenerator;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class SignInPage extends BasePage {
    private final By CREATE_ACCOUNT_EMAIL_INPUT = getLocator("SignIn.CreateAccountEmailInput");
    private final By CREATE_ACCOUNT_BUTTON = getLocator("SignIn.CreateAccountButton");
    private final By REGISTERED_EMAIL_INPUT = getLocator("SignIn.RegisteredEmailInput");
    private final By REGISTERED_PASSWORD_INPUT = getLocator("SignIn.RegisteredPasswordInput");
    private final By SIGN_IN_BUTTON = getLocator("SignIn.SignInButton");
    private final By PAGE_ID = getLocator("SignIn.id");

    public boolean tryLogin(String email, String password) {
        $(REGISTERED_EMAIL_INPUT).val(email);
        $(REGISTERED_PASSWORD_INPUT).val(password);
        $(SIGN_IN_BUTTON).click();
        return !$(PAGE_ID).exists();
    }

    public CreateAccountPage startAccountCreation(String email) {
        $(CREATE_ACCOUNT_EMAIL_INPUT).val(email);
        $(CREATE_ACCOUNT_BUTTON).click();
        return page(CreateAccountPage.class);
    }

    public CreateAccountPage startAccountCreationWithRandomEmail() {
        RandomDataGenerator random = new RandomDataGenerator();
        return startAccountCreation(random.newEmail());
    }
}
