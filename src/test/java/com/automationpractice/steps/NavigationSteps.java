package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;

import static com.automationpractice.core.BasePage.goToHomePage;

public class NavigationSteps extends BaseSteps {

    public NavigationSteps() {
        Given("^I am on the home page$", () -> update(goToHomePage()));
        Given("^I am on the sign in page$", () -> update(goToHomePage().goToSignInPage()));
        Given("^I am on the contact us page$", () -> update(goToHomePage().goToContactUsPage()));
    }
}
