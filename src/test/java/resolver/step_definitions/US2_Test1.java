package resolver.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import resolver.pages.TestPage;

public class US2_Test1 {

    TestPage testPage = new TestPage();

    public static String actualWarningMessageForPassword;

    public static String actualWarningMessageForEmail;

    @When("user types password {string} into password box")
    public void user_types_password_into_password_box(String password) {
        testPage.passwordInputBox.sendKeys(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        testPage.signInButton.click();
    }

    @Then("warning message for email box should not be blank")
    public void warning_message_for_email_box_should_not_be_blank() {
        actualWarningMessageForEmail = testPage.emailInputBox.getAttribute("validationMessage");

        Assert.assertFalse(actualWarningMessageForEmail.isBlank());

    }


    @When("user types {string} into email box")
    public void user_types_into_email_box(String email) {
        testPage.emailInputBox.sendKeys(email);
    }

    @Then("warning message for password box should not be blank")
    public void warning_message_for_password_box_should_not_be_blank() {
        actualWarningMessageForPassword = testPage.passwordInputBox.getAttribute("validationMessage");
        Assert.assertFalse(actualWarningMessageForPassword.isBlank());
    }

    @Then("warning message for email should contain {string}")
    public void warning_message_for_email_should_contain(String expectedWarningMessageForEmail) {
        actualWarningMessageForEmail = testPage.emailInputBox.getAttribute("validationMessage");
        Assert.assertTrue(actualWarningMessageForEmail.contains(expectedWarningMessageForEmail));
    }




}
