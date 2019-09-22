package com.stepDef;

import com.business.GetRecordByIDAPI;
import com.framework.APIObjectManager;
import com.framework.APIUtil;
import com.framework.JSONUtility;
import com.framework.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class GetRecordByIDAPISteps {

    private ScenarioContext scenarioContextObj;
    private JSONUtility jsonUtilityObj;
    private APIObjectManager objectManagerObj;
    private APIUtil apiUtilObj;
    private Response response;
    private Scenario scenario;

    private GetRecordByIDAPI getRecordByIDAPIObj;

    public GetRecordByIDAPISteps(CommonSteps commonStepsObj){
        this.scenarioContextObj = commonStepsObj.getScenarioContextObj();
        this.jsonUtilityObj = commonStepsObj.getJsonUtilityObj();
        this.objectManagerObj = commonStepsObj.getAPIObjectManagerObj();
        this.apiUtilObj = commonStepsObj.getApiUtilObj();
        this.scenario = commonStepsObj.getScenario();
    }

    @When("I send get request to GetRecordByID API for \"([^\"]*)\"")
    public void send_get_request_by_id_request(String scenarioID){
        System.out.println("Sending GetRecordByID request...");
        scenarioContextObj.setContext(jsonUtilityObj.convertJSONtoMAP(scenarioID));
        apiUtilObj.setBaseURI(scenarioContextObj.getContext("baseURI"));
        response = apiUtilObj.getRequest(scenarioContextObj.getContext("reqUri")+"/"+scenarioContextObj.getContext("id"));
        scenario.write(response.getBody().prettyPrint());
    }

    @Then("GetRecordByID API response should be as expected")
    public void verify_response_body(){
        if(response.getStatusCode() != 404) {
            System.out.println("Verifying GetRecordByID API response...");
            getRecordByIDAPIObj = objectManagerObj.getGetRecordByIDAPIObj();
            getRecordByIDAPIObj.verifyRecordDetails(response.getBody().asString());
        }
    }

    @Then("GetRecordByID API should send status code as ([^\"]*)")
    public void verify_get_record_by_id_api_status_code(int expectedStatusCode){
        System.out.println("Verifying GetRecordByID API Response Status code...");
        apiUtilObj.verifyStatusCode(expectedStatusCode);
    }

}
