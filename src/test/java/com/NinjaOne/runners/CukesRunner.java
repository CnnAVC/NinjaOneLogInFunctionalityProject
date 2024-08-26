package com.NinjaOne.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/NinjaOne/steps",
        dryRun = false,
        tags = "@VerifyPasswordAndEmailText",
        publish = true
)
public class CukesRunner {

}
