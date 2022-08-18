
Feature: Login to the Webdriveruniversity website
  I want to use this template to validate the credential of the existing user

  Scenario Outline: Login to the Webdriveruniversity website with valid credential
    Given User navigates to the "<url>" website
    And User click on Login portal
    And User enters valid username "<username>"
    And User enters valid password "<password>"
    When User clicks on Login button
    Then An alert is displayed to the user with "<message>"
    
     Examples: 
      | url                                | username  | password     | message              |
      | http://www.webdriveruniversity.com | webdriver1 | webdriver124 | validation suceeded1  |
      
