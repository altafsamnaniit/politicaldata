Feature: Create and GET APIs verification using API chain

  Scenario: Verify that GetLatestRecords and GetRecordByID APIs are able to fetch record created by Create API
    Given I set create API request body for "CreateAPI_009"
    And I set headers for create API request
    When I send post request to create API
    Then Create API should send status code as 201
    And Create Record API Response Body should be as expected
    When I send get request to GetLatestRecords API for "CreateAPI_009"
    Then Newly created record should be present in GetLatestRecords API response
    When I send get request to GetRecordByID API for "CreateAPI_009"
    Then GetRecordByID API response should be as expected
