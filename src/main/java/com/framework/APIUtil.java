package com.framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class APIUtil {

    private Response response;
    private RequestSpecification request;

    public void setBaseURI(String baseURI)
    {
        RestAssured.baseURI = baseURI;
    }

    public void setRequestBody(String reqBody)
    {
        if(request == null)
            request = given().body(reqBody);
        else
            request.body(reqBody);
    }

    public void setHeader(String headerName, String headerValue)
    {
        if(request == null)
            request = given().header(headerName, headerValue);
        else
            request.header(headerName, headerValue);
    }

    public void setContentType(String contentType)
    {
        if(request == null)
            request = given().accept(contentType);
        else
            request.accept(contentType);
    }

    public void setQueryParam(String key, String value)
    {
        if(request == null)
            request = given().param(key, value);
        else
            request.queryParam(key, value);
    }

    public Response getRequest(String path)
    {
        if(request == null)
            request = given();
        response = request.request("get", path);
        return response;
    }

    public Response postRequest(String path)
    {
        response = request.request("post", path);

        return response;
    }

    public void verifyStatusCode(int expectedStatusCode)
    {
        System.out.println("Expected status code: " + expectedStatusCode + " Actual status code: " + response.getStatusCode());
        Assert.assertEquals("HTTP status code is not as expected", expectedStatusCode, response.getStatusCode());
        System.out.println("HTTP status is same as expected");
    }

}
