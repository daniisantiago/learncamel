package com.learncamel.routes.csv;

import com.learncamel.domain.Employee1;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalRoute();
    }

    @Test
    public void csvMarshalRouteTest(){
        Employee1 employee = new Employee1();
        employee.setId("1");
        employee.setLastName("Santiago");
        employee.setFirstName("Daniella");

        Employee1 employee1 = new Employee1();
        employee1.setId("2");
        employee1.setLastName("Hart");
        employee1.setFirstName("Kevin");

        List<Employee1> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);

        template.sendBody("direct:objInput", employeeList);

        File file = new File("data/csv/output");
        assertTrue(file.isDirectory());
    }
}
