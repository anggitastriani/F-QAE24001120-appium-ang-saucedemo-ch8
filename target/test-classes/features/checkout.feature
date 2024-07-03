Feature: Checkout

  Background: User is logged in
    Given User is on Login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    And User click login button
    And User is on Home page

    Scenario: User has successfully checked out the product
      Given User is on Home page
      And User add first item into the shopping cart
      And User scrolls to element with text "Sauce Labs Onesie"
      And User add second item into the shopping cart
      And User is on cart page
      And User scrolls to element with "CHECKOUT" on chart page
      And User click checkout button
      And User is on checkout information page
      And user enter first name with "anggit"
      And user enter last name with "astriani"
      And user enter postal code with "12345"
      And user click continue button
      And user is on checkout overview page
      And User scrolls to element with text "FINISH"
      When user click finish button
      Then user can see successful order message