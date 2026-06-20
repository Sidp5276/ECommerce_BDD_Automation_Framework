Feature: SauceDemo Login
  Validate login behavior for SauceDemo application

  Scenario: Valid Login with standard_user
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then login should be successful and show products page

  Scenario: Invalid Login wrong password
    Given user is on login page
    When user logs in with username "standard_user" and password "wrongpwd"
    Then login should fail with error "do not match"

  Scenario: Empty Username
    Given user is on login page
    When user logs in with username "" and password "secret_sauce"
    Then login should fail with error "Username is required"

  Scenario: Empty Password
    Given user is on login page
    When user logs in with username "standard_user" and password ""
    Then login should fail with error "Password is required"

  Scenario: Locked out user
    Given user is on login page
    When user logs in with username "locked_out_user" and password "secret_sauce"
    Then login should fail with error "locked out"

  Scenario: Problem user login
    Given user is on login page
    When user logs in with username "problem_user" and password "secret_sauce"
    Then login should be successful and show products page

  Scenario: Performance glitch user
    Given user is on login page
    When user logs in with username "performance_glitch_user" and password "secret_sauce"
    Then login should be successful and show products page

  Scenario: Error user (known issues)
    Given user is on login page
    When user logs in with username "error_user" and password "secret_sauce"
    Then login should be successful and show products page
