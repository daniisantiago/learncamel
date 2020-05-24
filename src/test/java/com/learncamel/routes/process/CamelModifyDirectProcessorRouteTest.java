package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest(){
        String expected = "123:dilip:12JAN2017";
        String input = "123,dilip,12JAN2017";

        String output = (String) template.requestBody("direct:processorInput", input);
        assertEquals(expected, output);
    }

    @Test
    public void processorDirectUsingMockTest() throws InterruptedException {
        String expected = "123:dilip:12JAN2017";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        String input = "123,dilip,12JAN2017";
        template.sendBody("direct:processorInput", input);
        assertMockEndpointsSatisfied();
    }
}
