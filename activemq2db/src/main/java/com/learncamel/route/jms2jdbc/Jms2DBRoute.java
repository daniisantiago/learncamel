package com.learncamel.route.jms2jdbc;

import com.learncamel.processor.InsertProcessor;
import com.learncamel.route.exception.ExceptionProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

public class Jms2DBRoute extends RouteBuilder {
    public void configure() throws Exception {

        onException(PSQLException.class).handled(true).log("Exception while inserting messages.").process(new ExceptionProcessor());

        from("activemq:queue:testQueue")
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from messages?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true");
               //.to("direct:output");
    }
}
