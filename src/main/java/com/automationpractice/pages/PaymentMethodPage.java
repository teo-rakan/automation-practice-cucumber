package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class PaymentMethodPage extends BasePage {
    private final By PAY_BY_BANK_WIRE_BUTTON = getLocator("PaymentMethodPage.PayByBankWireButton");
    private final By PAY_BY_CHECK_BUTTON = getLocator("PaymentMethodPage.PayByCheckButton");

    public ConfirmOrderPage selectBankWirePayment() {
        $(PAY_BY_BANK_WIRE_BUTTON).click();
        return page(ConfirmOrderPage.class);
    }

    public ConfirmOrderPage selectCheckPayment() {
        $(PAY_BY_CHECK_BUTTON).click();
        return page(ConfirmOrderPage.class);
    }
}
