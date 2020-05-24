package com.learncamel.direct;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SimpleMockRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SimpleMockRoute();
    }

    @Test
    public void sampleMockRouteTest() throws InterruptedException {

        String input = "Hello";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(input);

        template.sendBody("direct:sampleInput", "Hello");
        assertMockEndpointsSatisfied();
    }
}
