
Feature: Login page verification

 
  Background: Successful login with valid credentials
    Given User Enter valid credentials
    When User clicks on submit button
   Then User should be able to navigate to salesForce hoe page.
@reg
  Scenario Outline: Create new account
    Given User navigates to Accounts page
    When User enters "<Accountname>" and create account
   # Then User verifies if Account is displayed on Account table


    Examples: 
     | Accountname |
     | BharaniR   |
 @reg @smoke
  Scenario: Create new account
    Given User navigates to Accounts page
    When User enter sampledata
   Then User sample data printing


   