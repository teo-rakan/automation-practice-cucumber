Feature: Account

  Scenario: Verify the ability to register

    Given I am on the sign in page
    When I create a new account
    And Fill out the personal information form
    Then My account page should be open