package com.devsu.people_api.service;

import com.devsu.people_api.dto.request.ClientPatch;
import com.devsu.people_api.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    public Client save(Client client);
    public Optional<Client> update(Long id, Client client);
    public Optional<Client> partialUpdateStatusPassword(Long id, ClientPatch person);
    public boolean delete(Long id);
    public Optional<Client> findById(Long id);
    public List<Client> findAll();

}
