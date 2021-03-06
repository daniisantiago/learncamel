package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FixedLengthUnMarshalAgeRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalAgeRoute();
    }

    @Test
    public void unMarshalFixedLengthAgeTest() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);

        LocalDate expectedDate = LocalDate.of(2017,01,12);
        assertEquals(expectedDate.getYear(), employeeList.get(0).getJoinDate().getYear());
        assertEquals(28, employeeList.get(0).getAge());
        assertEquals(30, employeeList.get(1).getAge());
    }
}
