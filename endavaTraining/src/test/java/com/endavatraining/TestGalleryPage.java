package com.endavatraining;

import com.endavatraining.pages.GalleryPage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGalleryPage extends TestBase {

    private GalleryPage galleryPage;
    private LoginPage loginPage;
    public static Logger log = Logger.getLogger(TestGalleryPage.class);
    private By captionOfTheSlide = By.xpath("//p[@id='caption']");
    private By firstSlide = By.xpath("//img[@onclick='openModal();currentSlide(1)']");
    private By secondSlide = By.xpath("//img[@onclick='currentSlide(2)']");
    private By thirdSlide = By.xpath("//img[@onclick='currentSlide(3)']");
    private By fourthSlide = By.xpath("//img[@onclick='currentSlide(4)']");
    private By [] arrayOfSlideXPaths = {firstSlide, secondSlide, thirdSlide, fourthSlide};
    private String [] arrayOfSlideCaptions = {"Nature and sunrise", "Snow", "Mountains and fjords", "Northern Lights"};

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     * Test validates that captions of images in Gallery tab exist
     * by logging in as user, clicking on Gallery tab, clicking on each image and comparing the captions of images
     *
     *  @author Jovan.Penic
     */

    @Test
    public void testAreImageCaptionsDifferent() {
        loginPage.userLogin(USER_USERNAME, USER_PASSWORD);
        galleryPage = loginPage.openGalleryPage();
        for (int i = 0; i < arrayOfSlideCaptions.length; i++){
            galleryPage.clickOnImage(arrayOfSlideXPaths[i]);
            Assert.assertEquals(arrayOfSlideCaptions[i], galleryPage.getCaptionOfTheSlide(captionOfTheSlide), "Caption of the slide " + arrayOfSlideCaptions[i] + " does NOT exist.");
            log.info("Tested image caption existence in " + (i+1) + ". iteration.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (galleryPage != null)
            galleryPage.quit();
    }



}
