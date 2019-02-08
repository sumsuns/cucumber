package suma.webservices;

//import org.junit.runner.RunWith; 
//import cucumber.junit.Cucumber; 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions( plugin = {"pretty", "html:target/cucumber", "pretty:target/cucumber-reports/cucumber-pretty.txt","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber-results.xml"}, features = "src/test/resources", glue = { "nokia.webservices" },tags= { "@dashboard-access" })

public class Runtest {

}
