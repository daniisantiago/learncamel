package com.learncamel.routes.bean;

import com.learncamel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Before bean is : ${body}")
                .bean(new CamelBean()) //colocando uma virgula sinaliza qual metodo da classe utilizar
                .log("After bean is : ${body}")
        .to("mock:output");
    }
}
