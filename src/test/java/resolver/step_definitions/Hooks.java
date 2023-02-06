package resolver.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resolver.utilities.ConfigurationReader;
import resolver.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    /**
     * To open a browser before each scenario
     *
     */
    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * To close it after and take a screenshot(in to attach it to cucumber report) in case if test failed
     *
     */
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();

    }
}
