package resolver.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resolver.pages.TestPage;
import resolver.utilities.BrowserUtil;
import resolver.utilities.Driver;

public class US3_Test2 {

    TestPage testPage = new TestPage();

    @Then("user sees {int} values in list group")
    public void user_sees_values_in_list_group(Integer expectedNumberOfValues) {
        for (WebElement value : testPage.listOfValues) {
            BrowserUtil.verifyElementDisplayed(value);
        }
        Integer actualNumberOfValues = testPage.listOfValues.size();
        Assert.assertEquals(expectedNumberOfValues, actualNumberOfValues);


    }

    @Then("user sees item number {int} 's value as {string}")
    public void user_sees_item_number_s_value_as(Integer itemNumber, String expectedValue) {

        // since text of the web element contain both item's and badge values we have to use substring method to extract a necessary part
        String actualValue = testPage.getItem(itemNumber).getText().substring(0, expectedValue.length());

        Assert.assertEquals(expectedValue, actualValue);


    }


    @Then("user sees item number {int} 's badge value as {string}")
    public void user_sees_item_number_s_badge_value_as(Integer itemNumber, String expectedBadgeValue) {
        String actualBadgeValue = testPage.getItem(itemNumber).getText();
        actualBadgeValue = actualBadgeValue.substring(actualBadgeValue.length() - expectedBadgeValue.length());
        System.out.println("actualBadgeValue = " + actualBadgeValue);
        Assert.assertEquals(expectedBadgeValue, actualBadgeValue);

    }


}
