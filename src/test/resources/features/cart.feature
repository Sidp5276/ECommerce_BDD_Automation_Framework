Feature: Cart Module
  Verify adding/removing items to the cart

  Scenario: Add single product to cart
    Given user is on products page
    When user adds "Sauce Labs Backpack" to cart
    And user opens cart
    Then cart contains "Sauce Labs Backpack"

  Scenario: Add two products to cart
    Given user is on products page
    When user adds "Sauce Labs Backpack" to cart
    And user adds "Sauce Labs Bike Light" to cart
    And user opens cart
    Then cart contains "Sauce Labs Backpack"
    And cart contains "Sauce Labs Bike Light"

  Scenario: Add product to cart and verify it is present
    Given user is on products page
    When user adds "Sauce Labs Bolt T-Shirt" to cart
    And user opens cart
    Then cart contains "Sauce Labs Bolt T-Shirt"

  Scenario: Add expensive product to cart
    Given user is on products page
    When user adds "Sauce Labs Fleece Jacket" to cart
    And user opens cart
    Then cart contains "Sauce Labs Fleece Jacket"
