package ui_tests.RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/ui_tests/FeatureFile", plugin = {"pretty", "json:target/reports_cucumber/Cucumber.json",
        "junit:target/reports_cucumber/Cucumber.xml",
        "html:target/reports_cucumber/report.html"
        }, glue = {
        "ui_tests/stepDefinitions"},
        tags = "@Tc02",
        monochrome = true, dryRun = false)
public class TestRunner {

}