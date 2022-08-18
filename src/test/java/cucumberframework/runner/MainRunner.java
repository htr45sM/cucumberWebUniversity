package cucumberframework.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

//Defining the feature package and the steps java file package name
@CucumberOptions (
		features = {"src/test/java/cucumberframework/featurefiles"},
		glue = {"cucumberframework.steps"},
		//monochrome = true,
		plugin = {"pretty", "html:targetReport/cucumber", "json:targetReport/cucumber.json" }
		)
public class MainRunner extends AbstractTestNGCucumberTests{

}
