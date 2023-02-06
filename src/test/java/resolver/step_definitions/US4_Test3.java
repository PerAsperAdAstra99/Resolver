package resolver.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import resolver.pages.TestPage;

public class US4_Test3 {

    TestPage testPage = new TestPage();


    @Then("user sees {string} as default selected option")
    public void user_sees_as_default_selected_option(String expectedDefaultOptionValue) {
     String actualDefaultOptionValue = testPage.currentDropdownOption.getText();

        Assert.assertEquals(expectedDefaultOptionValue, actualDefaultOptionValue);
    }

    @When("user selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String option) {

        testPage.chooseDropdownOption(option);
    }
    @Then("user sees {string} as selected option")
    public void user_sees_as_selected_option(String expectedSelectedOptionValue) {
        String actualSelectedOptionValue = testPage.currentDropdownOption.getText();
        Assert.assertEquals(expectedSelectedOptionValue,actualSelectedOptionValue);



    }

}
