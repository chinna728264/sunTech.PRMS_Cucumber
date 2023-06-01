Feature: Validate Login feature

  Scenario: Succesful login with Valid credentials
    Given User is on PRMS landing page
    When User enters valid "UserName" and "Password"
    Then Verify the title of page "Sun Technologies PRMS"
    And Successful toaster message should be displayed "User Logged In Successfully"
    And close the browser

  Scenario Outline: Succesful login with Valid credentials
    Given User is on PRMS landing page
    When User enters valid "<UserName>" and "<Password>"
    Then Verify the title of page "Sun Technologies PRMS"
    And Successful toaster message should be displayed "User Logged In Successfully"
    And close the browser

    Examples: 
      | UserName     | Password    |
      | chinnaswamyn | Chinna@1998 |
      | chinnaswamyn | Chinna@98   |
