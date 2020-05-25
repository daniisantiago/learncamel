package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class FixedLengthUnMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalRoute();
    }

    @Test
    public void unMarshalFixedLenghtTest() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");
        List<EmployeeWithFixedLength> employeeWithFixedLengthsList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        //Thread.sleep(5000);

        assertNotNull(employeeWithFixedLengthsList);
        assertEquals("danii", employeeWithFixedLengthsList.get(0).getName());
        assertEquals("Engineer", employeeWithFixedLengthsList.get(1).getRole());
    }
}
