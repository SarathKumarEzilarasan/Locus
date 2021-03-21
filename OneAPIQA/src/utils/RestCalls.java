package utils;

import io.restassured.specification.RequestSpecification;

public class RestCalls {

    public static Result post(Object body, String endPoint) {
        RequestSpecification requestSpecification = RequestBuilder.buildRequest();
        requestSpecification.body(body);
        io.restassured.response.Response response = requestSpecification.when().post(endPoint)
                .then().log().all().extract().response();
        return new Result(response.statusCode(), response.asString());
    }

    public static Result get(String endPoint) {
        RequestSpecification requestSpecification = RequestBuilder.buildRequest();
        io.restassured.response.Response response = requestSpecification.when().get(endPoint)
                .then().log().all().extract().response();
        return new Result(response.statusCode(), response.asString());
    }


}
