package com.learncamel.epi.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBasedRouterRouteTest extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new ContentBasedRouterRoute();
    }

    @Test
    public void contentBasedRouterTest() throws InterruptedException{
        Thread.sleep(5000);
        File file = new File("html");
        assertTrue(file.isDirectory());

        File file1 = new File("text");
        assertTrue(file1.isDirectory());

        File file2 = new File("json");
        assertTrue(file2.isDirectory());

        File file3 = new File("other");
        assertTrue(file3.isDirectory());

        File fileAll = new File("all");
        assertTrue(fileAll.isDirectory());

    }
}
