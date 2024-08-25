@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  @Regression
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                  | password |
      | kuttanpilla@aaro.com  | Open@125 |
      | kuttanpilla2@aaro.com | Open@125 |
