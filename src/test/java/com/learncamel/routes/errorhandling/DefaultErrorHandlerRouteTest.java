package com.learncamel.routes.errorhandling;

import com.learncamel.routes.defaulterrorhandler.DefaultErrorHandlerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck() throws InterruptedException {

        String expectedOuput = "123*dilip*12JAN2017";
        String input=null;

        String output = template.requestBody("direct:exception", input, String.class);
        assertEquals(expectedOuput, output);
    }
}
