package resolver.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "resolver/step_definitions",
        dryRun = false,      // false to run test cases, true to create code snippets based on scenarios in feature files
        tags = "",           // to create different suites of tests, "" - in order to run all test cases
        publish = true       // true - generates and prints link to report in the console
)
public class TestRunner {
}
