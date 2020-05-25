package com.learncamel.epi.multicast;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
            from("file:input?noop=true")
                    .multicast()
                    .to("file:output1", "file:output2");
    }
}
