package com.learncamel.route.jms;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class JmsReadRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new JmsReadRoute();
    }

    @Test
    public void readMessageFromActiveMQ() throws InterruptedException{

        String expected = "123";
        String response = consumer.receiveBody("direct:readQueue", String.class);
        System.out.println("The response is : " + response);
        assertEquals(expected,response);
    }
}
