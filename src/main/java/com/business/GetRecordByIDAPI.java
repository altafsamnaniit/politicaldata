package com.business;

import com.framework.ScenarioContext;
import org.json.JSONObject;
import org.junit.Assert;

public class GetRecordByIDAPI {

    private ScenarioContext scenarioContext;

    public GetRecordByIDAPI(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    public void verifyRecordDetails(String recordDetails){

        JSONObject jsonRecordObj = new JSONObject(recordDetails);

        Assert.assertEquals("country element value is not as expected", scenarioContext.getContext("country"), jsonRecordObj.get("country"));
        Assert.assertEquals("name element value is not as expected", scenarioContext.getContext("name"), jsonRecordObj.get("name"));
        Assert.assertEquals("position element value is not as expected", scenarioContext.getContext("position"), jsonRecordObj.get("position"));
        Assert.assertEquals("risk element value is not as expected", scenarioContext.getContext("risk"), String.valueOf(jsonRecordObj.get("risk")));
        Assert.assertEquals("yob element value is not as expected", scenarioContext.getContext("yob"), String.valueOf(jsonRecordObj.get("yob")));
    }

}
