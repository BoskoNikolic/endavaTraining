package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrokenLinkPage extends BasePage {


    private By homeButton = By.linkText("Home");
    private By usersButton = By.linkText("Users");
    private By heroesButton = By.linkText("Heroes");
    private By galleryButton = By.linkText("Gallery");
    private By apiButton = By.linkText("API");
    private By brokenLinkButton = By.linkText("Broken Link");
    private By adminButton = By.linkText("Admin");
    private By profileButton = By.linkText("Profile");
    private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
    private By logInButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li/a");
    private By mainTitle = By.xpath("/html/body/div[1]/div/div/div[1]/div");

    private List<By> buttons = new ArrayList();

    public BrokenLinkPage(WebDriver driver) {
        super(driver);
    }

    /*
     *
     * This method is used to check if a list of the navigation bar tabs are visible on Broken link page
     * @author Srboljub.Todorovic
     *
     */
    public boolean isElementNotPresentOnPage() {
        boolean elementIsNotPresent = true;

        buttons.add(homeButton);
        buttons.add(usersButton);
        buttons.add(usersButton);
        buttons.add(heroesButton);
        buttons.add(galleryButton);
        buttons.add(apiButton);
        buttons.add(brokenLinkButton);
        buttons.add(adminButton);
        buttons.add(profileButton);
        buttons.add(logOutButton);
        buttons.add(logInButton);

        for (By button : buttons) {
            if (!isElementPresent(button)) {
                elementIsNotPresent = true;
            } else {
                elementIsNotPresent = false;
                break;
            }
        }
        return elementIsNotPresent;
    }

    public boolean isMainTitlePresent() {
        return isElementPresent(mainTitle);
    }


}
