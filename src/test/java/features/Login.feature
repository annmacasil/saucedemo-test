Feature: Login

  Rule: test
    Scenario: Successful Login
      Given I am on the SauceDemo page
      When I login using a valid username and password
      Then I should be able to login successfully
      And I see the "Swag Labs" page