package com.stepDef;

import com.business.CreateRecordAPI;
import com.framework.APIObjectManager;
import com.framework.APIUtil;
import com.framework.JSONUtility;
import com.framework.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;

public class CreateAPISteps {

    private ScenarioContext scenarioContextObj;
    private JSONUtility jsonUtilityObj;
    private APIObjectManager objectManagerObj;
    private APIUtil apiUtilObj;
    private Response response;
    private Scenario scenario;
    private String scenarioID;

    private CreateRecordAPI createRecordAPIObj;


    public CreateAPISteps(CommonSteps commonStepsObj){
        this.scenarioContextObj = commonStepsObj.getScenarioContextObj();
        this.jsonUtilityObj = commonStepsObj.getJsonUtilityObj();
        this.objectManagerObj = commonStepsObj.getAPIObjectManagerObj();
        this.apiUtilObj = commonStepsObj.getApiUtilObj();
        this.scenario = commonStepsObj.getScenario();
    }

    @Given("I set create API request body for \"([^\"]*)\"")
    public void i_set_create_API_request_body_for_Create_(String scenarioID) {
        System.out.println("Setting up request body...");
        this.scenarioID = scenarioID;
        scenarioContextObj.setContext(jsonUtilityObj.convertJSONtoMAP(scenarioID));
        createRecordAPIObj = objectManagerObj.getCreateRecordAPIObj();
        scenario.write("Base URI: " + scenarioContextObj.getContext("baseURI"));
        apiUtilObj.setBaseURI(scenarioContextObj.getContext("baseURI"));
        String reqBody = createRecordAPIObj.getRequestBody();
        apiUtilObj.setRequestBody(reqBody);
        scenario.write("Request Body: " + reqBody);
    }

    @Given("I set headers for create API request")
    public void setCreateAPIHeaders(){
        System.out.println("Setting up request headers...");
        apiUtilObj.setHeader("Content-Type","application/json");
    }

    @When("I send post request to create API")
    public void i_send_post_request_to_create_API() {
        System.out.println("sending post request...");
        response = apiUtilObj.postRequest(scenarioContextObj.getContext("reqUri"));
        scenario.write("Response Body: ");
        scenario.write(response.getBody().prettyPrint());
    }

    @Then("Create API should send status code as ([^\"]*)")
    public void i_should_receive(int expectedResponseCode) {
        System.out.println("comparing HTTP status code...");
        scenario.write("Status code: " + response.getStatusCode());
        apiUtilObj.verifyStatusCode(expectedResponseCode);
    }

    @Then("Create Record API Response Body should be as expected")
    public void response_Body_should_be_as_expected() throws IOException {
        createRecordAPIObj.verifyResponseBody(response.getBody().asString(),response.getStatusCode());
        jsonUtilityObj.amendJsonFile(scenarioID,"id", scenarioContextObj.getContext("id"));
    }
}
