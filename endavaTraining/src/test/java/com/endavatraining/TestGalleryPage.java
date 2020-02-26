package com.endavatraining;

import com.endavatraining.pages.GalleryPage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

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
    private By nextSlideArrow = By.className("next");
    private By previousSlideArrow = By.className("prev");
    private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
    private By closeSlides = By.xpath("//*[@id=\"myModal\"]/span");


    /*
     * Before Test suite message
     * @author ana.acanski
     *
     */
    
    @BeforeSuite
    public void setup() {
        System.out.println("Running TestGalleryPage Test.");
    }

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
            galleryPage.clickOnButton(arrayOfSlideXPaths[i]);
            Assert.assertEquals(arrayOfSlideCaptions[i], galleryPage.getCaptionOfTheSlide(captionOfTheSlide),
                    "Caption of the slide " + arrayOfSlideCaptions[i] + " does NOT exist.");
            log.info("Tested image caption existence in " + (i+1) + ". iteration.");
        }
        galleryPage.clickOnButton(closeSlides);
        galleryPage.waitForElementToBeClickable(logOutButton);
        galleryPage.clickLogOutButton();

    }

    /**
     * Test validates that User can go through the gallery using right/left slides, by logging in as user, clicking on
     * Gallery tab, clicking on first image and comparing the captions of images after clicking on right/left slides
     *
     *  @author Jovan.Penic
     */
    @Test
    public void testImagesUsingSlides() {
        loginPage.userLogin(USER_USERNAME, USER_PASSWORD);
        galleryPage = loginPage.openGalleryPage();
        galleryPage.clickOnButton(firstSlide);
        for (int i = 0; i < arrayOfSlideCaptions.length; i++) {
            Assert.assertEquals(arrayOfSlideCaptions[i], galleryPage.getCaptionOfTheSlide(captionOfTheSlide),
                    "Arrow Next Slide didn't work in: " + (i+1) + ". iteration.");
            galleryPage.clickOnButton(nextSlideArrow);
        }
        log.info("Tested that Next Slide arrow in gallery goes through the entire gallery");
        for (int i = 3; i >= 0; i--){
            galleryPage.clickOnButton(previousSlideArrow);
            Assert.assertEquals(arrayOfSlideCaptions[i], galleryPage.getCaptionOfTheSlide(captionOfTheSlide),
                    "Arrow Previous Slide didn't work in: " + (3-i+1) + ". iteration.");
        }
        log.info("Tested that Previous Slide arrow in gallery goes through the entire gallery.");
        galleryPage.clickOnButton(closeSlides);
        galleryPage.waitForElementToBeClickable(logOutButton);
        galleryPage.clickLogOutButton();
    }


    @AfterTest
    public void tearDown() {
        if (galleryPage != null)
        	galleryPage.quit();
    }
    
    
    /*
     * After Test suite message
     * @author ana.acanski
     *
     */
    @AfterSuite
    public void teardownS() {
        System.out.println("TestGalleryPage Test Suite is finished");
        driver.quit(); 
    }



}
