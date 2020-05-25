package com.learncamel.routes.errorhandling;

import com.learncamel.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class OnExceptionHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        onException(RuntimeException.class).log(LoggingLevel.INFO, "Exception in Bean caught here");
        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
