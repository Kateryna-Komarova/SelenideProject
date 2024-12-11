Feature: Login

  @validData
  Scenario:  Successful login
    Given User is on HomePage
    When User clicks on Login icon
  #  Then User verifies Login form is displayed
    And User enters valid data
    And User clicks on Anmelden button
    And User clicks on User icon
    Then User verifies his name

  @wrongEmail
  Scenario Outline: Login with wrong email and valid password
    Given User is on HomePage
    When User clicks on Login icon
    And User enter wrong email and valid password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Anmelden button
    Then User verifies Error message is displayed
    Examples:
      | email          | password    |
      | kokosgmail.com | Qwerty25KL@ |
      | Kokos@gmail.co | Qwerty25KL@ |
      | korogmailcom   | Qwerty25KL@ |
