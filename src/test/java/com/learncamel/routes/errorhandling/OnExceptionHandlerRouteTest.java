package com.learncamel.routes.errorhandling;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void onExceptionCheck(){
        String request = null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is: " + response);
    }
}
