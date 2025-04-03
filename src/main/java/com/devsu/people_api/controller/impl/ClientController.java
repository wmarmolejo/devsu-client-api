package com.devsu.people_api.controller.impl;


import com.devsu.people_api.controller.IClientController;
import com.devsu.people_api.dto.request.ClientPatch;
import com.devsu.people_api.dto.request.ClientRequestCreateDto;

import com.devsu.people_api.dto.request.ClientRequestDto;
import com.devsu.people_api.dto.response.ClientResponseDto;
import com.devsu.people_api.enums.ErrorState;
import com.devsu.people_api.mapper.IClientMapper;
import com.devsu.people_api.service.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController implements IClientController {

    @Autowired
    private IClientService clientService;
    @Autowired
    private IClientMapper clientMapper;

    @Override
    public ResponseEntity<?> save(@RequestBody ClientRequestCreateDto clientRequest) {
        ClientResponseDto response =  clientMapper.toResponseDto(clientService.save(clientMapper.toEntityFromCreate(clientRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody ClientRequestDto clientRequest) {

        ClientResponseDto response =  clientMapper.toResponseDto(clientService.update(id, clientMapper.toEntity(clientRequest)).orElseThrow(() ->
                new RuntimeException(ErrorState.ERROR_ACTUALIZAR.getMessage())));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> patch(@PathVariable(name = "id") Long id, @RequestBody ClientPatch clientPatch) {
        ClientResponseDto response =
            clientMapper.toResponseDto(clientService.partialUpdateStatusPassword(id, clientPatch).orElseThrow(() ->
                new RuntimeException(ErrorState.ERROR_ADMIN.getMessage())));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @Override
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.delete(id));
    }

    @Override
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        ClientResponseDto response =
                clientMapper.toResponseDto(clientService.findById(id).get());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }


}
