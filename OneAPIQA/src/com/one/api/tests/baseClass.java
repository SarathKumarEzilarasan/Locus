package com.one.api.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import utils.ReadQaProps;

public class baseClass {
    ContentType contentType;

    @BeforeClass
    public void setUp() {
        contentType = ReadQaProps.inst().contentType();
    }

}
