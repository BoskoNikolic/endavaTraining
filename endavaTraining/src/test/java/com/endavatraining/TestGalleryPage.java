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
    public static Logger log = Logger.getLogger(TestGalleryPage.class);
    private By captionOfTheSlide = By.xpath("//p[@id='caption']");
    private By firstSlide = By.xpath("//img[@onclick='openModal();currentSlide(1)']");
    private By secondSlide = By.xpath("//img[@onclick='currentSlide(2)']");
    private By thirdSlide = By.xpath("//img[@onclick='currentSlide(3)']");
    private By fourthSlide = By.xpath("//img[@onclick='currentSlide(4)']");
    private By [] arrayOfSlideXPaths = {firstSlide, secondSlide, thirdSlide,fourthSlide};
    private String [] arrayOfCaptions = new String[4];

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     *
     * Test validates that Captions of pictures in Gallery are different from one another
     * by logging in as user, clicking on Gallery tab, clicking on each image and comparing the captions of images
     *
     *  @author Jovan.Penic
     */
    @Test
    public void testAreImageCaptionsDifferent() {
        log.info("Testing are image captions different for every picture");
        loginPage.userLogin(LoginPage.USERNAME_LOGIN_VALUE, LoginPage.PASSWORD_LOGIN_VALUE);
        galleryPage = loginPage.openGalleryPage();
        for (int i = 0; i < arrayOfSlideXPaths.length; i++){
            galleryPage.driver.findElement(arrayOfSlideXPaths[i]).click();
            arrayOfCaptions[i] = galleryPage.driver.findElement(captionOfTheSlide).getText();
        }
        for (int i = 0; i < arrayOfCaptions.length; i++) {
            for (int j = i + 1; j < arrayOfCaptions.length; j++) {
                Assert.assertNotEquals(arrayOfCaptions[i], arrayOfCaptions[j], "Captions of slide " + (i+1) + " and slide " + (j+1) + " ARE the same.");
            }
        }
    }

    @AfterTest
    public void tearDown() {
        if (galleryPage != null)
            galleryPage.quit();
    }




}
