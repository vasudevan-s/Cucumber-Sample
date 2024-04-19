Feature: Products Functionality
  As a user I want to be able to add products to the shopping cart

  Scenario Outline: Validate adding product to shopping cart
    Given I am on the list of products page
    When I randomly select an available product from the list
    Then I should be navigated to the selected product page
    And I add <numberOfItems> of the product selected to the shopping cart
    Then The shopping cart should display the correct count of the product added
    Examples:
      | numberOfItems |
      | 3 |