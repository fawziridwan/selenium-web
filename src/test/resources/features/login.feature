Feature: Login with Sauce Demo

  As a user, I want to be able to log in to the Sauce Demo application.

  Background:
    Given I am on the Sauce Demo login page

  Scenario: Successful login with valid credentials
    When I log in with valid credentials
    Then I should be redirected to the inventory page

  Scenario Outline: Failed login with invalid credentials
    When I try to log in with "<username>" and "<password>"
    Then I should see an error message containing "<message>"
    Examples:
      | username      | password       | message                                                                   |
      | standard_user | wrong_password | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: Validate The Login Form get message Mandatory
    When I try to log in with "<username>" and "<password>"
    Then I should see an error message containing "<message>"
    Examples:
      | username | password | message                            |
      |          |          | Epic sadface: Username is required |

  Scenario Outline:
    When I try to log in with "<username>" and "<password>"
    Then I should see an error message containing "<message>"
    Examples:
      | username        | password     | message                                             |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |