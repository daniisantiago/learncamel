package com.learncamel.routes.rest;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RestRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RestRoute();
    }

    @Test
    public void restCall_us(){
        String response = template.requestBody("direct:restCall", "US", String.class);
        System.out.println("response: " + response);
        assertNotNull(response);
    }
}
