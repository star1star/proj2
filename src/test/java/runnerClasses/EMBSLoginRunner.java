package runnerClasses;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features="src/test/resourses/features", 
                 glue={"stepDefinitions"}, 
                 // plugin = {"html:target/cucumber-html-report"}
                 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/EMBSTestReport.html"}
		         //plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/surefire-reports/report.html"}
		         
		        // plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		         )


public class EMBSLoginRunner {
 

}

