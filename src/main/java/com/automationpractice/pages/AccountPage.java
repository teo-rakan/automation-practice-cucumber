package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class AccountPage extends BasePage {
    private final By PAGE_ID = getLocator("AccountPage.id");
    private final By ORDER_HISTORY_BUTTON = getLocator("AccountPage.OrderHistoryButton");

    public OrderHistoryPage goToOrderHistoryPage() {
        $(ORDER_HISTORY_BUTTON).click();
        return page(OrderHistoryPage.class);
    }

    public void shouldBeAppear() {
        $(PAGE_ID).shouldBe(exist);
    }

}
