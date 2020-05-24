package com.learncamel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SimpleMockRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
