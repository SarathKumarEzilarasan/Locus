package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Result {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static String body;
    int statusCode;

    public Result(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public models.Book getBook() throws JsonProcessingException {
        return objectMapper.readValue(body, models.Book.class);
    }

    public models.GetBooks getBooks() throws JsonProcessingException {
        return objectMapper.readValue(body, models.GetBooks.class);
    }

    public models.ErrorResponse getErrResponse() throws JsonProcessingException {
        return objectMapper.readValue(body, models.ErrorResponse.class);
    }

    public models.GetMovie getMovies() throws JsonProcessingException {
        return objectMapper.readValue(body, models.GetMovie.class);
    }

    public models.GetQuotes getQuotes() throws JsonProcessingException {
        return objectMapper.readValue(body, models.GetQuotes.class);
    }

}
