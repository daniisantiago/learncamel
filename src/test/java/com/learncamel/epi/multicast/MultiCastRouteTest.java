package com.learncamel.epi.multicast;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class MultiCastRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MultiCastRoute();
    }

    @Test
    public void multicastRouteTest() throws InterruptedException{
        Thread.sleep(5000);
        File file = new File("output1");
        assertTrue(file.isDirectory());

        File file1 = new File("output2");
        assertTrue(file1.isDirectory());
    }
}
