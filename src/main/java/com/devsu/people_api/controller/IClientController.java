package com.devsu.people_api.controller;

import com.devsu.people_api.dto.request.ClientPatch;
import com.devsu.people_api.dto.request.ClientRequestCreateDto;
import com.devsu.people_api.dto.request.ClientRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IClientController {

    @RequestMapping(value = "clientes",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<?> save(@RequestBody ClientRequestCreateDto clientRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "clientes/{id}",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody ClientRequestDto clientRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "clientes/{id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PATCH)
    default ResponseEntity<?> patch(@PathVariable(name = "id") Long id, @RequestBody ClientPatch clientPatch) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "clientes/{id}",
        produces = { "application/json" },
        method = RequestMethod.DELETE)
    default ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "clientes/{id}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "clientes",
        produces = { "application/json" },
        method = RequestMethod.GET)
    default ResponseEntity<?> findAll() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
