Feature: Checkout Module
  Verify checkout flow for SauceDemo

  Scenario: Complete checkout successfully
    Given user is on products page
    When user adds "Sauce Labs Backpack" to cart
    And user proceeds to checkout
    And user enters shipping details "John" "Doe" "12345"
    And user finishes checkout
    Then order should be completed

  Scenario: Checkout with multiple items
    Given user is on products page
    When user adds "Sauce Labs Backpack" to cart
    And user adds "Sauce Labs Bike Light" to cart
    And user proceeds to checkout
    And user enters shipping details "Jane" "Doe" "54321"
    And user finishes checkout
    Then order should be completed
