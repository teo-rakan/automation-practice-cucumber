package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;
import com.automationpractice.pages.HomePage;

import static com.automationpractice.core.BasePage.goToHomePage;

public class CatalogSteps extends BaseSteps {

    public CatalogSteps() {
        When("^I open the T-shirt category$", () -> update(goToHomePage().openTShirtsCategory()));
        Then("^(\\d+) items should be found in the category$",
                (Integer expectedSize) -> ((HomePage) page()).shouldHaveCategoryResultsSize(expectedSize));
        And("^(.*) should be in the catalog results$",
                (String expectedItem) -> ((HomePage) page()).shouldHaveInCategoryResults(expectedItem));
    }
}
