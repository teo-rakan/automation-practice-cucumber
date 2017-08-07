package com.automationpractice.steps;

import com.automationpractice.core.BaseSteps;
import com.automationpractice.pages.*;

public class ShoppingCartSteps extends BaseSteps {

    private int productId;

    public ShoppingCartSteps() {
        When("^I add '(.*)' to the shopping cart$",
                (String query) -> productId = ((HomePage) page()).addToCartFirstOf(query));
        And("^Go to the shopping cart summary page$",
                () -> update(((HomePage) page()).goToShoppingCartSummaryPage()));
        And("^Check the item in the shopping cart$",
                () -> ((ShoppingCartSummaryPage) page()).shouldHaveSize(1).shouldHaveProduct(productId));
        And("^Remove the item from the shopping cart$",
                () -> update(((ShoppingCartSummaryPage) page()).removeProduct(productId)));
        Then("^The shopping cart should be empty$", () -> ((ShoppingCartSummaryPage) page()).shouldHaveSize(0));
    }
}
