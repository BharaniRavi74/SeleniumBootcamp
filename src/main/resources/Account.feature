#Author: Bharaniravi74@gmail.com|
Feature: Login page verification

 
  Scenario: Successful login with valid credentials
    Given User Enter valid credentials
    When User clicks on submit button
    Then User should be able to navigate to salesForce hoe page.

