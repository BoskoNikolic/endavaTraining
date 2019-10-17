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
    private By firstPictureInGallery  = By.xpath("//img[@onclick='openModal();currentSlide(1)']");


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
    public void testAreImageCaptionsVisible() throws InterruptedException {
        log.info("Test are image captions different for every picture");
        loginPage.userLogin(usernameLogInValue, passwordLogInValue);
        galleryPage = loginPage.openGalleryPage();
        galleryPage.driver.findElement(firstPictureInGallery).click();
        Thread.sleep(2000);

//        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresentAfterSpecialCharacterEntryInRegistrationCodeField(randomRegistrationCodeWithSpecCharacters), "Username field IS present after special character entry in registration code field. ");
 //       Assert.assertTrue(registerNewAccountPage.isErrorMessagePresentAfterFalseEntryInRegistrationCodeField(), "Error message does NOT appear after special character entry in registration code field. ");
    }


    @AfterTest
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
        if (galleryPage != null)
            galleryPage.quit();
    }




}
