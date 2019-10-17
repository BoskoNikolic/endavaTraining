package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterNewAccountPage extends BasePage {

    private By userNameField = By.xpath("//div[@id='registeruserinfo' and contains(@style,'display: block')]/div[1]");
    private By registrationCodeField = By.id("registrationCode");
    private By registrationCodeErrorMessage = By.xpath("//div[@id='regiCodeMessage'][contains(.,\"Bla bla incorect registration code format!\")]");
    public static Logger log = Logger.getLogger(RegisterNewAccountPage.class);

    public RegisterNewAccountPage(WebDriver driver) {
        super(driver);
    }


    /**
     *
     * This method enters registration code in Registration Code text field
     *
     * @author Jovan.Penic
     * @param registrationCode
     * @return boolean
     */
    public void enterRegistrationCode(String registrationCode) {
        log.debug("Inserting registration code");
        driver.findElement(registrationCodeField).sendKeys(registrationCode);
    }


    /**
     *
     * This method enters text in Registration Code text field and checks is mentioned element visible
     *
     * @author Jovan.Penic
     * @param randomRegistrationCode
     * @return boolean
     */
    public boolean isUserNameFieldPresent(String randomRegistrationCode) {
        enterRegistrationCode(randomRegistrationCode);
        return isElementPresent(userNameField);
    }

    /**
     *
     * This method checks if registration code error is visible
     *
     * @author Jovan.Penic
     * @return boolean
     */
    public boolean isRegistrationCodeErrorMessagePresent() {
        return isElementPresent(registrationCodeErrorMessage);
    }


}
