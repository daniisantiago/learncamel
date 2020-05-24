package com.learncamel.file;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFilesCamelRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesCamelRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {
        //tempo para o camel copiar todos os arquivos
        Thread.sleep(5000);
        File file = new File("data/output");

        //testando se existe o diretorio output
        assertTrue(file.isDirectory());

        //testanto se existe 2 arquivos dentro do output
        assertEquals(2, file.listFiles().length);
    }
}
