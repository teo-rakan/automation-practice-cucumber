package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import com.automationpractice.utils.RandomDataGenerator;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class CreateAccountPage extends BasePage {
    private final By FIRST_NAME_INPUT = getLocator("CreateAccount.FirstNameInput");
    private final By LAST_NAME_INPUT = getLocator("CreateAccount.LastNameInput");
    private final By PASSWORD_INPUT = getLocator("CreateAccount.PasswordInput");
    private final By ADDRESS_INPUT = getLocator("CreateAccount.AddressInput");
    private final By CITY_INPUT = getLocator("CreateAccount.CityInput");
    private final By STATE_SELECT = getLocator("CreateAccount.StateSelect");
    private final By POSTCODE_INPUT = getLocator("CreateAccount.PostcodeInput");
    private final By PHONE_INPUT = getLocator("CreateAccount.PhoneInput");
    private final By REGISTER_BUTTON = getLocator("CreateAccount.RegisterButton");

    private CreateAccountPage setPersonalInformation(String firstName, String lastName) {
        $(FIRST_NAME_INPUT).val(firstName);
        $(LAST_NAME_INPUT).val(lastName);
        return this;
    }

    private CreateAccountPage setPassword(String password) {
        $(PASSWORD_INPUT).val(password);
        return this;
    }

    private CreateAccountPage setAddressInformation(String state, String city, String address, String postcode) {
        $(STATE_SELECT).selectOptionByValue(state);
        $(ADDRESS_INPUT).val(address);
        $(CITY_INPUT).val(city);
        $(POSTCODE_INPUT).val(postcode);
        return this;
    }

    private CreateAccountPage setPhone(String phone) {
        $(PHONE_INPUT).val(phone);
        return this;
    }

    private String getRandomState() {
        Random random = new Random();
        int stateCount = $(STATE_SELECT).$$(By.tagName("option")).size();
        int randomIndex = random.nextInt(stateCount);

        return $(STATE_SELECT).$$(By.tagName("option")).get(randomIndex).val();
    }

    private CreateAccountPage setRandomAccountInformation(String password) {
        RandomDataGenerator random = new RandomDataGenerator();

        return this.setPersonalInformation(random.newWord(), random.newWord())
                .setPassword(password)
                .setAddressInformation(getRandomState(), random.newWord(), random.newWord(), random.newNumber(5))
                .setPhone(random.newPhone(10));
    }

    private CreateAccountPage setRandomAccountInformation() {
        RandomDataGenerator random = new RandomDataGenerator();

        return setRandomAccountInformation(random.newPassword(5, 15));
    }

    public AccountPage createAccountWithRandomInformation() {
        setRandomAccountInformation();
        $(REGISTER_BUTTON).click();
        return page(AccountPage.class);
    }

    public AccountPage createAccountWithRandomInformation(String password) {
        setRandomAccountInformation(password);
        $(REGISTER_BUTTON).click();
        return page(AccountPage.class);
    }
}
