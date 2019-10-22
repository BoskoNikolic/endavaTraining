package com.endavatraining.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class UsersPage extends BasePage {


    private By userDetails = By.id("userModal");
    private By getUserDetails = By.xpath("/html/body/div[1]/div/div/div[3]/div");
    private By userDetailsFirstname = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/p/span[4]");
    private By userDetailsLastname = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/p/span[6]");
    private By userDetailsAbout = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/span[2]");
    private By getUserDetailsCreationTime = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/p/span[8]");
    private By closeUserDetailsButton = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[3]/button");
    private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");


    public UsersPage(WebDriver driver) {
        super(driver);
    }

    /**
     *Method check if User Details displayed
     *
     * @author: luka.ivancic
     * @return: true if displayed / false if not displayed
     *
     * */
    public boolean isUserDetailsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userDetails));
        String style = driver.findElement(this.userDetails).getAttribute("style");
        if (style.contains("display: block")) {

            return true;
        }
        if (style.contains("misplay: none;")) {

            return false;
        }

        return false;


    }

    /**
     *Method finds the index of the User in the Users table
     *
     * @author: luka.ivancic
     * @param: displayName
     * @return: i
     *
     * */
    public int findUserIndexByDisplayName(String displayName) {

        int userCount;
        List<WebElement> users = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr"));
        userCount = users.size();
        String name;
        for (int i = 0; i < userCount; i++) {
            name = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + (i + 1) +
                    "]/td[2]")).getText();
            if (name.equals(displayName)) {
                return i + 1;
            }
        }

        return 0;
    }
    
    /**
     *Method locates the Details button of a located user and clicks on it
     *
     * @author: luka.ivancic
     * @param: index
     *
     *
     * */
    public void clickUserDetails(int index) {

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + index +
                "]/td[4]/a")).click();

    }

    /**
     * Method gets the firs name of a user from the Users table
     * @author: luka.ivancic
     * @param: index
     * @return firstName
     *
     * */
    public String getFirstNameFromUserList(int index) {
        String fullName;

        fullName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + index +
                "]/td[2]")).getText();
        String[] stringArray = fullName.split(" ");
        String firstName = stringArray[0];
        return firstName;

    }

    /**
     * Method gets the last name of a user from the Users table
     * @author: luka.ivancic
     * @param: index
     * @return lastName
     *
     * */
    public String getLastNameFromUserList(int index) {
        String fullName;
        fullName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + index +
                "]/td[2]")).getText();
        String[] stringArray = fullName.split(" ");
        String lastName = stringArray[1];
        return lastName;

    }

    /**
     * Method gets the first name of a user from the Details page
     * @author: luka.ivancic
     * @return userDetailsFirstName
     *
     * */
    public String getFirstNameFromDetailsPage() {
        String userDetailsFirstName = driver.findElement(userDetailsFirstname).getText();
        return userDetailsFirstName;
    }

    /**
     * Method gets the last name of a user from the Details page
     * @author: luka.ivancic
     * @return userDetailsLastName
     *
     * */
    public String getLastNameFromDetailsPage() {
        String userDetailsLastName = driver.findElement(userDetailsLastname).getText();
        return userDetailsLastName;
    }

    /**
     * Method gets the About message of a user from the Details page
     * @author: luka.ivancic
     * @return aboutMessage
     *
     * */
    public String getAboutMessageFromDetailsPage() {
        String aboutMessage = driver.findElement(userDetailsAbout).getText();
        return aboutMessage;
    }

    /**
     * Method gets the Creation time of a user from the Details page
     * @author: luka.ivancic
     * @return creationTime
     *
     * */
    public String getCreationTimeFromDetailsPage() {
        String creationTime = driver.findElement(getUserDetailsCreationTime).getText();
        return creationTime;
    }

    /**
     * Method locates the Close button of a Details page, and clicks on it
     * @author: luka.ivancic
     *
     *
     * */
    public void clickUserDetailsCloseButton() {
        driver.findElement(closeUserDetailsButton).click();
    }

    /**
     * Method locates the Log Out button and clicks on it
     * @author: luka.ivancic
     *
     *
     * */
    public void clickUsersLogOutButton(WebDriver driver) {

        isElementPresent(logOutButton);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(userDetails));
        driver.findElement(logOutButton).click();

    }


}





