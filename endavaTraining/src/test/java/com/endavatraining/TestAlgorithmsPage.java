package com.endavatraining;

import com.endavatraining.pages.AdminPage;
import com.endavatraining.pages.AlgorithmsPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 *
 * @author Srboljub.Todorovic
 *
 */

public class TestAlgorithmsPage extends TestBase {

	
    private LoginPage loginPage;
    private HomePage homePage;
    private AlgorithmsPage algorithmsPage;
    public AlgorithmsPage adminPage;
    private By algorithmsPageButton = By.linkText("Algorithms");
    public static Logger log = Logger.getLogger(TestAlgorithmsPage.class);

    /*
     * Before Test suite message
     * @author ana.acanski
     *
     */
    
    @BeforeSuite
    public void setup() {
        System.out.println("Running testAlgorithmsPage Test.");
    }
    
    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        algorithmsPage = Utils.setUpWebBrowserAlgorithms(browser);
    }

	/*
	 * Test validates that login page is opened by checking if log in button is
	 * visible on the page
	 */
	@Test
	public void testAlgorithmsPageIsOpened() {
		log.info("Test is Algorithms Page is opened");
		algorithmsPage.open();
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getSubmitButton()));
	}

    /*
     * After Test suite message
     * @author ana.acanski
     *
     */


    @AfterTest
    public void tearDown() {
        if (algorithmsPage != null)
        	algorithmsPage.quit();
    }
}