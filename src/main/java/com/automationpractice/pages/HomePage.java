package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class HomePage extends BasePage {
    private final By ACCOUNT_LINK = getLocator("HomePage.AccountLink");
    private final By SEARCH_INPUT = getLocator("HomePage.SearchInput");
    private final By SEARCH_RESULT_PRODUCT_NAME = getLocator("HomePage.SearchResult.ProductName");
    private final By CATEGORY_RESULT_PRODUCT_NAME = getLocator("HomePage.Category.ProductName");
    private final By CATEGORY_WOMAN_LINK = getLocator("HomePage.CategoryLink.Woman");
    private final By CATEGORY_T_SHIRTS_LINK = getLocator("HomePage.CategoryLink.TShirts");
    private final By ADD_PRODUCT_TO_CART_BUTTON = getLocator("HomePage.AddToCartButton");
    private final By SHOPPING_CART_LINK = getLocator("HomePage.CartLink");
    private final By CART_LAYER = getLocator("HomePage.CartLayer");
    private final By CART_LAYER_PROCEED_BUTTON = getLocator("HomePage.CartLayer.ProceedToCheckoutButton");
    // The navigation bar. Later it can be moved to the BasePage class
    private final By CONTACT_US_LINK = getLocator("HomePage.ContactUsLink");
    private final By SIGN_IN_LINK = getLocator("HomePage.SignInLink");

    public ContactUsPage goToContactUsPage() {
        $(CONTACT_US_LINK).click();
        return page(ContactUsPage.class);
    }

    public SignInPage goToSignInPage() {
        $(SIGN_IN_LINK).click();
        return page(SignInPage.class);
    }

    public boolean isUserLoggedIn() {
        return !$(SIGN_IN_LINK).exists();
    }

    public HomePage search(String query) {
        $(SEARCH_INPUT).val(query);
        $(SEARCH_INPUT).pressEnter();
        return page(HomePage.class);
    }

    // Returns the id of the product that was added to the cart.
    public int addToCartFirstOf(String query) {
        String url;
        int productId;

        search(query);
        $(SEARCH_RESULT_PRODUCT_NAME).shouldBe(exist);
        url = $(SEARCH_RESULT_PRODUCT_NAME).getAttribute("href");
        productId = Integer.parseInt(getIdFromURL(url));
        $(SEARCH_RESULT_PRODUCT_NAME).hover();
        $(ADD_PRODUCT_TO_CART_BUTTON).shouldBe(appear).click();
        $(CART_LAYER).shouldBe(appear);

        return productId;
    }

    public ShoppingCartSummaryPage goToShoppingCartSummaryPage() {
        if ($(CART_LAYER).exists())
            $(CART_LAYER_PROCEED_BUTTON).click();
        else
            $(SHOPPING_CART_LINK).click();
        return page(ShoppingCartSummaryPage.class);
    }

    public AccountPage goToAccountPage() {
        $(ACCOUNT_LINK).click();
        return page(AccountPage.class);
    }

    public HomePage openTShirtsCategory() {
        $(CATEGORY_WOMAN_LINK).hover();
        $(CATEGORY_T_SHIRTS_LINK).shouldBe(appear).click();
        return page(HomePage.class);
    }

    public void shouldHaveInCategoryResults(String name) {
        $$(CATEGORY_RESULT_PRODUCT_NAME).findBy(text(name)).shouldBe(exist);
    }

    public void shouldHaveInSearchResults(String name) {
        $$(SEARCH_RESULT_PRODUCT_NAME).findBy(text(name)).shouldBe(exist);
    }

    public HomePage shouldHaveCategoryResultsSize(int size) {
        $$(CATEGORY_RESULT_PRODUCT_NAME).shouldHaveSize(size);
        return this;
    }

    public HomePage shouldHaveSearchResultsSize(int size) {
        $$(SEARCH_RESULT_PRODUCT_NAME).shouldHaveSize(size);
        return this;
    }

    private String getIdFromURL(String url) {
        String idRegex = "(?<=[&\\?]id_product=)\\d*";
        Pattern idPattern = Pattern.compile(idRegex);
        Matcher matcher = idPattern.matcher(url);

        if (!matcher.find()) {
            throw new IllegalStateException("Cannot get the id parameter from the '" + url
                    + "' URL using regex: '" + idRegex);
        }

        return matcher.group();
    }
}
