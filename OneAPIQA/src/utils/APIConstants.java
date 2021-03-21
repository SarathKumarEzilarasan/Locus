package utils;

public class APIConstants {

    public static final String BASEURL = ReadQaProps.inst().properties.getProperty("base.uri");
    public static final String QUOTE_ENDPOINT = "quote";
    public static final String BOOK_ENDPOINT = "book";
    public static final String MOVIE_ENDPOINT = "movie";

    public static String getQuoteEndpoint(String movid_ID) {
        return MOVIE_ENDPOINT + "/" + movid_ID + "/" + QUOTE_ENDPOINT;
    }
}
