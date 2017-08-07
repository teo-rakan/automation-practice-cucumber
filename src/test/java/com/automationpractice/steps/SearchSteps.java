package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;
import com.automationpractice.pages.HomePage;

public class SearchSteps extends BaseSteps {

    public SearchSteps() {
        When("^I search (.*)$", (String query) -> update(((HomePage) page()).search(query)));
        Then("^(.*) should be in the search results$",
                (String expectedItem) -> ((HomePage) page()).shouldHaveInSearchResults(expectedItem));
    }
}
