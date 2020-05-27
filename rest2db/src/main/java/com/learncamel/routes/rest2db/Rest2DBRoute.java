package com.learncamel.routes.rest2db;

import com.learncamel.routes.jdbc.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class Rest2DBRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:learnTimer?period=10s")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("https://restcountries.eu/rest/v2/alpha/us"))
                .to("https://restcountries.eu/rest/v2/alpha/us").convertBodyTo(String.class)
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from country_capital?dataSource=myDataSource")
        .to("direct:dbOutput");
    }
}
