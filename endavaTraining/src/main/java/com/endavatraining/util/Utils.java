package com.endavatraining.util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endavatraining.pages.AlgorithmsPage;
import com.endavatraining.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static Logger log = Logger.getLogger(Utils.class);

	/**
	 *
	 * This method will take screenshot and save it in FailedTestScreenShots folder
	 *
	 * @author Jovan.Penic
	 * @param webdriver
	 * @param screenshotName
	 */
	public static void captureScreenshot(WebDriver webdriver, String screenshotName) {
		try {
			log.debug("Taking screenshot of failed test.");
			TakesScreenshot screenShot = ((TakesScreenshot) webdriver);
			String screenshotTime = new SimpleDateFormat("ddMMyyyyhhmmss.SS").format(new Date());
			File imageFile = screenShot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(System.getProperty("user.dir") + "\\FailedTestScreenShots\\"
					+ screenshotName + screenshotTime + ".png");
			FileUtils.copyFile(imageFile, destinationFile);
		} catch (IOException ioException) {
			log.error("Error happened while trying to execute captureScreenshot method!");
		}
	}

	/**
	 *
	 * This method sets up browser options regarding the browser size and browser
	 * automated notion
	 *
	 * @author Srboljub.Todorvic
	 * @author Jovan.Penic
	 * @return ChromeOptions
	 */
	public static ChromeOptions setUpBrowserOptions() {
		log.debug("Setting up browser options");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		return options;
	}

	/**
	 * @author Luka.Ivancic
	 * @param browser
	 * @return loginPage
	 */
	public static LoginPage setUpWebBrowser(String browser) {
		LoginPage loginPage;
		log.debug("Choose web browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			loginPage = new LoginPage(new ChromeDriver(setUpBrowserOptions()));
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			loginPage = new LoginPage(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			loginPage = new LoginPage(new EdgeDriver());
		} else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			loginPage = new LoginPage(new OperaDriver());
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			loginPage = new LoginPage(new InternetExplorerDriver());
		}

		else {
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
	 * @param locator
	 */
	public static void webDriverWait(WebDriver driver, By locator) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}