package resolver.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import resolver.pages.TestPage;

public class US5_Test4 {

    TestPage testPage = new TestPage();

    @Then("user is able to access first button")
    public void user_is_able_to_access_first_button() {
        Assert.assertTrue(testPage.firstButtonTest4.isEnabled());
    }

    @Then("user is not able to access second button")
    public void user_is_not_able_to_access_second_button() {
       Assert.assertFalse(testPage.secondButtonTest4.isEnabled());
    }

}
