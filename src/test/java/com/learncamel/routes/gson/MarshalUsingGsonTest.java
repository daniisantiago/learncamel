package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGsonTest(){
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Dilid");
        employee.setJoinDate("12Jan2017");

        String expectedJason = "{\"id\":\"1\",\"name\":\"Dilid\",\"joinDate\":\"12Jan2017\"}";

        String employeeJson = template.requestBody("direct:marshalGSON", employee, String.class);
        assertEquals(expectedJason, employeeJson);
    }
}
