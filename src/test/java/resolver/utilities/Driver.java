package resolver.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *  Singleton Design Pattern allows to pass a single instance of webdriver per session
 */
public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    /**
     *  Depending on the browserType switch statement will determine
     *         to open specific type of browser/driver
     *
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
            }
        }
        return driver;
    }

    /**
     * Method to kill(close) browser session
     */
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
