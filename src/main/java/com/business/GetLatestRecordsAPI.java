package com.business;

import com.framework.ScenarioContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class GetLatestRecordsAPI {

    private int expectedNumberOfRecords = 5;
    private ScenarioContext scenarioContext;

    public GetLatestRecordsAPI(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    public void verifyGetLatestRecordsAPIResponseBody(String responseBody){
        JSONArray jsonResBody = new JSONArray(responseBody);
        //Response should contains only 5 politicians records
        System.out.println("Expected number of records: " + expectedNumberOfRecords + " Actual number of records: " + jsonResBody.length());
        Assert.assertEquals("Number of records in response body is not as expected", expectedNumberOfRecords, jsonResBody.length());
        System.out.println("Number of records in response body is as expected");
    }

    public void verifyPresenceOfNewRecord(String responseBody){
        JSONArray jsonResBody = new JSONArray(responseBody);
        JSONObject recordObject = new JSONObject();
        boolean isPresent = false;
        for(int no=0; no<jsonResBody.length(); no++){
            recordObject = jsonResBody.getJSONObject(no);
            if((recordObject.get(("id")).equals(scenarioContext.getContext("id")))){
                isPresent = true;
                break;
            }
        }

        Assert.assertTrue(isPresent);

        GetRecordByIDAPI getRecordByIDAPIObj = new GetRecordByIDAPI(scenarioContext);
        getRecordByIDAPIObj.verifyRecordDetails(recordObject.toString());
        System.out.println("Newly created record is present in response");
    }
}
