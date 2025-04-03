package com.devsu.people_api.service;

import com.devsu.people_api.dto.request.ClientPatch;
import com.devsu.people_api.model.Client;
import com.devsu.people_api.repository.ClientRepository;
import com.devsu.people_api.service.impl.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
        client.setId(1L);
        client.setName("Juan Pérez");
        client.setAddress("Calle 123");
        client.setGender("M");
        client.setTelephone("123456789");
        client.setAge(30);
        client.setPassword("password123");
        client.setStatus(true);
    }

    @Test
    void testSave() {
        when(clientRepository.save(client)).thenReturn(client);

        Client savedClient = clientService.save(client);

        assertNotNull(savedClient);
        assertEquals("Juan Pérez", savedClient.getName());
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testUpdate() {
        Client updatedClient = new Client();
        updatedClient.setName("Juan Actualizado");
        updatedClient.setAddress("Nueva Dirección");
        updatedClient.setGender("M");
        updatedClient.setTelephone("987654321");
        updatedClient.setAge(31);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(updatedClient);

        Optional<Client> result = clientService.update(1L, updatedClient);

        assertTrue(result.isPresent());
        assertEquals("Juan Actualizado", result.get().getName());
        verify(clientRepository, times(1)).findById(1L);
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    void testPartialUpdateStatusPassword() {
        ClientPatch patch = new ClientPatch();
        patch.setPassword("newPassword");
        patch.setStatus(false);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        Optional<Client> result = clientService.partialUpdateStatusPassword(1L, patch);

        assertTrue(result.isPresent());
        assertEquals("newPassword", result.get().getPassword());
        assertFalse(result.get().isStatus());
        verify(clientRepository, times(1)).findById(1L);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testDelete() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        doNothing().when(clientRepository).delete(client);

        boolean result = clientService.delete(1L);

        assertTrue(result);
        verify(clientRepository, times(1)).findById(1L);
        verify(clientRepository, times(1)).delete(client);
    }

    @Test
    void testFindById() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Juan Pérez", result.get().getName());
        verify(clientRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Client> clients = Arrays.asList(client, new Client());
        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.findAll();

        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        verify(clientRepository, times(1)).findAll();
    }
}