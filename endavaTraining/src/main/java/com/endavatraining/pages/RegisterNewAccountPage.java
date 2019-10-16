package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterNewAccountPage extends BasePage {

    private By userNameField = By.xpath("//div[@id='registeruserinfo' and contains(@style,'display: block')]/div[1]");
    private By registrationCodeField = By.id("registrationCode");
    private By registrationCodeErrorMessage = By.xpath("//div[@id='regiCodeMessage'][contains(.,\"Bla bla incorect registration code format!\")]");


    public RegisterNewAccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * This method enters text in Registration Code text field and checks is mentioned element visible
     *
     * @author Jovan.Penic
     * @param enterRandomRegistrationCode
     * @return boolean
     */
    public boolean isUserNameFieldPresentAfterSpecialCharacterEntryInRegistrationCodeField(String enterRandomRegistrationCode) {
        driver.findElement(registrationCodeField).sendKeys(enterRandomRegistrationCode);
        return isElementPresent(userNameField);
    }

    /**
     *
     * This method checks if registration code error is visible
     *
     * @author Jovan.Penic
     * @return boolean
     */
    public boolean isErrorMessagePresentAfterFalseEntryInRegistrationCodeField() {
        return isElementPresent(registrationCodeErrorMessage);
    }


}
