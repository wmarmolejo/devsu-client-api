package com.devsu.people_api.service.impl;

import com.devsu.people_api.dto.request.ClientPatch;
import com.devsu.people_api.enums.ErrorState;
import com.devsu.people_api.model.Client;
import com.devsu.people_api.repository.ClientRepository;
import com.devsu.people_api.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public Optional<Client> update(Long id, Client client) {
        Client clientDB = findById(id).get();
        clientDB.setName(client.getName());
        clientDB.setAddress(client.getAddress());
        clientDB.setGender(client.getGender());
        clientDB.setTelephone(client.getTelephone());
        clientDB.setAge(client.getAge());
        return Optional.of(clientRepository.save(clientDB));
    }

    @Transactional
    @Override
    public Optional<Client> partialUpdateStatusPassword(Long id, ClientPatch client) {
        return clientRepository.findById(id).map(existingPerson -> {
            if (client.getPassword() != null) {
                existingPerson.setPassword(client.getPassword());
            }
                existingPerson.setStatus(client.isStatus());

            return clientRepository.save(existingPerson);
        });
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        Client client=findById(id).get();
        clientRepository.delete(client);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> clientDB = clientRepository.findById(id);
        clientDB.orElseThrow(() -> new RuntimeException(ErrorState.ClIENT_NOT_FOUND.getMessage()));

        return clientDB;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> findAll() {
         return (List<Client>) clientRepository.findAll();
    }
}
