package com.business;

import com.framework.ScenarioContext;
import com.pojo.CreateRecordPojo;
import org.json.JSONObject;
import org.junit.Assert;

public class CreateRecordAPI {

    private CreateRecordPojo createRecordPojoObj;
    private ScenarioContext scenarioContext;

    public CreateRecordAPI(ScenarioContext scenarioContext) {
        createRecordPojoObj = new CreateRecordPojo();
        this.scenarioContext = scenarioContext;
    }

    public String getRequestBody() {
        JSONObject reqBody;

        if (!scenarioContext.getContext("country").equalsIgnoreCase(""))
            createRecordPojoObj.setCountry(scenarioContext.getContext("country"));

        if (!scenarioContext.getContext("name").equalsIgnoreCase(""))
            createRecordPojoObj.setName(scenarioContext.getContext("name"));

        if (!scenarioContext.getContext("position").equalsIgnoreCase(""))
            createRecordPojoObj.setPosition(scenarioContext.getContext("position"));

        if (!scenarioContext.getContext("risk").equalsIgnoreCase(""))
            createRecordPojoObj.setRisk(Integer.valueOf(scenarioContext.getContext("risk")));

        if (!scenarioContext.getContext("yob").equalsIgnoreCase(""))
            createRecordPojoObj.setYob(Integer.valueOf(scenarioContext.getContext("yob")));

        reqBody = new JSONObject(createRecordPojoObj);

        return reqBody.toString();
    }

    public void verifyResponseBody(String responseBody, int statusCode) {
        JSONObject jsonResponseBody = new JSONObject(responseBody);
        System.out.println("Verifying response body...");
        if (statusCode == 201) {
            Assert.assertEquals("Entity created successfully!", jsonResponseBody.get("message"));
            Assert.assertFalse(jsonResponseBody.get("id").toString().isEmpty());
            Assert.assertTrue(Boolean.valueOf(jsonResponseBody.get("ok").toString()));
            scenarioContext.setKeyValue("id", jsonResponseBody.get("id").toString());
        } else if(statusCode == 400){
            Assert.assertEquals("Invalid request - missing parameters", jsonResponseBody.get("message"));
            Assert.assertFalse(Boolean.valueOf(jsonResponseBody.get("ok").toString()));
        }
        System.out.println("Response body is as expected");
    }
}
