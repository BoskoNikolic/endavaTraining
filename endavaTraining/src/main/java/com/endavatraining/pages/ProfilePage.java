package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private By profileButton = By.linkText("Profile");
    private By profilePageTitle = By.xpath("/html/body/div[1]/div/div/div[1]/div");
    private WebDriverWait wait = new WebDriverWait(driver, 3);

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void openProfilePage() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        clickOnButton(profileButton);
    }

    public boolean isProfileButtonDisplayed() {
        return isElementPresent(profileButton);
    }

    public boolean isPageTitleDisplayed() {
        return isElementPresent(profilePageTitle);
    }
}
