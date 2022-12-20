Feature: Register

  @smoke, @regression
  Scenario: User should navigate to register page successfully
    Given I am on homepage
    When I click on register link
    And I see the Register Text

  @sanity, @regression
  Scenario: User should verify FirstName LastName Email Password And Confirm Password Fields Are Mandatory
    Given I am on homepage
    When I click on register link
    And I can click register Button
    Then I should verify the error message for mandatory field

  @regression
  Scenario: User Should verify Create Account Successfully
    Given I am on homepage
    When I click on register link
    And I can fill mandatory field "female","Prime","Testng","26","february","1999","manisha@gmail.com","prime123","prime123"
    And I can click register Button
    Then I can verify message your registration is completed



#  @ @regression
#  Scenario: User should create account successfully
#    Given I am on homepage
#    When I click on register link
#    And I enters following users details
#      | Jay  | Vaghani    | jay@gmail.com  | 07878451263 | Harrow |
#      | Amit | Kathrotiya | amit@gmail.com | 07878451285 | Luton  |
#      | Aum  | Vaghani    | aum@gmail.com  | 07878454585 | Harrow |
#    Then registration successful




