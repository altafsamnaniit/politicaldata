Feature: GetRecordByID API verification

  Scenario Outline: <Scenario_ID>: Verify that GetRecordByID API is working as expected
    When I send get request to GetRecordByID API for "<Scenario_ID>"
    Then GetRecordByID API should send status code as <ExpectedResponseCode>
    And GetRecordByID API response should be as expected

    Examples:
      | Scenario_ID                | ExpectedResponseCode |
      | GetRecordByID_010          | 200                  |
      | GetRecordWithInvalidID_011 | 404                  |