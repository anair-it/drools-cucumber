package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features", glue={"playlist"}, monochrome = true, plugin = {"json:target/cucumber/cucumber.json"},strict=true)
public class CucumberRunnerTest {}
