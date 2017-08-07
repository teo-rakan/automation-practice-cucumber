Feature: Order

  Background:

    Given I am on the sign in page
    And Try to login with login TeoRakan@gmail.com and password GHSZXy28G3skua2SmVi

  Scenario: Verify the ability to make an order and checks it ih the order history

    Given I am on the home page
    When I add 'Dress' to the shopping cart
    And Go to the shopping cart summary page
    And Check the shopping cart and proceed
    And Check the address and proceed
    And Check the shipping details and proceed
    And Select the bank wire payment and proceed
    And Confirm the order
    Then The order should be in the order history