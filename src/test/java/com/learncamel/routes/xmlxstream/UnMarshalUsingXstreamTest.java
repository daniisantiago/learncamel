package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXstreamTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingXstream();
    }

    @Test
    public void UnMarshalXstreamTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setJoinDate("12Jan2017");
        employee.setName("Daniel");
        employee.setId("123");

        String xmlInput = "<employee><id>123</id><name>Daniel</name><joinDate>12Jan2017</joinDate></employee>";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(employee.toString());
        template.sendBody("direct:xmlInput", xmlInput);
        assertMockEndpointsSatisfied();
    }
}
