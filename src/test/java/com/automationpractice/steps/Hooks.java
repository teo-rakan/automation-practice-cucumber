package com.automationpractice.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.Scenario;
import cucumber.api.java8.En;

import static com.codeborne.selenide.Selenide.open;

public class Hooks implements En {

    public Hooks() {
        Configuration.timeout = 12000;
        Configuration.baseUrl = "http://automationpractice.com/index.php";

        Before((Scenario scenario) -> open(Configuration.baseUrl));
        After(Selenide::close);
    }
}
