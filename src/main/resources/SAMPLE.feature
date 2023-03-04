
#Author: Bharani Ravisankar
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Background: Successful login with valid credentials
    Given User Enter valid credentials
    When User clicks on submit button
    Then User should be able to navigate to salesForce hoe page.

  @tag2
  Scenario Outline: Create new account
    Given User navigates to Accounts page
    When User enters <Accountname> and create account
    Then User verifies if Account is displayed on Account table

    Examples: 
      | Accountname  | 
      | Bharani R |
      | name2 | 
