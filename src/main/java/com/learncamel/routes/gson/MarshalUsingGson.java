package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder
{
    @Override
    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
        from("direct:marshalGSON")
                .log("Before Marshaling Object is : ${body}")
                .marshal(gsonDataFormat)
                .log("Marshaled Object is : ${body}");
    }
}
