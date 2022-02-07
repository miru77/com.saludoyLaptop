package com.example.com.saludoyLaptop.controller;

import com.example.com.saludoyLaptop.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }


    @Test
    void findAll() {
        ResponseEntity<Laptop> response  =
                testRestTemplate.getForEntity("/api/Laptops/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                      
                                       "marca": "Hp put test",
                                       "modelo": "g32",
                                       "price": 4322.34,
                                       "releaseDate": "2020-11-02",
                                       "online": true
                }
                """;

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}