package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FixedLengthUnMarshalDateRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalDateRoute();
    }

    @Test
    public void unMarshalFixedLengthDateTest() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);

        LocalDate expectedDate = LocalDate.of(2017,01,12);
        assertEquals(expectedDate.getYear(), employeeList.get(0).getJoinDate().getYear());

    }
}
