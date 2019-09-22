package com.framework;

import com.business.CreateRecordAPI;
import com.business.GetLatestRecordsAPI;
import com.business.GetRecordByIDAPI;

public class APIObjectManager {

    private CreateRecordAPI createRecordAPIObj;
    private GetLatestRecordsAPI getLatestRecordsAPIObj;
    private GetRecordByIDAPI getRecordByIDAPIObj;

    private ScenarioContext scenarioContext;

    public APIObjectManager(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    public CreateRecordAPI getCreateRecordAPIObj(){
        return (createRecordAPIObj == null)?createRecordAPIObj = new CreateRecordAPI(scenarioContext) : createRecordAPIObj;
    }

    public GetLatestRecordsAPI getGetLatestRecordsAPIObj(){
        return (getLatestRecordsAPIObj == null)?getLatestRecordsAPIObj = new GetLatestRecordsAPI(scenarioContext) : getLatestRecordsAPIObj;
    }

    public GetRecordByIDAPI getGetRecordByIDAPIObj(){
        return (getRecordByIDAPIObj == null)?getRecordByIDAPIObj = new GetRecordByIDAPI(scenarioContext) : getRecordByIDAPIObj;
    }
}
