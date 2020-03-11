package com.endavatraining;

import org.testng.annotations.AfterTest;
import com.endavatraining.pages.BasePage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LogedInPage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class LogedInTest extends BaseTest {

	protected LogedInPage logedInPage;
	protected BasePage basePage;
	protected HomePage homePage;
	protected LoginPage loginPage;

	public static Logger log = Logger.getLogger(LogedInTest.class);
	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_PASSWORD = "password";
	public static final String USER_USERNAME = "user";
	public static final String USER_PASSWORD = "password";

	public By Samsara = By.linkText("Samsara");
	public By Algorithms = By.linkText("Algorithms");

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {
		basePage = Utils.setUpWebBrowser(browser);
	}

	@AfterTest
	public void testFailScreenshot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utils.captureScreenshot(basePage.driver, result.getName());
			log.info("Screenshot of failure of test " + result.getName() + " is taken!");
		}
	}

	@AfterClass
	public void tearDown() {
		if (logedInPage != null)
			logedInPage.quit();
	}
}
