#Author: Sergio Ruiz
#Date: 20-Nov-2020
#Description: TestQA
@RegresionCreate
Feature: Feature to test create country functionality

  @DeleteCountry
  Scenario: Into Countries and delet a country
    Given Open the site and log-in username "testqa" and password "#testqa@"
    When Into to Home-Location-Countries
    And Search country "Colombia"
    Then Delete country
