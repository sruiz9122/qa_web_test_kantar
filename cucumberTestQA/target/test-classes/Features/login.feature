#Author: Sergio Ruiz
#Date: 20-Nov-2020
#Description: TestQA
@Regresion
Feature: Feature to test login functionality

  @loginTestQA
  Scenario: Check login is successful with valid credentials
    Given browser is open
    When user is on url "https://amrs-dev.engkantar.com/"
    And user enters username "testqa"
    And user enters password "#testqa@"
    And clicks on login button
    Then user is navigated to the home page
