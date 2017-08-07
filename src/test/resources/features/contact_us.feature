Feature: Contact Us

  Scenario: Verify that the contact us form sends successfully

    Given I am on the contact us page
    When I complete the contact us form
    Then Contact us page should have a success message

  Scenario: Verify that the error message appears if the message area is empty

    Given I am on the contact us page
    When I complete the contact us form except the message
    Then Contact us page should have error message: The message cannot be blank