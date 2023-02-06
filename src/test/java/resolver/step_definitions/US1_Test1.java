package resolver.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import resolver.pages.TestPage;
import resolver.utilities.BrowserUtil;

public class US1_Test1 {


    TestPage testPage = new TestPage();
    @Given("user is on the Home Page")
    public void user_is_on_the_home_page() {
// this step is performed by setUp method under @Before annotation in hooks class
    }
    @Then("user should be able to see email, password input boxes and login button")
    public void user_should_be_able_to_see_email_password_input_boxes_and_login_button() {
        BrowserUtil.verifyElementDisplayed(testPage.emailInputBox);
        BrowserUtil.verifyElementDisplayed(testPage.passwordInputBox);
        BrowserUtil.verifyElementDisplayed(testPage.signInButton);
    }

    @Then("user should be able to click login button")
    public void user_should_be_able_to_click_login_button() {
     Assert.assertNotEquals(BrowserUtil.waitToBeClickable(testPage.signInButton, 10), null);
    }

    @When("user types {string}  into email box")
    public void user_types_into_email_box(String email) {
       testPage.emailInputBox.sendKeys(email);
    }
    @When("user types {string} into password box")
    public void user_types_into_password_box(String password) {
       testPage.passwordInputBox.sendKeys(password);
    }
    @Then("{string} and {string} should be present in respective fields")
    public void and_should_be_present_in_respective_fields(String expectedEmail, String expectedPassword) {
       String actualEmail = testPage.emailInputBox.getAttribute("value");
       String actualPassword = testPage.passwordInputBox.getAttribute("value");

       Assert.assertEquals(expectedEmail,actualEmail);
       Assert.assertEquals(expectedPassword,actualPassword);
    }


}
