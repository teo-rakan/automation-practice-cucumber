Feature: Catalog

  Scenario: Verify the catalog data

    Given I am on the home page
    When I open the T-shirt category
    Then 1 items should be found in the category
    And T-Shirt should be in the catalog results