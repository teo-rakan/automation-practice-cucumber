package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;
import static com.automationpractice.utils.LocatorRepository.getParametrizedLocator;

public class ShoppingCartSummaryPage extends BasePage {
    private final By PROCEED_TO_CHECKOUT_BUTTON = getLocator("ShoppingCartSummaryPage.ProceedToCheckoutButton");
    private final By PRODUCT_ROW = getLocator("ShoppingCartSummaryPage.ProductRow");
    private final String REMOVE_PRODUCT_PARAMETRIZED = "ShoppingCartSummaryPage.RemoveProductButton.Parametrized";
    private final String PRODUCT_ROW_PARAMETRIZED = "ShoppingCartSummaryPage.ProductRow.Parametrized";

    public AddressPage proceedAndGoToAddressPage() {
        $(PROCEED_TO_CHECKOUT_BUTTON).click();
        return page(AddressPage.class);
    }
    
    public ShoppingCartSummaryPage shouldHaveSize(int size) {
        $$(PRODUCT_ROW).shouldHaveSize(size);
        return this;
    }

    public ShoppingCartSummaryPage shouldHaveProduct(int id) {
        By productRow = getParametrizedLocator(PRODUCT_ROW_PARAMETRIZED, id);
        $(productRow).shouldBe(exist);
        return this;
    }

    public ShoppingCartSummaryPage removeProduct(int id) {
        By removeButton = getParametrizedLocator(REMOVE_PRODUCT_PARAMETRIZED, id);
        $(removeButton).click();
        return page(ShoppingCartSummaryPage.class);
    }
}
