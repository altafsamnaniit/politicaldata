package com.stepDef;

import com.framework.APIObjectManager;
import com.framework.APIUtil;
import com.framework.JSONUtility;
import com.framework.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class CommonSteps {

    private ScenarioContext scenarioContextObj;
    private JSONUtility jsonUtilityObj;
    private APIObjectManager objectManagerObj;
    private APIUtil apiUtilObj;
    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        scenarioContextObj = new ScenarioContext();
        jsonUtilityObj = new JSONUtility();
        objectManagerObj = new APIObjectManager(scenarioContextObj);
        apiUtilObj = new APIUtil();
        this.scenario = scenario;
    }

    public ScenarioContext getScenarioContextObj() {
        return scenarioContextObj;
    }

    public JSONUtility getJsonUtilityObj() {
        return jsonUtilityObj;
    }

    public APIObjectManager getAPIObjectManagerObj() {
        return objectManagerObj;
    }

    public APIUtil getApiUtilObj() {
        return apiUtilObj;
    }

    public Scenario getScenario() {
        return scenario;
    }
}
