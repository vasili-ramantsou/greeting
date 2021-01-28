package com.greeting;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;

public class TestSample {

    @Test
    public void testGreetingService(){
        Assert.assertEquals(
                RestAssured.get(URI.create("http://localhost:8000/greeting/Darya?language=english")).body().asString(),
                "Hello Darya!");
    }
}
