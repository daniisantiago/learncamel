package com.learncamel.routes.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorSimpleRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorSimpleRoute();
    }

    @Test
    public void aggregatorSimpleTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", "2");
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", "1");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregatorMultipleTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:output");
        List<String> expectedValueList = new ArrayList<>();
        expectedValueList.add("123");
        expectedValueList.add("567");

        mock.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", "2");
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "5", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "6", "aggregatorId", "1");
        template.sendBodyAndHeader("direct:simpleAggregator", "7", "aggregatorId", "1");

        assertMockEndpointsSatisfied();
    }
}
