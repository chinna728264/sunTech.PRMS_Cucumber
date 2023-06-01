Feature: Automating PRMS Application Using Cucumber FrameWork

  Background: Login Operation
    Given User is on PRMS landing page
    When User enters valid "chinnaswamyn" and "Chinna@2023"
    Then Verify the title of page "Sun Technologies PRMS"
    Then Successful toaster message should be displayed "User Logged In Successfully"

  #Creating Clients
  Scenario Outline: Validate Creation of Client Details
    When User is on "View Client" screen
    And Clicks on add button
    Then Verify the "Add Project" header
    When User enters valid data "<Client Name>","<Address>","<Country>","<Location>","<Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>" and "<Description>"
    And Click on save button
    And User clicks Ok on the Add Client confirmation popup
    Then User should be displayed with  "Client Added Successfully"

    Examples: 
      | Client Name | Address   | Country       | Location         | Status     | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | Description          |
      | SIT         | New York  | India         | NEW YORK, JERSEY | Active     | Feb        |      2022 |        14 | Aug      |    2023 |      10 | For Testing          |
      | SQE Test    | Hyderbad  | United States | HRL, Lay Out     | Not Active | Jan        |      2023 |         1 | Nov      |    2023 |       5 | Regression Testing   |
      | DEV Test    | Bangloare | India         | Chennai          | Hold       | Apr        |      2023 |        18 | Dec      |    2023 |       1 | Double check Testing |

  #Updating Client Details
  @Test1
  Scenario Outline: Validate Updating of Client Details
    When User is on "View Client" screen
    And User selects any of the "<Client Name>"
    When User Updates data "<Address>","<Country>","<Location>","<Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>" and "<Description>"
    And User click on Update button
    And User clicks Ok on the confirmation popup
    Then User should be displayed with Successful message "Updated Successfully"

    Examples: 
      | Client Name | Address       | Country | Location    | Status | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | Description |
      | DEV Test    | Hyderbad City | India   | HRL, LayOut | Hold   | Dec        |      2022 |         2 | Sep      |    2023 |      20 | SIT Testing |

  Scenario: Validate Deletion of Not Active Status records in Client screen
    When User is on "View Client" screen
    Then User selects "Not Active" status client
    Then Delete button should be gets enable
    When User perform delete operation
    And User clicks Ok on the confirmation popup

  #Then User should be displayed with Successful message "Deleted Successfully"
  Scenario Outline: Validate Deletion of Active and Hold Status records in Client screen
    When User is on "View Client" screen
    When User selects "<Status>" records
    Then Delete button should be disable
    And User should be displayed with "Only Not-Active Clients Can Be Deleted" error message

    Examples: 
      | Status |
      | Active |
      | Hold   |

  #Projects
  Scenario Outline: Validate Creation of Project Details
    When User is on View Projects screen
    And Click on add button on View Projects screen
    Then Verifys the "Add Project" header
    When User enters valid data "<Project Name>","<Client Name>","<Project Type>","<Project Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>","<% Of Completion>","<Project Amount (USD)>","<Estimated Staff Hours>","<Actual Staff Hours>","<No Of Resources>" and "<Description>"
    And Clicks on save button on View Projects screen
    And User clicks Ok on Add Project confirmation popup
    Then User is displayed with Successful message "Project Added Successfully"

    Examples: 
      | Project Name | Client Name | Project Type | Project Status | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | % Of Completion | Project Amount (USD) | Estimated Staff Hours | Actual Staff Hours | No Of Resources | Description     |
      | PRMS Test    | SIT         | POC          | In Progress    | Mar        |      2023 |        10 | Dec      |    2023 |      25 |               0 |                 5000 |                   400 |                550 |               5 | Testing Purpose |

  Scenario Outline: Validate Updating of Project Details
    When User is on View Projects screen
    And Select any of the Project "<Project Name>"
    Then Verify the "Edit Project" header
    When User Updates valid data "<Project Type>","<Project Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>","<% Of Completion>","<Project Amount (USD)>","<Estimated Staff Hours>","<Actual Staff Hours>","<No Of Resources>" and "<Description>"
    And User Clicks on Update button
    And User clicks Ok on Update Project confirmation popup
    Then User is be displayed with Successful message "Updated Successfully"

    Examples: 
      | Project Name | Project Type | Project Status | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | % Of Completion | Project Amount (USD) | Estimated Staff Hours | Actual Staff Hours | No Of Resources | Description |
      | PRMS Test    | Internal     | Not Started    | Apr        |      2023 |        10 | Nov      |    2023 |      25 |              10 |                 6000 |                   400 |                550 |               5 | Testing     |

  Scenario: Validate Deleting  Not Started Projects in View Project screen
    When User is on View Projects screen
    Then User selects "Not Started" record in View Projects screen
    Then Delete button should be get enable in View Projects screen
    When User perform delete operations in View Projects screen
    Then User is displayed with Delete Project confirmation popup
    And User clicks Ok on Delete Project confirmation popup
    Then User is displayed with deleted Successful message "Deleted Successfully"

  Scenario Outline: Validate Deleting Statuses of Projects in View Project screen
    When User is on View Projects screen
    When User selects "<Status>" record
    Then Delete button should gets disable
    And User should be displayed with "Only Projects With Status As 'NOT STARTED' Can Be Deleted" error msg

    Examples: 
      | Status      |
      | Hold        |
      | In Progress |

  @TR
  Scenario Outline: Validate Export Functionality in View Project screen
    And User clicks on export button
    When User selects any "<Type Of Report>" should download report file successfully

    Examples: 
      | Type Of Report |
      | XLS            |

  # Resources
  Scenario Outline: Validate Resource allocations for Projects
    And User selects any of the "<Project Name>"
    Then User should be navigated to "Resource Allocation" screen
    And Click on Add button
    Then User enters valid datas "<Location>", "<Department>", "<Resource Name or ID>","<Resource Function>", "<Resource Type>", "<Bill Rate Type>", "<Amount Rate (USD)>", "<Start Year>", "<Start Month>", "<Start Date>", "<End Year>", "<End Month>", "<End Date>", "<Estimated Qty>", "<Actual Qty>", and "<Percentage Of Allocation>"

    Examples: 
      | Project Name | Location | Department                       | Resource Name or ID | Resource Function | Resource Type      | Bill Rate Type | Amount Rate (USD) | Start Year | Start Month | Start Date | End Year | End Month | End Date | Estimated Qty | Actual Qty | Percentage Of Allocation |
      | PRMS Test    | India    | QA Manual                        |                3250 | Tester            | Client NonBillable | Daily          |              1000 |       2023 | APR         |         25 |     2023 | JUN       |       20 |           100 |        100 |                      100 |
      | PRMS Test    | India    | Application Development Services |                2329 | Sr. Developer     | Billable           | Daily          |              2000 |       2023 | APR         |         25 |     2023 | JUL       |       10 |           100 |        100 |                      100 |
      | PRMS Test    | India    | QA Manual                        |                2515 | Sr. Tester        | Billable           | Daily          |              3000 |       2023 | MAY         |         10 |     2023 | AUG       |        5 |           100 |        100 |                      100 |
      | PRMS Test    | India    | Application Development Services |                2569 | Tech Lead         | Billable           | Daily          |              4000 |       2023 | MAY         |         10 |     2023 | SEP       |       18 |           100 |        100 |                      100 |
      | PRMS Test    | India    | QA Manual                        |                3090 | Bussiness Analyst | Billable           | Daily          |              5000 |       2023 | JUN         |          2 |     2023 | OCT       |        2 |           100 |        100 |                      100 |
      | PRMS Test    | India    | QA Automation                    |                3261 | Tester            | Non Billable       | Daily          |              6000 |       2023 | JUN         |          2 |     2023 | NOV       |       20 |           100 |        100 |                      100 |

  Scenario Outline: Validate Updating of Resource Details under Project
    And User selects  "<Project Name>"
    Then User should be navigated to "Resource Allocation" screen
    When User Updates dates data "<Resource Name or ID>", "<Resource Function>", "<Resource Type>", "<Bill Rate Type>", "<Amount Rate (USD)>", "<Start Year>", "<Start Month>", "<Start Date>", "<End Year>", "<End Month>", "<End Date>", "<Estimated Qty>", "<Actual Qty>", and "<Percentage Of Allocation>"

    Examples: 
      | Project Name | Resource Name or ID | Resource Function | Resource Type | Bill Rate Type | Amount Rate (USD) | Start Year | Start Month | Start Date | End Year | End Month | End Date | Estimated Qty | Actual Qty | Percentage Of Allocation |
      | PRMS Test    |                3250 | Tester            | Billable      | Daily          |               110 |       2023 | APR         |          4 |     2023 | APR       |       20 |            10 |         10 |                       10 |

  @Test12
  Scenario Outline: Validate Deleting Resource under Project
    And User selects "<Project Name>" to delete
    And User deletes particualar employees from project "<EmployeeName_or_ID>"
    Then User is displayed with "Successfully Deleted Data" message

    Examples: 
      | Project Name | EmployeeName_or_ID |
      | PRMS Test    |               3246 |

  #SOW
  Scenario Outline: Validate Creation of SOW
    When User is on View SOW screen
    And Clicks on Add button SOW
    Then User is displayed with "Add SOW" screen
    When User enters valid data "<SOW Name>", "<Client Name>", "<SOW Value (USD)>", "<SOW Type>", "<SOW Status>", "<SOW Basis>", "<Start Month>", "<Start Year>", "<Start Date>", "<End Month>", "<End Year>", "<End Date>", "<SOW Details>", and  "<SOW File Upload Path>"
    And Click on ok button on the confirmation Popup
    Then User hould be displayed with " SOW Added Successfully "

    Examples: 
      | SOW Name        | Client Name | SOW Value (USD) | SOW Type | SOW Status  | SOW Basis | Start Month | Start Year | Start Date | End Month | End Year | End Date | SOW Details     | SOW File Upload Path                                    |
      | Sample Test SOW | SIT         |           50000 | Billable | In Progress | Both      | May         |       2023 |         11 | May       |     2023 |       30 | Testing Purpose | ‪‪C:\\Users\\chinnaswamyn\\Downloads\\UserTestData.xlsx |

  @Regression12
  Scenario Outline: Validate Creation of Project Deliverables
  When User is on Search Projects screen
    And User selects respective "<Project Name>"
    And Click on Add btn
    And User enters valid data "<Deliverables>", "<Details>", "<Status>", "<Estimation Year>", "<Estimation Month>", "<Estimation Date>", "<Actual Year>", "<Actual Month>", "<Actual Date>"
    #And Select the check box
    #And Click on save button
    Examples: 
      | Project Name | Deliverables | Details                       | Status    | Estimation Year | Estimation Month | Estimation Date | Actual Year | Actual Month | Actual Date |
      | SQE          | Sprint 1     | Planned to deliver 10 tickets | Completed |            2023 | APR              |               4 |        2023 | MAY          |          18 |
