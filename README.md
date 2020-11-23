#QA web Test - Sergio Ruiz
##Description
This project contains the automation of the web page: https://amrs-dev.engkantar.com

##installation
**Pre-Requisites: ** To install the project you must Have: Eclipse, Java JDK, Maven, Cucumber and Selenium installed.
1. You download the project, Open Eclipse you go to "file / new / project / maven / maven project" and select the downloaded files.
2. This project is verified in the chorme browser. therefore you must download the "chromedriver.exe" driver according to the version of the browser you use. You can download it at the following URL "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver"
3. This file must be saved in the following path: "\cucumberTestQA\src\test\resources\drivers"

###Class TestRunner.java
This file allows you to call the test scenario you want by modifying the TAG field. This class is located in the path: "\cucumberTestQA\src\test\java\StepDefinitions\TestRunner.java".

###files ".feature"
In the route "\cucumberTestQA\src\test\resources\Features" We have the files that present the required execution scenarios.

1. The file **login.feature** contains login.
2. The file **createcountry.feature** contains creation of a country.
3. The file **deletecountry.feature** contains deletion of a country.
4. The file **csvfile.feature** contains downloading and validating a .CSV file.

###Reports
The execution reports are in the following path:
\cucumberTestQA\target

####Open License


