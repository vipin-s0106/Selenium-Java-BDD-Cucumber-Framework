Feature: Testing of PHPTravel Website SmokeTesting


	Background:
		Given I naviagte to the "PHPTravel_URL" Home Page	
		And I wait for "3" second
		And I take Screenshot after navigating into the page
		And I created the Excel Template with "Demo.xlsx" Excel file name and "Sheet1" sheetname

  @Regression
  Scenario Outline: To Test the SignUp Functionality with Data Driven Concept
    When I click on "My Account" Link
    And  I Click on "SignUp" Link
    And I wait for "1" second
    And I take Screenshot before entering value
    When I Entered Correct "<firstname>" , "<lastname>" , "<mobile_no>" ,"<EmailID>" , "<Password>" and "<Confpass>"
    And I take Screenshot after entering value
    And Click on Submit button
    Then I Navigated to the User Home Page
    And I verified I logged or not
    And I take Screenshot after loging
    And I click on "<firstname>" link
    And I click on "Logout" button
    And I logged the result into "Demo.xlsx" excelfile with sheetname "Sheet1"
    And I take Screenshot4 after logout
    And I should be logout from the page
    And I close the Browser

    Examples: 
      | firstname | lastname | mobile_no  | EmailID             | Password | Confpass |
      | Vipin     | Sharma   | 1234567890 | vipin.s109@gmail.com |   123456 |   123456 |
      | Vipin     | Sharma   | 1234567890 | vipin.s118@gmail.com |   123456 |   123456 |
      #| Vipin     | Sharma   | 1234567890 | vipin.s51@gmail.com |   123456 |   123456 |
      #| Vipin     | Sharma   | 1234567890 | vipin.s52@gmail.com |   123456 |   123456 |
