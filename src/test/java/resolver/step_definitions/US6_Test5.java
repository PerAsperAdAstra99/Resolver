package resolver.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import resolver.pages.TestPage;
import resolver.utilities.BrowserUtil;

public class US6_Test5 {

    TestPage testPage = new TestPage();



    @When("user waits for the button to be displayed and clicks it")
    public void user_waits_for_the_button_to_be_displayed_and_clicks_it() {
        BrowserUtil.waitToBeClickable(testPage.buttonTest5, 10).click();
    }
    @Then("user sees success message displayed")
    public void user_sees_success_message_displayed() {
       BrowserUtil.verifyElementDisplayed(testPage.successMessage);
    }
    @Then("user is not able to access button")
    public void user_is_not_able_to_access_button() {
      Assert.assertFalse(testPage.buttonTest5.isEnabled());
    }

    @Then("user sees that message content is {string}")
    public void userSeesThatMessageContentIs(String expectedMessageContent) {
        String actualMessageContent = testPage.successMessage.getAttribute("innerHTML").trim();
        System.out.println(actualMessageContent);
        Assert.assertEquals(expectedMessageContent,actualMessageContent);
    }
}
