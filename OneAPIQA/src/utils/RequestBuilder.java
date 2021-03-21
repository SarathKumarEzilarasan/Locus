package utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

public class RequestBuilder {

    private static ReadQaProps readQaProps;

    public static RequestSpecification buildRequest() {
        RestAssured.baseURI = APIConstants.BASEURL;
        List<Header> header = new ArrayList<>();
        readQaProps = ReadQaProps.inst();
        header.add(new Header("Authorization", "Bearer " + readQaProps.token));
        Headers headers = new Headers(header);
        RequestSpecification requestSpecification = RestAssured.given().accept(readQaProps.contentType())
                .contentType(readQaProps.contentType()).headers(headers).request().log().all();
        return requestSpecification;
    }
}
