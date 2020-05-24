package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthUnMarshalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);
        from("file:data/fixedLength/input?fileName=fixedLength.txt&noop=true")
                .unmarshal(bindy)
                .log("UnMarshaled message is: ${body}")
                .to("direct:output");
    }
}
