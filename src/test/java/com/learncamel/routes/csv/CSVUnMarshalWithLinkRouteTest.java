package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CSVUnMarshalWithLinkRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnMarshalWithLinkRoute();
    }

    @Test
    public void unMarshalCSVLinkTest(){
        Exchange exchange = consumer.receive("direct:output");

        EmployeeWithAddress employeeWithAddress = (EmployeeWithAddress) exchange.getIn().getBody();
        System.out.println(employeeWithAddress);

        assertEquals("BR", employeeWithAddress.getAddress().getCountry());
    }
}
