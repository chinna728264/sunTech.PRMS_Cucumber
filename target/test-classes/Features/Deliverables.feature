Feature: Validate Project Deliverables screen under Projects Module

  Background: Login Operation
    Given User is on PRMS landing page
    When User enters valid "chinnaswamyn" and "Chinna@1998"
    Then Verify the title of page "Sun Technologies PRMS"
    Then Successful toaster message should be displayed "User Logged In Successfully"
    When User is on Search Projects screen

  @Regression1
  Scenario Outline: Validate Creation of Project Deliverables
    And User selects respective "<Project Name>"
    Then User should be navigate to "Project Deliverable" screen
    And Click on Add button
    #And User enters valid data "<Deliverables>", "<Details>", "<Status>", "<Estimation Year>", "<Estimation Month>", "<Estimation Date>", "<Actual Year>", "<Actual Month>", "<Actual Date>"
    #And Select the check box
    #And Click on save button

    Examples: 
      | Project Name | Deliverables | Details                       | Status    | Estimation Year | Estimation Month | Estimation Date | Actual Year | Actual Month | Actual Date |
      | SQE          | Sprint 1     | Planned to deliver 10 tickets | Completed |            2023 | APR              |               4 |        2023 | MAY          |          18 |
