package resolver.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {

    public static void verifyElementDisplayed(WebElement webElement) {
        try {
            Assert.assertTrue("Element not visible", webElement.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found");

        }
    }

    public static WebElement waitToBeClickable(WebElement element, int timeout) {
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(Driver.getDriver(),timeout).until(ExpectedConditions.elementToBeClickable(element));

            System.out.println("Element is clickable");
        } catch (TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
       return webElement;
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
