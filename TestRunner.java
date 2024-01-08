package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features=".//Features/NopCumRegister.feature",
glue="StepDefinations",
dryRun=false,
monochrome= true,
plugin={"pretty","junit:target/JUnitReports/report.xml"},
tags="@test"
)
public class TestRunner {

}
