Feature: Validate Projects Module

  Background: Login Operation
    Given User is on PRMS landing page
    When User enters valid "chinnaswamyn" and "Chinna@1998"
    Then Verify the title of page "Sun Technologies PRMS"
    Then Successful toaster message should be displayed "User Logged In Successfully"
    When User is on View Projects screen

  @Regression1
  Scenario Outline: Validate Creation of Project Details
    And Clicks on add button
    Then Verify the "Add Project" header
    When User enters valid data "<Project Name>","<Client Name>","<Project Type>","<Project Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>","<% Of Completion>","<Project Amount (USD)>","<Estimated Staff Hours>","<Actual Staff Hours>","<No Of Resources>" and "<Description>"
    And Click on save button
    And User clicks Ok on Add Project confirmation popup
    Then User is displayed with Successful message "Project Added Successfully"

    Examples: 
      | Project Name | Client Name     | Project Type | Project Status | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | % Of Completion | Project Amount (USD) | Estimated Staff Hours | Actual Staff Hours | No Of Resources | Description     |
      | PRMS Test    | Suntechnologies | POC          | In Progress    | Mar        |      2023 |        10 | Dec      |    2023 |      25 |               0 |                 5000 |                   400 |                550 |               5 | Testing Purpose |

  @Regression2
  Scenario Outline: Validate Updating of Project Details
    And Select any of the Project "<Project Name>"
    Then Verify the "Edit Project" header
    When User Updates valid data "<Project Type>","<Project Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>","<% Of Completion>","<Project Amount (USD)>","<Estimated Staff Hours>","<Actual Staff Hours>","<No Of Resources>" and "<Description>"
    And User Clicks on Update button
    And User clicks Ok on Update Project confirmation popup
    Then User should be displayed with Successful message "Updated Successfully"

    Examples: 
      | Project Name | Project Type | Project Status | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | % Of Completion | Project Amount (USD) | Estimated Staff Hours | Actual Staff Hours | No Of Resources | Description |
      | SQE          | Internal     | Not Started    | Apr        |      2023 |        10 | Nov      |    2023 |      25 |              10 |                 6000 |                   400 |                550 |               5 | Testing     |

  @Regression2
  Scenario: Validate Deleting  Not Started Projects in View Project screen
    Then User selects "Not Started" records
    Then Delete button should be gets enable
    When User perform delete operation
    Then User is displayed with Delete Project confirmation popup
    And User clicks Ok on Delete Project confirmation popup
    Then User is displayed with Successful message "Deleted Successfully"

  @Regression3
  Scenario Outline: Validate Deleting Statuses of Projects in View Project screen
    When User selects "<Status>" records
    Then Delete button should be disable
    And User should be displayed with "Only Projects With Status As 'NOT STARTED' Can Be Deleted" error message

    Examples: 
      | Status      |
      | Hold        |
      | In Progress |

  #| Completed   |
  @Regression4
  Scenario Outline: Validate search functionality for Project ID field
    And User enters project ID "<Project ID>"
    When Clicks on search button
    Then User should found client id "<Project ID Expecting>" in Search table
    And Click on reset button

    Examples: 
      | Project ID        | Project ID Expecting |
      | SQE-05-2023-6715  | SQE-05-2023-6715     |
      | PRMS-05-2023-7050 | PRMS-05-2023-7050    |

  @Regression5
  Scenario Outline: Validate search functionality for Project Name field
    And User enters project Name "<Project Name>"
    When Clicks on search button
    Then User should found project name "<Project Name Expecting>" in Search table
    And Click on reset button

    Examples: 
      | Project Name | Project Name Expecting |
      | Realme 7 pro | Realme 7 pro           |

  @Regression6
  Scenario Outline: Validate search functionality for Client Name field
    And User enters Client Name "<Client Name>"
    When Clicks on search button
    Then User should found Client name "<Client Name Expecting>" in Search table
    And Click on reset button

    Examples: 
      | Client Name | Client Name Expecting |
      | Realme      | Realme                |

  @Regression7
  Scenario Outline: Validate search functionality for Project status Dropdown
    And User selects respective "<Project Status>" filter
    When Clicks on search button
    Then User should found all "<Project Status>" in Search table
    And Click on reset button
    Then Filters should gets reset

    Examples: 
      | Project Status |
      | Not Started    |

  @Regression8
  Scenario Outline: Validate search functionality for Project Type dropDown
    And User selects respective project type "<Project Type>" filter
    When Clicks on search button
    Then User should found all project type "<Project Type>" in Search table
    And Click on reset button
    Then Filters should gets reset

    Examples: 
      | Project Type |
      | Internal     |

  @Regression9
  Scenario Outline: Validate Export Functionality in View Project screen
    And User clicks on export button
    When User selects any "<Type Of Report>" should download report file successfully

    Examples: 
      | Type Of Report |
      | CSV            |
      | XLS            |
      | PDF            |
