package com.learncamel.routes.csv;

import com.learncamel.domain.Address;
import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CSVMarshalWithLinkRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalWithLinkRoute();
    }

    @Test
    public void marshalCSVLinkTest() throws InterruptedException {
        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress();
        employeeWithAddress.setId("1");
        employeeWithAddress.setLastName("Santiago");
        employeeWithAddress.setFirstName("Daniella");

        Address address = new Address();
        address.setAddressLine("Rua Jose Seabra Batista");
        address.setCity("Aracaju");
        address.setCountry("BR");
        address.setState("Sergipe");
        address.setZip("49025-750");
        employeeWithAddress.setAddress(address);

        template.sendBody("direct:objInput", employeeWithAddress);

        Thread.sleep(5000);
        File file = new File("data/csv/output/output-with-address.txt");
        assertTrue(file.exists());
    }
}
