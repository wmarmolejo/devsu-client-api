package com.devsu.people_api.mapper;

import com.devsu.people_api.dto.request.ClientRequestCreateDto;
import com.devsu.people_api.dto.request.ClientRequestDto;
import com.devsu.people_api.dto.response.ClientResponseDto;
import com.devsu.people_api.model.Client;

public interface IClientMapper {

    Client toEntity(ClientRequestDto dto);

    Client toEntityFromCreate(ClientRequestCreateDto dto);

    ClientResponseDto toResponseDto(Client client);

}
