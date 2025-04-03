package com.devsu.people_api.mapper.impl;

import com.devsu.people_api.dto.request.ClientRequestCreateDto;
import com.devsu.people_api.dto.request.ClientRequestDto;
import com.devsu.people_api.dto.response.ClientResponseDto;
import com.devsu.people_api.mapper.IClientMapper;
import com.devsu.people_api.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements IClientMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Client toEntity(ClientRequestDto dto){
        return modelMapper.map(dto, Client.class);
    }

    public Client toEntityFromCreate(ClientRequestCreateDto dto){
        return modelMapper.map(dto, Client.class);
    }

    public ClientResponseDto toResponseDto(Client client){
        return modelMapper.map(client, ClientResponseDto.class);
    }


}
