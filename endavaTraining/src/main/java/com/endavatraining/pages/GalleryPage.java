package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GalleryPage extends BasePage {

    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on image in Gallery Tab
     *
     * @author Jovan.Penic
     * @param slideXPath
     */
    public void clickOnImage(By slideXPath) {
        driver.findElement(slideXPath).click();
    }

    /**
     * This method gets caption of the slide in Gallery tab
     *
     * @author Jovan.Penic
     * @param slideCaptionXPath
     * @return
     */
    public String getCaptionOfTheSlide (By slideCaptionXPath) {
        return driver.findElement(slideCaptionXPath).getText();
    }
}
