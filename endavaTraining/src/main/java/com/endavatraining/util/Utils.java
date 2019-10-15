package com.endavatraining.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
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
    public static ChromeOptions setUpBrowserOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    /**
     * @author Luka.Ivancic
     * @param browser
     * @return loginPage
     */
    public static LoginPage setUpWebBrowser(String browser) {

        LoginPage loginPage;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            loginPage = new LoginPage(new ChromeDriver());
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            loginPage = new LoginPage(new FirefoxDriver());
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            loginPage = new LoginPage(new EdgeDriver());
        }else if (browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            loginPage = new LoginPage(new OperaDriver());
        }else if (browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            loginPage = new LoginPage(new InternetExplorerDriver());
        }

        else {
            throw new RuntimeException();
        }
        return loginPage;
    }

    /**
     * @param driver
     * @param locator
     */
    public static void webDriverWait(WebDriver driver, By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }









}