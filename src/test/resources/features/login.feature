@Login
Feature: Login

  @positive-test
  Scenario: Login using valid username and valid password
    Given User is on Login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click login button
    Then User is on Home page

  @negative-test
  Scenario: Login using valid username and invalid password
    Given User is on Login page
    And User input username with "standard_user"
    And User input password with "wrong_pass"
    When User click login button
    Then User redirect to Login page
    And Error message appears