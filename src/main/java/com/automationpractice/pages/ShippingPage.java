package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class ShippingPage extends BasePage {
    private final By TERMS_CHECKBOX = getLocator("ShippingPage.TermsOfServiceCheckbox");
    private final By PROCEED_TO_CHECKOUT_BUTTON = getLocator("ShippingPage.ProceedToCheckoutButton");

    public PaymentMethodPage proceedAndGoToPaymentMethodPage() {
        $(TERMS_CHECKBOX).click();
        $(PROCEED_TO_CHECKOUT_BUTTON).click();
        return page(PaymentMethodPage.class);
    }
}
