package com.learncamel.routes.csv;

import com.learncamel.domain.Employee1;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVUnMarshalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(Employee1.class);
        from("file:data/csv/input?fileName=file.txt&noop=true")
                .unmarshal(bindy)
                .log("UnMarshaled Message is ${body}")
                .to("direct:output");
    }
}
