#Author: Sergio Ruiz
#Date: 20-Nov-2020
#Description: TestQA
@RegresionCreate
Feature: Feature to test create country functionality

	@CreateCountry
  Scenario: Into Countries and create a country
    Given Open the site and log in username "testqa" and password "#testqa@"
    When Into Home-Location-Countries
    And Click add button
    And Click edit button
    And Insert Code "31"
    And Insert Name "Colombia"
    And Click save button
    Then User create a country
