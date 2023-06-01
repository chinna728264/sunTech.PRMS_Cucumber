Feature: Validate Manage SOW Screen

  Background: Verify Login Operation
    Given User is on PRMS landing page
    When User enters valid "chinnaswamyn" and "Chinna@1998"
    Then Verify the title of page "Sun Technologies PRMS"
    Then Successful toaster message should be displayed "User Logged In Successfully"
    When User is on View SOW screen

  @Regression1
  Scenario Outline: Validate Creation of SOW  
  When User is on View SOW screen
    And Clicks on Add button
    Then User is displayed with "Add SOW" screen
    When User enters valid data "<SOW Name>", "<Client Name>", "<SOW Value (USD)>", "<SOW Type>", "<SOW Status>", "<SOW Basis>", "<Start Month>", "<Start Year>", "<Start Date>", "<End Month>", "<End Year>", "<End Date>", "<SOW Details>", and  "<SOW File Upload Path>"
    And Click on ok button on the confirmation Popup
    Then User hould be displayed with " SOW Added Successfully "

    Examples: 
      | SOW Name        | Client Name | SOW Value (USD) | SOW Type | SOW Status  | SOW Basis | Start Month | Start Year | Start Date | End Month | End Year | End Date | SOW Details     | SOW File Upload Path                                  |  
      | Sample Test SOW | Realme      |           50000 | Billable | In Progress | Both      | May         |       2023 |         11 | May       |     2023 |       30 | Testing Purpose | ‪‪C:\\Users\\chinnaswamyn\\Downloads\\UserTestData.xlsx |  
