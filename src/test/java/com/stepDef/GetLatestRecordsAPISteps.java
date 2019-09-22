package com.stepDef;

import com.business.GetLatestRecordsAPI;
import com.framework.APIObjectManager;
import com.framework.APIUtil;
import com.framework.JSONUtility;
import com.framework.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class GetLatestRecordsAPISteps {

    private ScenarioContext scenarioContextObj;
    private JSONUtility jsonUtilityObj;
    private APIObjectManager objectManagerObj;
    private APIUtil apiUtilObj;
    private Response response;
    private Scenario scenario;

    private GetLatestRecordsAPI getLatestRecordsAPIObj;

    public GetLatestRecordsAPISteps(CommonSteps commonStepsObj){
        this.scenarioContextObj = commonStepsObj.getScenarioContextObj();
        this.jsonUtilityObj = commonStepsObj.getJsonUtilityObj();
        this.objectManagerObj = commonStepsObj.getAPIObjectManagerObj();
        this.apiUtilObj = commonStepsObj.getApiUtilObj();
        this.scenario = commonStepsObj.getScenario();
    }

    @When("I send get request to GetLatestRecords API for \"([^\"]*)\"")
    public void send_request_to_fetch_newly_created_record(String scenarioID){
        System.out.println("Sending get request to fetch records...");
        scenarioContextObj.setContext(jsonUtilityObj.convertJSONtoMAP(scenarioID));
        scenario.write("Base URI: " + scenarioContextObj.getContext("baseURI"));
        apiUtilObj.setBaseURI(scenarioContextObj.getContext("baseURI"));
        response = apiUtilObj.getRequest(scenarioContextObj.getContext("reqUri"));
        scenario.write(response.getBody().prettyPrint());
    }

    @Then("GetLatestRecords API should send status code as ([^\"]*)")
    public void verify_response_code(int expectedResponseCode){
        System.out.println("comparing HTTP status code...");
        scenario.write("Status code: " + response.getStatusCode());
        apiUtilObj.verifyStatusCode(expectedResponseCode);
    }

    @Then("GetLatestRecords API Response Body should contain 5 records")
    public void verify_response_body(){
        System.out.println("Verifying Response Body...");
        getLatestRecordsAPIObj = objectManagerObj.getGetLatestRecordsAPIObj();
        getLatestRecordsAPIObj.verifyGetLatestRecordsAPIResponseBody(response.getBody().asString());
    }

    @Then("Newly created record should be present in GetLatestRecords API response")
    public void verify_precence_of_newly_created_record(){
        System.out.println("Verifying presence of newly created record...");
        getLatestRecordsAPIObj = objectManagerObj.getGetLatestRecordsAPIObj();
        getLatestRecordsAPIObj.verifyPresenceOfNewRecord(response.getBody().asString());
    }
}
