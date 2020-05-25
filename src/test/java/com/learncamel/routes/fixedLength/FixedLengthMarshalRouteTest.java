package com.learncamel.routes.fixedLength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedLengthMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthMarshalRoute();
    }

    @Test
    public void marshalFixedLength() throws InterruptedException {
        EmployeeWithFixedLength employee = new EmployeeWithFixedLength();
        employee.setId(1);
        employee.setRole("Engineer");
        employee.setName("Dilip");
        employee.setAge(25);
        employee.setJoinDate(LocalDate.now());
        employee.setSalary(new BigDecimal("10000.00"));

        template.sendBody("direct:input", employee);

        Thread.sleep(2000);
        File file = new File("data/fixedLength/output");
        assertTrue(file.isDirectory());
    }
}
