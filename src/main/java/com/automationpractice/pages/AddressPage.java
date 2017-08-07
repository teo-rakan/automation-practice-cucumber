package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class AddressPage extends BasePage {
    private final By PROCEED_TO_CHECKOUT = getLocator("AddressPage.ProceedToCheckout");

    public ShippingPage proceedAndGoToShippingPage() {
        $(PROCEED_TO_CHECKOUT).click();
        return page(ShippingPage.class);
    }
}
