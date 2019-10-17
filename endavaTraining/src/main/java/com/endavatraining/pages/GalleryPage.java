package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GalleryPage extends BasePage {

    private LoginPage loginPage;
    public static Logger log = Logger.getLogger(GalleryPage.class);
//    private static String usernameLogInValue = "user";
//    private static String passwordLogInValue = "password";

    public GalleryPage(WebDriver driver) {
        super(driver);
    }

//    /**
//     *
//     * This method logs in user, clicks and opens Gallery Page
//     *
//     * @author Jovan.Penic
//     * @return GalleryPage
//     */
//    public GalleryPage openGalleryPage() {
//        loginPage.open();
//        loginPage.insertTextInUsernameAndPasswordLogInTextFields(usernameLogInValue, passwordLogInValue);
//        return new GalleryPage(driver);
//    }






}
