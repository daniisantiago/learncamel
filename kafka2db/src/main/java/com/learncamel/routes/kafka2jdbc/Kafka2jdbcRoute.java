package com.learncamel.routes.kafka2jdbc;

import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

public class Kafka2jdbcRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //onException(PSQLException.class).handled(true).log("Exception while inserting messages.").process(new ExceptionProcessor());

        from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest")
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from messages?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true")
        .to("direct:output");
    }
}
