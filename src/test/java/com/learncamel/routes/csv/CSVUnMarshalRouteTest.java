package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import com.learncamel.domain.Employee1;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CSVUnMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnMarshalRoute();
    }

    @Test
    public void csvUnMarshalRouteTest() throws InterruptedException {

        Exchange exchange =  consumer.receive("direct:output");

        Thread.sleep(5000);

        List<Employee1> employees = (List<Employee1>) exchange.getIn().getBody();
        assertEquals("dilip", employees.get(0).getFirstName());
        assertEquals("kevin", employees.get(1).getFirstName());
    }
}
