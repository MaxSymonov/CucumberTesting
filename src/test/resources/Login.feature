Feature: Login
  User login.

  Scenario: Successful login with valid credentials
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And User clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout button
    Then Page title should be "Your store. Login"
    And Close Chrome browser

  Scenario Outline: Login data driven
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And User clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout button
    Then Page title should be "Your store. Login"
    And Close Chrome browser
    Examples:
      |email  |password
      |admin@yourstore.com  |admin
      |admin1@yourstore.com  |admin123

