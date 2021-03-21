package utils;

import io.restassured.http.ContentType;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.Properties;

public class ReadQaProps {

    public static Properties properties;
    public static ReadQaProps readQaProps;
    public static String token;

    private ReadQaProps() {
        this.properties = new Properties();
        loadFile();
        decodeToken();
    }

    public static ReadQaProps inst() {
        if (readQaProps == null)
            readQaProps = new ReadQaProps();
        return readQaProps;
    }

    public void loadFile() {
        InputStream input = null;
        try {
            File config = new File("resources/qa.conf");
            input = new FileInputStream(config);
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] encodeToken(String token) {
        return Base64.encodeBase64(token.getBytes());
    }

    public void decodeToken() {
        token = new String(Base64.decodeBase64(properties.getProperty("api.token")));
    }

    public ContentType contentType() {
        ContentType contentType = null;
        if (ReadQaProps.inst().properties.getProperty("content.type").equalsIgnoreCase("JSON"))
            contentType = ContentType.JSON;
        if (ReadQaProps.inst().properties.getProperty("content.type").equalsIgnoreCase("XML"))
            contentType = ContentType.XML;
        return contentType;
    }
}
