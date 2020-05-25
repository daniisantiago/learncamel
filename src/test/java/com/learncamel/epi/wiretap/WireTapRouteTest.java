package com.learncamel.epi.wiretap;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class WireTapRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new WireTapRoute();
    }

    @Test
    public void wireTapRouteTest() throws InterruptedException{
        Thread.sleep(5000);
        File file = new File("all");
        assertTrue(file.isDirectory());

        File fileDebug = new File("debug");
        assertTrue(fileDebug.isDirectory());

    }
}
