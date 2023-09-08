package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// using cucumber with junit
@RunWith(Cucumber.class)
@CucumberOptions(
        // link feature file by providing the path of feature file inside features
        features = "src/test/resources/features" ,

        // link StepDefinitions class by providing the path of stepdefinitions inside glue
        glue = "stepdefinitions",

        // set monochrome as true to get the output to the console colorless
        monochrome = true,

        // provide the tag name which is used above the Feature in feature file
        tags = "@SmokeTest",

        // create plugins to generate the reports for better readability
        // generate html reports
        plugin = {"pretty", "html:target/HtmlReports/report.html",

        // generate json reports
         "json:target/JsonReports/report.json",

        // generate xml reports
        "junit:target/JunitReports/report.xml"}
)
public class TestRunner {

}
