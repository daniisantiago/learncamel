package com.learncamel.routes.process;

import com.learncamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input1?noop=true")
                .log("Read file is ${body} and headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt")
        .to("mock:output");
    }
}
