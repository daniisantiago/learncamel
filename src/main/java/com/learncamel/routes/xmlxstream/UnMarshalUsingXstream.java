package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnMarshalUsingXstream extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        Map<String, String> aliases = new HashMap<>();
        aliases.put("employee", Employee.class.getName());
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class.getName());


        from("direct:xmlInput")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
