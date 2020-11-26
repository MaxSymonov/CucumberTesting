package stepsRun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Login.feature",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:test-output.html"}
)
public class TestRunner {
}
