Feature: Login to NinjaApp

  Background:
    Given I am on the login page

@LogInPageNavigation
Scenario:  Verify that the user should be able to navigate to the login page successfully
  When the user clicks  the url  "https://app.ninjarmm.com"
  Then the user should be directed to the login page "https://app.ninjarmm.com/auth/#/login"
  And the title is “NinjaOne”

@SuccessFulLoginAttemptWithValidEmailAndPassword @
Scenario: Verify that the user should be able to log in with valid credentials
  When the user provides valid email address and password
  And the user clicks Sing In button
  Then the user should be directed to the MFA page

@UnsuccessfulLogInAttemptWithValidEmailAndInvalidPassword
Scenario: Verify that the user should not be able to log in with valid email and invalid password
  Given the user provides valid email address and invalid password
  When the user clicks Sing In button
  Then the user should not be directed to the MFA page
  And the user should get “Invalid username password. Please contact your system administrator for assistance.” error message






