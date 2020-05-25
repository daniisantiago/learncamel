package com.learncamel.routes.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class AggregatorWithGroupedExchangeRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorWithGroupedExchangeRoute();
    }

    @Test
    public void aggregatorGroupExchangeTest() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:grpAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:grpAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:grpAggregator", "3", "aggregatorId", 1);

        assertMockEndpointsSatisfied();

        Exchange exchangeList = mock.getExchanges().get(0);
        List<Exchange> list = (List<Exchange>) exchangeList.getProperty(Exchange.GROUPED_EXCHANGE);
        for(Exchange exchange : list){
            System.out.println("Exchange Body is: " + exchange.getIn().getBody());
        }
    }
}
