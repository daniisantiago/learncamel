package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class FixedLengthUnMarshalSalaryRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalSalaryRoute();
    }

    @Test
    public void unMarshalFixedLengthSalaryTest() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);

        List<EmployeeWithFixedLength> employeeList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertNotNull(employeeList);
        System.out.println(employeeList);

        BigDecimal salary = new BigDecimal("80000.00");
        BigDecimal salary2 = new BigDecimal("90000.00");

        assertEquals(salary, employeeList.get(0).getSalary());
        assertEquals(salary2, employeeList.get(1).getSalary());

    }
}
