Feature: Sorting

  Background: User is logged in
    Given User is on Login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    And User click login button
    And User is on Home page

  Scenario: Sorting item from low to high price
    Given User is on Home page
    And User is click filter button
    When User is select price low to high button
    Then User can see products from lowest to highest price