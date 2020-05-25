package com.learncamel.epi.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouterRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                    .when(header("CamelFileNameConsumed").endsWith(".html"))
                        .to("file:html")
                    .when(header("CamelFileNameConsumed").endsWith(".txt"))
                        .to("file:text")
                    .when(header("CamelFileNameConsumed").endsWith(".json"))
                        .to("file:json")
                    .otherwise()
                        .to("file:other")// se colocar o .stop() ao lado ele não sera copiado para pasta all
                    .end()//fechando o choice()
                .to("file:all"); //copiando todos os arquivos para pasta all
    }
}
