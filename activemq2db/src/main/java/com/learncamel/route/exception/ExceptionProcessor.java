package com.learncamel.route.exception;

import org.apache.camel.Exchange;

public class ExceptionProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Actual Exception Message " + e.getMessage());
        System.out.println("Actual Exception Class " + e.getClass());

        String failedEndpoint = (String)exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint: " + failedEndpoint);

        exchange.getIn().setBody("Exception happened in the route");
    }
}
