package com.learncamel.routes.aggregator;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class AggregatorWithGroupedExchangeRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:grpAggregator")
                .log("Received Message is ${body} and headers are ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                .completionSize(3)
                .log("Aggregated Message is ${body}")
                .to("mock:output");
    }
}
