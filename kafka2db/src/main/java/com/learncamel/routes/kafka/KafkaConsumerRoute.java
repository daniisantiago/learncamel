package com.learncamel.routes.kafka;

import org.apache.camel.builder.RouteBuilder;

public class KafkaConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:localhost:9092?topic=my-first-topic&groupId=group1&consumersCount=1&autoOffsetReset=earliest")
                .log("${body}")
                .to("direct:readFromKafka");
    }
}
