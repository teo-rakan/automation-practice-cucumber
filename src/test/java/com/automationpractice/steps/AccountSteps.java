package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;
import com.automationpractice.pages.AccountPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.SignInPage;

public class AccountSteps extends BaseSteps {

    public AccountSteps() {
        When("^I create a new account$",
                () -> update(((SignInPage) page()).startAccountCreationWithRandomEmail()));
        And("^Fill out the personal information form$",
                () -> update(((CreateAccountPage) page()).createAccountWithRandomInformation()));
        And("^Try to login with login (.*) and password (.*)$", this::tryLogin);
        Then("^My account page should be open$", () -> ((AccountPage) page()).shouldBeAppear());
    }

    private void tryLogin(String email, String password) {
        SignInPage signInPage = (SignInPage) page();
        if (!(signInPage.tryLogin(email, password))) {
            signInPage.startAccountCreation(email).createAccountWithRandomInformation(password);
        }
    }

}
