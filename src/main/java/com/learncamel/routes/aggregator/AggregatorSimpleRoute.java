package com.learncamel.routes.aggregator;

import com.learncamel.aggregate.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorSimpleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received Message is ${body} and key{header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy())
                .completionSize(3)
                .log("Aggregated Message is ${body} and key{header.aggregatorId}")
                .to("mock:output");
    }
}
