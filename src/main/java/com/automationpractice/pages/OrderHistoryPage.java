package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class OrderHistoryPage extends BasePage {

    public void shouldHaveOrderReference(String orderReference) {
        $(By.linkText(orderReference)).shouldBe(exist);
    }
}
