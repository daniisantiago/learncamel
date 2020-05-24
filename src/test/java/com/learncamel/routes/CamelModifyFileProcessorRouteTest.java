package com.learncamel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder(){
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        String expectedValue = "123:dilip:12JAN2017\n" +
        "456:adam:12JAN2017\n";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);


        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();
    }
}
