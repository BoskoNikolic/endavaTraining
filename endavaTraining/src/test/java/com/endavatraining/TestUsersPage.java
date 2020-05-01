package com.endavatraining;


import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.UsersPage;
import com.endavatraining.util.Utils;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

public class TestUsersPage extends BaseTest {

	private LoginPage loginPage;
	private HomePage homePage;
	private UsersPage usersPage;
	private static final String DISPLAY_NAME = "Admin Admin";
	private static final String ABOUT_MESSAGE = "About Me Text";
	private static final String CREATION_TIME = "17.12.2018. 11:55";
	public static Logger log = Logger.getLogger(TestLoginPage.class);
	
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}

	/**
	 * The test logs in as a user, finds Admin from the Users list, opens his
	 * details, verifies that the details are open, checks if the first name and
	 * last name from the Users table are the same as the ones from the details.
	 * Also check the About me message, and Creation time, then clicks the details
	 * close button, and logs out.
	 *
	 */
	@Test(priority = 0)
	public void testUserDetails() {

		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
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
		usersPage.waitInvisibilityOfElement(UsersPage.userDetails);
		usersPage.clickLogOutButton();
		log.info("Tested if Users info is the same in the Users list and the Details page");
	}

	/**
	 * Test validates that hero count is correct, by logging in as user, going to
	 * users page and checking if the hero count of admins in Users table is the
	 * same as in the User Heroes pop up window.
	 *
	 * @author Jovan.Penic
	 */
	@Test(priority = 1)
	public void testHeroCount() {
		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		homePage.findUsersPage().click();
		usersPage = new UsersPage(homePage.driver);
		Assert.assertEquals(usersPage.getNumberOfAdminHeroesInUsersList(),
				usersPage.numberOfAdminHeroesInUserHeroesPopUp(),
				"Hero count of admins in Users table is NOT the same as in the User Heroes pop up window");
		usersPage.waitForElementToBeClickable(UsersPage.closeUserHeroesPopUpWindow);
		usersPage.closeUserHeroesWindow();
		usersPage.waitInvisibilityOfElement(UsersPage.userHeroesWindowBody);
		usersPage.clickLogOutButton();
		log.info("Tested if the hero count of admins in Users table is the same as in the User Heroes pop up window.");
	}
	
	@Test
	public void testUserHasNotAccessToAdminPage() {
		HomePage homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		homePage.findUsersPage().click();
		usersPage.openAdminPage();
		log.info("User does not have access to admin section");

	}
	
	@Test(priority = 1, dataProvider = "DataProvider")
	public void testAdminAddingNewUser(String userName, String firstName, String lastName, String about, String secretQuestion, String secretAnswer, String password, String confirmPassword) {

		homePage = loginPage.openAs(ADMIN_USERNAME, ADMIN_PASSWORD);
		homePage.findUsersPage().click();

		// check if user already exists in table and delete him, and it will be possible to enter him again
		usersPage.deleteUserifExists(userName);
		
		usersPage.openAddNewUserWindow();
		usersPage.insertUserName(userName);
		usersPage.insertUserFirstName(firstName);
		usersPage.insertUserLastName(lastName);
		usersPage.insertUserAbout(about);
		usersPage.insertUserSecretQuestion(secretQuestion);
		usersPage.insertUserSecretAnswer(secretAnswer);
		usersPage.insertUserPassword(password);
		usersPage.insertUserConfirmPassword(confirmPassword);

		usersPage.saveNewUser();

		Assert.assertTrue(usersPage.isUserInTable(userName), "User with this username is not added!");
		log.info("Verifies that new user is added (shown on table).");

		usersPage.clickLogOutButton();
	}
	
	@Test(priority = 1, dataProvider = "DataProvider")
	public void deleteAddedUsers(String userName, String firstName, String lastName, String about, String secretQuestion, String secretAnswer, String password, String confirmPassword) {

		homePage = loginPage.openAs(ADMIN_USERNAME, ADMIN_PASSWORD);
		homePage.findUsersPage().click();

		usersPage.deleteUserInTable(userName);
		log.info(
				"Erasing inserted values so the previous test could be performed multiple times with same set of data");

		usersPage.clickLogOutButton();
	}
	
	
	@Test(priority = 1, dataProvider = "DataProvider")
	public void testAdminEditingNewUser(String userName, String firstName, String lastName, String about, String secretQuestion, String secretAnswer, String password, String confirmPassword) {

		homePage = loginPage.openAs(ADMIN_USERNAME, ADMIN_PASSWORD);
		homePage.findUsersPage().click();
		
		usersPage.openAddNewUserWindow();
		usersPage.insertUserName(userName);
		usersPage.insertUserFirstName(firstName);
		usersPage.insertUserLastName(lastName);
		usersPage.insertUserAbout(about);

		usersPage.saveNewUser();

		Assert.assertTrue(usersPage.isUserInTable(userName), "User with this username is not added!");
		log.info("Verifies that new user is added (shown on table).");

		usersPage.clickLogOutButton();
	}

	@DataProvider(name = "DataProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "admin", "Admin", "Admin", "About Me Text", "test", "test", "test12345", "test12345" } };

	}

	@AfterClass
	public void tearDown() {
		if (usersPage != null)
			usersPage.quit();
	}
}
