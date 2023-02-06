package resolver.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import resolver.pages.TestPage;

public class US7_Test6 {

    TestPage testPage = new TestPage();

    @Then("user sees value of the table cell with coordinates {int}, {int} as {string}")
    public void user_sees_value_of_the_test_table_cell_with_with_coordinates_as(Integer row, Integer column, String expectedValue) {
     String actualValue = testPage.getTableCell(row,column);
        Assert.assertEquals(expectedValue,actualValue);
    }
}
