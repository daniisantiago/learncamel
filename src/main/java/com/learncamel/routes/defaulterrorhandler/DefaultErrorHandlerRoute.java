package com.learncamel.routes.defaulterrorhandler;

import com.learncamel.bean.DataModifier;
import org.apache.camel.builder.RouteBuilder;

public class DefaultErrorHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //errorHandler(defaultErrorHandler());

        from("direct:exception")
                .bean(new DataModifier(), "map")
                .to("log:?level=INFO&showBody=true")
                .to("mock:errorqueue");
    }
}
