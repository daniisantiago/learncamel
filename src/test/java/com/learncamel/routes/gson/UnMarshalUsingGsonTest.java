package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingGsonTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingGson();
    }

    @Test
    public void unMarshalUsingGsonTest(){
        Employee employee;

        String input = "{\"id\":\"1\",\"name\":\"Dilid\",\"joinDate\":\"12Jan2017\"}";

        employee = (Employee) template.requestBody("direct:unMarshalGSON", input);
        assertEquals("1", employee.getId());
    }
}
