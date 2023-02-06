package resolver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resolver.utilities.Driver;

import java.util.List;

public class TestPage {

    public TestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "inputEmail")
    public WebElement emailInputBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(css = "li[class='list-group-item justify-content-between']")
    public List<WebElement> listOfValues;

    @FindBy(id = "dropdownMenuButton")
    public WebElement currentDropdownOption;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> allDropdownOptions;

    @FindBy(css = "div#test-4-div>button[class='btn btn-lg btn-primary']")
    public WebElement firstButtonTest4;

    @FindBy(css = "div#test-4-div>button[class='btn btn-lg btn-secondary']")
    public WebElement secondButtonTest4;

    @FindBy(id = "test5-button")
    public WebElement buttonTest5;

    @FindBy(id = "test5-alert")
    public WebElement successMessage;


    /**
     * method to choose drop down option based on data input
     */
    public void chooseDropdownOption(String option){
        currentDropdownOption.click();
        for (WebElement singleOption : allDropdownOptions) {
            if(singleOption.getAttribute("innerHTML").equals(option)){
                singleOption.click();
            }
        }

    }

    /**
     * returns item from list
     */
    public WebElement getItem(Integer itemNumber) {
        return Driver.getDriver().findElement(By.xpath("(//li[@class='list-group-item justify-content-between'])[" + itemNumber + "]"));
    }



    public void signIn(String email, String password) {
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }

    /**
     * method to return value of table cell based on coordinates
     */

    public String getTableCell(int row, int column){
        WebElement table = Driver.getDriver().findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table"));

        WebElement tableRow = table.findElements(By.tagName("tr")).get(row + 1);

        WebElement tableCell = tableRow.findElements(By.tagName("td")).get(column);

        return tableCell.getText();
    }
}
