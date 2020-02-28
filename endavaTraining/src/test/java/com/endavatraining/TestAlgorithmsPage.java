package com.endavatraining;



import com.endavatraining.pages.AdminPage;

import com.endavatraining.pages.AlgorithmsPage;

import com.endavatraining.pages.HeroesPage;

import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LogedInPage;
import com.endavatraining.pages.LoginPage;

import com.endavatraining.util.Utils;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.*;



public class TestAlgorithmsPage extends TestLoginPage {



    private LoginPage loginPage;
    private LogedInPage logedinPage;

    private HomePage homePage;

    private AlgorithmsPage algorithmsPage;

    private By algorithmsPageButton = By.linkText("Algorithms");

    public static Logger log = Logger.getLogger(TestAlgorithmsPage.class);

    
	public By Algorithms = By.linkText("Algorithms");
    

	private static String username = "user";

	private static String password = "password";

	private static String formControl = "6";

	private static String searchKey = "ana";

	private static String vgnKey = "FJv6Jb";

	private static String letter = "e";

	private By userNameBy = By.id("username");

	private By passWordBy = By.id("password");

    

    @BeforeSuite

    public void setup() {

        System.out.println("Running testAlgorithmsPage Test.");

    }

    

    @BeforeTest

	@Parameters({"browser"})

	public void setUp(String browser) {

		loginPage = Utils.setUpWebBrowser(browser);

	}



    @AfterTest

    public void tearDown() {

        if (algorithmsPage != null)

        	algorithmsPage.quit();

    }



	/*

	 * Test validates that algorithms page is opened by checking if Submit button is

	 * visible on the page

	 */

    /*
     * Test validates that algorithms page is opened by checking if Submit button is
     * visible on the page
     */
    @Test
    public void testAlgorithmsPageIsOpened() {
       
        //1. User is logged and home page is present
        log.info("Test is Algorithms Page is opened");
        homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
        //2. Click to Algorithms Tab to open Algorithms Page
        logedinPage.goToPage(Algorithms);
    }

}