package com.endavatraining;

import com.endavatraining.pages.GalleryPage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestGalleryPage {

    private GalleryPage galleryPage;
    private LoginPage loginPage;
    private static String usernameLogInValue = "user";
    private static String passwordLogInValue = "password";
    public static Logger log = Logger.getLogger(TestGalleryPage.class);

    private By [] nizXPathSlajdovaUGaleriji = {By.xpath("//img[@onclick='currentSlide(1)']"), By.xpath("//img[@onclick='currentSlide(2)']"), By.xpath("//img[@onclick='currentSlide(3)']"), By.xpath("//img[@onclick='currentSlide(4)']")};

    private By pictureInGallery = By.xpath("//img[@onclick='openModal();currentSlide(1)']");
    private By firstSlide = By.xpath("//img[@onclick='currentSlide(1)']");
    private By secondSlide = By.xpath("//img[@onclick='currentSlide(2)']");
    private By thirdSlide = By.xpath("//img[@onclick='currentSlide(3)']");
    private By fourthSlide = By.xpath("//img[@onclick='currentSlide(4)']");

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     *
     * Test validates that username field is NOT visible after entering special characters in Registration Code text field.!!!!!!!!!!!!!!!
     * Then test validates if registration code error IS visible.!!!!!!!!!!!!!!!!!!!!!!!!
     *
     *  @author Jovan.Penic
     */

    @Test
    public void testAreImageCaptionsVisible() {
        log.info("Test are image captions different for every picture");
        loginPage.userLogin(usernameLogInValue, passwordLogInValue);
        galleryPage = loginPage.openGalleryPage();

//        Assert.assertNotEquals(GalleryPage.getAttributeOfAnyTextField(galleryPage.driver, firstSlide, "alt"), galleryPage.driver.findElement(firstSlide).getAttribute("alt"), "Captions of slide 1 and slide 2 ARE the same.");
        for (int i = 0; i < nizXPathSlajdovaUGaleriji.length; i++) {
            for (int j = i + 1; j < nizXPathSlajdovaUGaleriji.length; j++) {
            Assert.assertNotEquals(GalleryPage.getAttributeOfAnyTextField(galleryPage.driver, nizXPathSlajdovaUGaleriji[i], "alt"), GalleryPage.getAttributeOfAnyTextField(galleryPage.driver, nizXPathSlajdovaUGaleriji[j], "alt"), "Captions of slide " + i + " and slide " + j + " ARE the same.");
            }
        }

//        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresentAfterSpecialCharacterEntryInRegistrationCodeField(randomRegistrationCodeWithSpecCharacters), "Username field IS present after special character entry in registration code field. ");
 //       Assert.assertTrue(registerNewAccountPage.isErrorMessagePresentAfterFalseEntryInRegistrationCodeField(), "Error message does NOT appear after special character entry in registration code field. ");
    }


    @AfterTest
    public void tearDown() {
        if (galleryPage != null)
            galleryPage.quit();
    }




}
