package com.one.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;

public class Tests extends baseClass {

    @Test
    public void getBooks() throws IOException {
        Result result = RestCalls.get(APIConstants.BOOK_ENDPOINT);
        GetBooks getBooks = result.getBooks();
        Assert.assertEquals(getBooks.getDocs().size(), 3);
        DiffUtil.compare("books", result);
    }

    @Test(description = "Get Movie without Basic token")
    public void getMovieInvalidReq() throws JsonProcessingException {
        RestAssured.baseURI = APIConstants.BASEURL;
        Response response = RestAssured.given().accept(contentType)
                .contentType(contentType).request().log().all().when().get(APIConstants.MOVIE_ENDPOINT).then()
                .log().all().extract().response();
        Result errResult = new Result(response.statusCode(), response.asString());
        ErrorResponse errorResponse = errResult.getErrResponse();
        Assert.assertEquals(response.getStatusCode(), 401);
        Assert.assertEquals(errorResponse.getMessage(), "Unauthorized.");
        Assert.assertEquals(errorResponse.getSuccess(), false);
    }

    @Test(description = "Get Movie with valid token")
    public void getMovie() throws IOException {
        Result result = RestCalls.get(APIConstants.MOVIE_ENDPOINT);
        Assert.assertEquals(result.getStatusCode(), 200);
        DiffUtil.compare("movies", result);
    }

    @Test(description = "Get Quotes of a Movie")
    public void getQuotes() throws IOException {
        Result response = RestCalls.get(APIConstants.MOVIE_ENDPOINT);
        GetMovie result = response.getMovies();
        Assert.assertEquals(response.getStatusCode(), 200);
        for (Movie movie : result.getDocs()) {
            Result result1 = RestCalls.get(APIConstants.getQuoteEndpoint(movie.get_id()));
            GetQuotes getQuotes = result1.getQuotes();
            if (getQuotes.getDocs().size() == 0)
                continue;
            else {
                Assert.assertEquals(result1.getStatusCode(), 200);
                DiffUtil.compare(movie.get_id(), result1);
            }
        }
    }

}
