package com.learncamel.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransformRoute();
    }

    @Test
    public void transformTest(){
        String expected = "123*dilip*12JAN2017";
        String input = "123,dilip,12JAN2017";

        String actual = (String) template.requestBody("direct:transformInput", input);
        assertEquals(expected, actual);
    }

    @Test
    public void transformUsingMockTest() throws InterruptedException {
        String expected = "123*dilip*12JAN2017";
        String input = "123,dilip,12JAN2017";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:transformInput", input);
        assertMockEndpointsSatisfied();
    }
}
