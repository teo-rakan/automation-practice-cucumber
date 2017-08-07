package com.automationpractice.core;

import com.automationpractice.pages.HomePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class BasePage {
    private final static By HOME_BUTTON = getLocator("BasePage.HomeButton");
    private final static By HOME_PAGE_ID = getLocator("HomePage.id");

    public static HomePage goToHomePage() {
        if (!$(HOME_PAGE_ID).exists())
            $(HOME_BUTTON).click();
        return page(HomePage.class);
    }
}
