# Endava Test Automation

This test framework contains tests written for [Samsara](http://172.17.167.71:9010)  website and its source is divided into main and test sections. Main section consists of “pages” and “util” packages. In “pages” package there are classes for each page of Samsara website and their superclass BasePage. Methods which describe the functionalities of pages are written in them.

“Util” package consists of Utils class and log4j.xml file. Utils class sets up web browser options and enables capturing screenshots of test failures. Logging for test framework is enabled with log4j.xml file.

Every test class enables testing of different page of Samsara website:

   *	TestBase (superclass of every test class);
   *	TestLoginPage;
   *	TestHomePage;
   *	TestRegisterNewAccountPage;
   *  TestProfilePage
   *	TestUsersPage;
   *	TestAdminPage;
   *	TestHeroesPage;
   *	TestGalleryPage
   *	TestBrokenLinkPage;

Resources bundle has testng.xml file which has xml suite with added tests for each page.

All tests take screen shots on failure.

### Pre-requisites

    Java 8 or higher
    Web browser (Firefox, Chrome, Internet Explorer)
    Maven
    Selenium Webdriver
    TestNG

### Running Tests

The following steps should get you set up for running Selenium tests locally on your machine:

    1. Clone this repository to your local machine.
    2. Declare this project as Maven
    3. Run as TestNG

### Supported browsers

    1. Firefox
    2. Internet Explorer
    3. Chrome

Choose browser by setting it as a parameter in testng.xml file.

