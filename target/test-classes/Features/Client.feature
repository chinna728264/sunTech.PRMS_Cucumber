Feature: Validate Client Module

  Background: Login Operation
    Given User is on PRMS landing page
    When User enters valid "chinnaswamyn" and "Chinna@1998"
    Then Verify the title of page "Sun Technologies PRMS"
    Then Successful toaster message should be displayed "User Logged In Successfully"
    When User is on "View Client" screen

  @Regression1
  Scenario Outline: Validate Creation of Client Details
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

  @Regression2
  Scenario Outline: Validate Updating of Client Details
    Then Verify the "Add Project" header
    And User selects any of the "Client"
    When User Updates data "<Address>","<Country>","<Location>","<Status>","<StartMonth>","<StartYear>","<StartDate>","<EndMonth>","<EndYear>","<EndDate>" and "<Description>"
    And User click on Update button
    And User clicks Ok on the confirmation popup
    Then User should be displayed with Successful message "Updated Successfully"

    Examples: 
      | Client Name | Address       | Country | Location    | Status | StartMonth | StartYear | StartDate | EndMonth | EndYear | EndDate | Description        |
      | SQE Test    | Hyderbad City | India   | HRL, LayOut | Hold   | Dec        |      2022 |         2 | Sep      |    2023 |       20 | SIT Testing |

  @Regression3
  Scenario: Validate Deletion of Not Active Status records in Client screen
    Then User selects "Not Active" records
    Then Delete button should be gets enable
    When User perform delete operation
    And User clicks Ok on the confirmation popup
    #Then User should be displayed with Successful message "Deleted Successfully"

  @Regression4
  Scenario Outline: Validate Deletion of Active and Hold Status records in Client screen
    When User selects "<Status>" records
    Then Delete button should be disable
    And User should be displayed with "Only Not-Active Clients Can Be Deleted" error message

    Examples: 
      | Status |
      | Active |
      | Hold   |

  @Regression5
  Scenario: Validate the sort functionality in Client table of Client Name
    Then Verify the recods
    And Click on Sort icon on Client Name
    Then All the Client Name recods Should be sorted based on the Alphabet/numbers values in ascending order

  @Regression6
  Scenario Outline: Validate search functionality for Client Name field
    And User enters client name "<Client Name>"
    When Clicks on search button
    Then User should found client name "<Client Names Expecting>" in Search table
    And Click on reset button

    Examples: 
      | Client Name | Client Names Expecting |
      | FHLBNY      | FHLBNY                 |
      | Sun         | Sun                    |

  @Regression7
  Scenario Outline: Validate search functionality for Client ID field
    And User enters client ID "<Client ID>"
    When Clicks on search button
    Then User should found only one client ID "<Expected Client ID>" in Search table
    And Click on reset button
    Then Filters should gets reset

    Examples: 
      | Client ID   | Expected Client ID |
      | Sun507-7327 | Sun507-7327        |
      | FHLBNY-6816 | FHLBNY-6816        |

  @Regression8
  Scenario Outline: Validate search functionality for status dropDown
    And User selects respective "<Status>" filter
    When Clicks on search button
    Then User should found all "<Status>" in Search table
    And Click on reset button
    Then Filters should gets reset

    Examples: 
      | Status     |
      | Active     |
      | Not Active |

 
  @Regression9
  Scenario Outline: Validate Downloading the reports in Client screen
    And User clicks on export button
    When User selects any "<Type Of Report>" should download report file successfully

    Examples: 
      | Type Of Report |
      | CSV            |
      | XLS            |
      | PDF            |
