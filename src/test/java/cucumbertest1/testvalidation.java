/**
 * 
 */
/**
 * @author sningara
 *
 */
package cucumbertest1;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When; 



public class testvalidation { 
   WebDriver driver = null; 
	
   @Given("go To indeed dashboard") 
   public void go_To_indeed_dashboard() { 
      driver = new FirefoxDriver(); 
      driver.navigate().to("https://www.indeed.fr/?r=us"); 
   } 
	
   @When("check webelement access") 
   public void check_webelement_access() {
	  driver.findElement(By.id("fj")).isDisplayed();
  
   } 
	
   @Then("validate result") 
   public void validate_result() { 
	   if(driver.findElement(By.id("fj")).isDisplayed())
	   {
	   driver.findElement(By.id("fj")).click();
        System.out.println("Web element found test pass"); 
	   }
      else 
      {
         System.out.println("Test Failed"); 
      } 
      driver.close(); 
   }    
}