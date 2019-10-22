package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    private By allowUsersToShareRegCodeCheckBox = By.id("usersAllowed");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckBoxSelected() {
        return driver.findElement(allowUsersToShareRegCodeCheckBox).isSelected();
    }

    public void clickOnAllowUsersToShareRegCode() {
        driver.findElement(allowUsersToShareRegCodeCheckBox).click();
    }
}
