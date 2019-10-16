package com.endavatraining.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.endavatraining.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {

	/**
     *
     * This method sets up browser options regarding the browser size and browser automated notion
     *
	 * @author Srboljub.Todorvic
	 * @author Jovan.Penic
	 * @return ChromeOptions
	 */

    public static Logger log = Logger.getLogger(Utils.class);

    public static ChromeOptions setUpBrowserOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    /**
     * @param browser
     * @return LoginPage
     */
    public static LoginPage setUpWebBrowser(String browser) {
        LoginPage loginPage;

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
            loginPage = new LoginPage(new ChromeDriver(setUpBrowserOptions()));
		} else {
			throw new RuntimeException();
		}
		return loginPage;
	}

    /**
     *
     * This method returns value of attributes of any text field
     *
     * @author Jovan.Penic
     * @param driver
     * @param anyTextField
     * @return
     */
    public static String getAttributeOfAnyTextField(WebDriver driver, By anyTextField){
        return driver.findElement(anyTextField).getAttribute("value");
    }


	/**
	 * @param driver
	 * @param locator
	 */
	public static void webDriverWait(WebDriver driver, By locator) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}