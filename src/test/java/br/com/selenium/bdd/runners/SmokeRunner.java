package br.com.selenium.bdd.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "classpath:features/Smoke",
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml" },
		monochrome = true,
		tags = {"@SmokeTeste"},
		glue = {"br.com.bvnet.selenium.bdd.stepDefinition"},
		dryRun = false,
		strict = true )
public class SmokeRunner {

}
