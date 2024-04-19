Feature: Login Functionality
  As a user
  I want to be able to log in to my account
  So that I can access the app functionality

  Scenario Outline: Invalid Login
    Given I am on the login page
    And I input a invalid <username> and <password>
    When I click on the Login button
    Then I should get an error message indicating <errormessage>
    Examples:
      | username    | password    | errormessage                                                |  |
      | invaliduser | invalidpass | Provided credentials do not match any user in this service. |  |

  Scenario: Valid Login
    Given I am on the login page
    And I have selected an available username and password from the login screen
    When I click on the Login button
    Then I should be logged in successfully