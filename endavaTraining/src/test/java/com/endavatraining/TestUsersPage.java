package com.endavatraining;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.UsersPage;
import com.endavatraining.util.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class TestUsersPage {

    private LoginPage loginPage;
    private HomePage homePage;
    private UsersPage usersPage;
    private static final String DISPLAY_NAME = "Admin Admin";
    private static final String ABOUT_MESSAGE = "About Me Text";
    private static final String CREATION_TIME = "17.12.2018. 11:55";

    public static Logger log = Logger.getLogger(TestLoginPage.class);


    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     * The test logs in as a user, finds Admin from the Users list, opens his details, verifies that the details are open,
     * checks if the first name and last name from the Users table are the same as the ones from the details.
     * Also check the About me message, and Creation time, then clicks the details close button, and logs out.
     *
     * */
    @Test
    public void testUserDetails(){

        homePage = loginPage.openAs(USER_NAME, PASSWORD);
        homePage.findUsersPage().click();
        usersPage = new UsersPage(homePage.driver);
        usersPage.clickUserDetails(usersPage.findUserIndexByDisplayName(DISPLAY_NAME));
        Assert.assertTrue(usersPage.isUserDetailsVisible(), "User Details doesn't appear.");
        Assert.assertEquals(usersPage.getFirstNameFromUserList(usersPage.findUserIndexByDisplayName(DISPLAY_NAME)),
                usersPage.getFirstNameFromDetailsPage());
        Assert.assertEquals(usersPage.getLastNameFromUserList(usersPage.findUserIndexByDisplayName(DISPLAY_NAME)),
                usersPage.getLastNameFromDetailsPage());
        Assert.assertEquals(ABOUT_MESSAGE, usersPage.getAboutMessageFromDetailsPage());
        Assert.assertEquals(CREATION_TIME, usersPage.getCreationTimeFromDetailsPage());
        usersPage.clickUserDetailsCloseButton();
        usersPage.clickUsersLogOutButton(usersPage.driver);
        log.info("Tested if Users info is the same in the Users list and the Details page");


    }

    @AfterTest
    public void tearDown() {
        if (usersPage != null)
            usersPage.quit();
    }




}
