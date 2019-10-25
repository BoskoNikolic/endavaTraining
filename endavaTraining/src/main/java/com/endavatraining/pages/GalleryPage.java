package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GalleryPage extends BasePage {

    private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");

    public GalleryPage(WebDriver driver) {
        super(driver);
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

    /**
     * This method locates the Log Out button and clicks on it
     *
     * @author: Jovan.Penic
     * */
    public void clickLogOutButton() {
        clickOnButton(logOutButton);
    }


}
