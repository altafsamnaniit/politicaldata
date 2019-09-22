Feature: Create Political Record API verification

  Scenario Outline: <Scenario_ID>: Verify that Create Political record API works as expected
    Given I set create API request body for "<Scenario_ID>"
    And I set headers for create API request
    When I send post request to create API
    Then Create API should send status code as <ExpectedResponseCode>
    And Create Record API Response Body should be as expected

    Examples:
      | Scenario_ID                       | ExpectedResponseCode |
      | CreateAPI_001                     | 201                  |
      | CreateAPIWithoutCountry_002       | 400                  |
      | CreateAPIWithoutName_003          | 400                  |
      | CreateAPIWithoutPosition_004      | 400                  |
      | CreateAPIWithoutRisk_005          | 400                  |
      | CreateAPIWithoutYob_006           | 400                  |
      | CreateAPIWithInvalidRiskValue_006 | 400                  |
