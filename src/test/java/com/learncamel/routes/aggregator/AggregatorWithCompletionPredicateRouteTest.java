package com.learncamel.routes.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorWithCompletionPredicateRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorWithCompletionPredicateRoute();
    }

    @Test
    public void aggregatorPredicateTest() throws InterruptedException {
        String orderCreate = "12345,samsung-phone,order-created";
        String orderConfirm = "12345,samsung-phone,order-confirm";

        String expectedOutput = orderCreate.concat(":").concat(orderConfirm);

        MockEndpoint mock = getMockEndpoint("mock:output");

        template.sendBodyAndHeader("direct:completionPredicate", orderCreate, "aggregatorId", 12345);
        template.sendBodyAndHeader("direct:completionPredicate", orderConfirm, "aggregatorId", 12345);

        assertMockEndpointsSatisfied();
    }
}
