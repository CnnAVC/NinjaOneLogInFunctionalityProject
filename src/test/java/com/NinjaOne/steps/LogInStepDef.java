package com.NinjaOne.steps;

import com.NinjaOne.pages.LogInPage;
import com.NinjaOne.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

public class LogInStepDef {

    LogInPage logInPage = new LogInPage();
    WebDriver driver = new ChromeDriver();
    BrowserUtils browserUtils = new BrowserUtils();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public LogInStepDef(){

    }

    public LogInStepDef(LogInPage logInPage, WebDriver driver, WebDriverWait wait) {
        this.logInPage = logInPage;
        this.driver = driver;
        this.wait = wait;
    }
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {

        driver.get("https://app.ninjarmm.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("the user clicks  the url  {string}")
    public void theUserClicksTheUrl(String arg0) {

        driver.get("https://app.ninjarmm.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @Then("the user should be directed to the login page {string}")
    public void theUserShouldBeDirectedToTheLoginPage(String arg0) {

        assertThat(driver.getCurrentUrl().equals("https://app.ninjarmm.com/auth/#/login"));
    }

    @And("the title is “NinjaOne”")
    public void theTitleIsNinjaOne() {

        browserUtils.verifyTitle("NinjaOne");

    }

    @When("the user provides valid email address and password")
    public void theUserProvidesValidEmailAddressAndPassword() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage.emailInputBox.sendKeys("email@email.com");
        logInPage.passwordInputBox.sendKeys("password");

    }

    @And("the user clicks Sing In button")
    public void theUserClicksSingInButton() {

        logInPage.sinInButton.click();

    }

    @Then("the user should be directed to the MFA page")
    public void theUserShouldBeDirectedToTheMFAPage() {

        wait.until(ExpectedConditions.urlToBe("https://app.ninjarmm.com/auth/?return_to=%23%2FgetStarted&state=eyJtZmFUeXBlIjoiVTJGX1RPS0VOIiwiYXZhaWxhYmxlX21mYSI6eyJTTVNPVFAiOiI4MjY3IiwiVE9UUCI6InllcyIsIlUyRl9UT0tFTiI6InllcyJ9LCJjcmVkc1JlcXVlc3QiOiJ7XCJwdWJsaWNLZXlcIjp7XCJjaGFsbGVuZ2VcIjpcIkc5aHkzcW5GT1BUWVN4SjJiUDVRWC1RUU5TZzVUSVhiNU1qN3VWTU1XTm9cIixcInRpbWVvdXRcIjo0NTAwMCxcInJwSWRcIjpcImFwcC5uaW5qYXJtbS5jb21cIixcImFsbG93Q3JlZGVudGlhbHNcIjpbe1widHlwZVwiOlwicHVibGljLWtleVwiLFwiaWRcIjpcIjBrV0ZfZ28zVjJBUTJWT2VGejZkMjlTQWU0em9UZ0ZDQVB1dVcxSnlRd3dcIixcInRyYW5zcG9ydHNcIjpbXCJpbnRlcm5hbFwiLFwidXNiXCJdfV0sXCJ1c2VyVmVyaWZpY2F0aW9uXCI6XCJwcmVmZXJyZWRcIixcImV4dGVuc2lvbnNcIjp7XCJhcHBpZFwiOlwiaHR0cHM6Ly9hcHAubmluamFybW0uY29tXCJ9fX0iLCJsb2dpblRva2VuIjoiYzY1Yzc3ZDktMzNkNS00MGFmLTk4YmQtYmU1YTk2MjljZWE5In0#/mfa"));

    }

    @Given("the user provides valid email address and invalid password")
    public void theUserProvidesValidEmailAddressAndInvalidPassword() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage.emailInputBox.sendKeys("email@email.com");
        logInPage.passwordInputBox.sendKeys("pass");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage.sinInButton.click();
    }

    @Then("the user should not be directed to the MFA page")
    public void theUserShouldNotBeDirectedToTheMFAPage() {

        assertThat(driver.getCurrentUrl().equals("https://app.ninjarmm.com/auth/#/login"));

    }


    @And("the user should get “Invalid username password. Please contact your system administrator for assistance.” error message")
    public void theUserShouldGetInvalidUsernamePasswordPleaseContactYourSystemAdministratorForAssistanceErrorMessage() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(logInPage.errorMessage.getText(),"Invalid username/password. Please contact your system administrator for assistance.");
        BrowserUtils.sleep(5);
    }
}
