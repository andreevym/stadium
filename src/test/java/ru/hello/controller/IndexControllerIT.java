package ru.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
@IntegrationTest({"${server.port=0}"})
public class IndexControllerIT extends AbstractTestNGSpringContextTests {

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;

    @BeforeClass
    public void setUp() throws Exception {
        base = new URL(new StringBuilder().append("http://localhost").append(port).append("/").toString());
        template = new TestRestTemplate();
    }

    @Test
    public void testIndex() throws Exception {
        ResponseEntity<String> responce = template.getForEntity(base.toString(), String.class);
        Assert.assertEquals(responce.getBody(), IndexController.MSG);
    }
}