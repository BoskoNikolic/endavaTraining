package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UsersPage extends BasePage {

    private By search = By.id("search");
    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public static Logger log = Logger.getLogger(LoginPage.class);
    private By usersButton = By.linkText("Users");
    private By dropDownOnUsersPage = By.id("pageSizeSelect");
    private By searchIcon = By.cssSelector("button[class='btn btn-info btn-sm']");
    private By heroCountField = By.xpath("//*[@id=\"users-table\"]/tbody/tr[1]/td[3]");






    /**
     * This method clicks on search icon on Users page
     * @author Danko.Lojanica
     */
    public void clickOnSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    /**
     * This method select value from drop down on Users page, depending on passed index
     * @param index
     * @author Danko.Lojanica
     */
    public void selectValueFromDropDownOnUsersPage( int index){
        Select dropdown = new Select(driver.findElement(dropDownOnUsersPage));
        dropdown.selectByIndex(index);
    }

    /**
     * This method enters passed string on search field
     * @author Danko.Lojanica
     */
    public void searchUser(String searchParameter){
        driver.findElement(search).sendKeys(searchParameter);
    }

    /**
     * This method returns hero count for admin user on Users page
     * @return heroCount
     * @author Danko.Lojanica
     */
    public int heroCountForAdminUserOnUserPage(){
               int heroCount;
              return heroCount = Integer.parseInt(driver.findElement(heroCountField).getText());
    }
}
