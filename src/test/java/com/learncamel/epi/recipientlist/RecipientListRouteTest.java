package com.learncamel.epi.recipientlist;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class RecipientListRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RecipientListRoute();
    }

    @Test
    public void recipientListTest() throws InterruptedException{
        Thread.sleep(5000);

        File fileSenior = new File("xmlsenior");
        assertTrue(fileSenior.isDirectory());

        File fileJunior = new File("xmljunior");
        assertTrue(fileJunior.isDirectory());
    }
}
