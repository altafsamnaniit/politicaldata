Feature: Get latest records API verification

  Scenario: Verify that get latest records API fetches only 5 records
    When I send get request to GetLatestRecords API for "GetLatestRecordsAPI_008"
    Then GetLatestRecords API should send status code as 200
    And GetLatestRecords API Response Body should contain 5 records