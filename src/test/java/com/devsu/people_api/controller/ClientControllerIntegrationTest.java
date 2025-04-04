package com.devsu.people_api.controller;

import com.devsu.people_api.dto.request.ClientPatch;
import com.devsu.people_api.dto.request.ClientRequestCreateDto;
import com.devsu.people_api.dto.request.ClientRequestDto;
import com.devsu.people_api.dto.response.ClientResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private ClientRequestCreateDto clientRequestCreateDto;
    private ClientRequestDto clientRequestDto;
    private ClientPatch clientPatch;

    @BeforeEach
    void setUp() {
    }


    @Test
    public void testFindAll() {
        // Supón que existen varios clientes
        ResponseEntity<ClientResponseDto[]> response = restTemplate.getForEntity("/api/clientes", ClientResponseDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }


}