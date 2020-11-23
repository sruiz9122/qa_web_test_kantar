#Author: Sergio Ruiz
#Date: 20-Nov-2020
#Description: TestQA
@RegresionCreate
Feature: Feature to test download .csv file

	@DownloadCSVFile
  Scenario: Into Countries and download CSV file
    Given Csv Open the site and log in username "testqa" and password "#testqa@"
    When Csv Into Home-Location-Countries
    And Click download CSV button
    Then Check CSV
