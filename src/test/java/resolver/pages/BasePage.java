package resolver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    /**
     * Common elements that are present on both pages(howewer, since we have 2 separate html files this is for demonstration purpose only)
     */

    @FindBy(xpath = "//li[@class='nav-item active']/a")
    public WebElement hopeModule;

    @FindBy(linkText = "Guide")
    public WebElement guideModule;
}
