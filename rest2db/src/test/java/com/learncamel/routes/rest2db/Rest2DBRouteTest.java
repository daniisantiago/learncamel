package com.learncamel.routes.rest2db;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

public class Rest2DBRouteTest extends CamelTestSupport {
    @Override
    public CamelContext createCamelContext() {

        String url = "jdbc:postgresql://localhost:5432/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource", dataSource);

        CamelContext context = new DefaultCamelContext(registry);
        return context;
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Rest2DBRoute();
    }

    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("admin");
        ds.setUrl(connectURI);
        return ds;
    }

    @Test
    public void rest2dbTest(){
        ArrayList responseList = consumer.receiveBody("direct:dbOutput", ArrayList.class);
        System.out.println("responseList: " + responseList.size());
        assertNotEquals(0, responseList.size());
    }
}
