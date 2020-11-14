package br.com.selenium.bdd.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "classpath:features/",
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml" },
		monochrome = true,
		tags = {"@TesteRegressivo"},
		glue = {"br.com.selenium.bdd.stepDefinition"},
		dryRun = false,
		strict = true )
public class RegressivoRunner {

}
