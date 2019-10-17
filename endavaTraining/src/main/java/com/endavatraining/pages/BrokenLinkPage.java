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
    private By mainTitle = By.xpath("//div[@class='panel-title text-center'][contains(.,'Alice in Wonderland')]");

    private List<By> buttons = new ArrayList();

    /*
     *
     * This method returns the list of elements of a page
     * @author Srboljub.Todorovic
     * @return
     *
     */
    public List<By> listOfElements() {
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

        return buttons;
    }

    public BrokenLinkPage(WebDriver driver) {
        super(driver);
    }

    /*
     *
     * This method is used to check if an element is visible on Broken link page
     * @author Srboljub.Todorovic
     *@param
     * @return
     *
     */
    public boolean isElementNotPresentOnPage(By element) {
        boolean elementIsNotPresent = true;
        if (isElementPresent(element)) {
            elementIsNotPresent = false;
        }
        return elementIsNotPresent;
    }

    public boolean isMainTitlePresent() {
        return isElementPresent(mainTitle);
    }


}
