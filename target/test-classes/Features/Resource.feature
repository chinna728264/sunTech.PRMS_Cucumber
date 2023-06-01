Feature: Validate Project Deliverables screen under Projects Module

  Background: Login Operation
    Given User is on PRMS landing page
    When User enters valid "chinnaswamyn" and "Chinna@2023"
    Then Verify the title of page "Sun Technologies PRMS"
    Then Successful toaster message should be displayed "User Logged In Successfully"
    When User is on Search Projects screen

  @Regression1
  Scenario Outline: Validate Resource allocations for Projects
    And User selects any of the "<Project Name>"
    Then User should be navigated to "Resource Allocation" screen
    And Click on Add button
    Then User enters valid data "<Location>", "<Department>", "<Resource Name or ID>","<Resource Function>", "<Resource Type>", "<Bill Rate Type>", "<Amount Rate (USD)>", "<Start Year>", "<Start Month>", "<Start Date>", "<End Year>", "<End Month>", "<End Date>", "<Estimated Qty>", "<Actual Qty>", and "<Percentage Of Allocation>"

    Examples: 
      | Project Name | Location | Department | Resource Name or ID | Resource Function | Resource Type | Bill Rate Type | Amount Rate (USD) | Start Year | Start Month | Start Date | End Year | End Month | End Date | Estimated Qty | Actual Qty | Percentage Of Allocation |
      | Dev Project  | India    | QA Manual  |                3250 | Tester            | Billable      | Daily          |              1000 |       2023 | APR         |          4 |     2023 | APR       |       20 |           100 |        100 |                      100 |

  #| testing1     | India    | QA Manual  |                3256 | Tester            | Billable      | Daily          |              1000 |       2023 | APR         |          4 |     2023 | APR       |       20 |           100 |        100 |                      100 |
  @Regression2
  Scenario Outline: Validate Updating of Resource Details under Project
    And User selects  "<Project Name>"
    Then User should be navigated to "Resource Allocation" screen
    When User Updates dates data "<Resource Name or ID>", "<Resource Function>", "<Resource Type>", "<Bill Rate Type>", "<Amount Rate (USD)>", "<Start Year>", "<Start Month>", "<Start Date>", "<End Year>", "<End Month>", "<End Date>", "<Estimated Qty>", "<Actual Qty>", and "<Percentage Of Allocation>"

    Examples: 
      | Project Name | Resource Name or ID | Resource Function | Resource Type | Bill Rate Type | Amount Rate (USD) | Start Year | Start Month | Start Date | End Year | End Month | End Date | Estimated Qty | Actual Qty | Percentage Of Allocation |
      | Dev Project  |                3405 | Tester            | Billable      | Daily          |               110 |       2023 | APR         |          4 |     2023 | APR       |       20 |            10 |         10 |                       10 |

  @Regression3
  Scenario Outline: Validate Deleting Resource under Project
    And User selects "<Project Name>" to delete
    And User deletes particualar employees from project "<EmployeeName_or_ID>"
    Then User is displayed with "Successfully Deleted Data" message

    Examples: 
      | Project Name   | EmployeeName_or_ID |
      | Hindenburg LLC |               3246 |

      