package TestRunner;

import org.junit.runner.RunWith;

import BaseClassPackage.BaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\featurespackage\\OPCART.feature",
		glue= {"TestDefinitionpackage","Hooks"}, dryRun=false, monochrome=true,strict=false
	,plugin= {"json:target\\jsonreport.json"}
		)


public class RunenrClass extends BaseClass {
}

