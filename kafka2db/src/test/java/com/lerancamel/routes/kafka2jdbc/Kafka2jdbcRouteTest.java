package com.lerancamel.routes.kafka2jdbc;

import com.learncamel.routes.kafka2jdbc.Kafka2jdbcRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

public class Kafka2jdbcRouteTest extends CamelTestSupport {
    @Override
    protected CamelContext createCamelContext() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource", dataSource);

        CamelContext context = new DefaultCamelContext(registry);
        return context;
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Kafka2jdbcRoute();
    }

    private DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("admin");
        ds.setUrl(connectURI);
        return ds;
    }

    @Test
    public void kafka2DBTest(){
        ArrayList responseList = (ArrayList) consumer.receiveBody("direct:output");
        System.out.println("list: " + responseList.size());
        assertNotEquals(0, responseList.size());
    }
}
