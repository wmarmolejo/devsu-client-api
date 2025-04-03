package com.devsu.people_api.enums;

public enum ErrorState {

    ERROR_ACTUALIZAR("Error update client"),
    ClIENT_NOT_FOUND("Client not Found"),
    INTERNAL_ERROR("Internal Server Error"),
    ERROR_ADMIN("Error de administrador");
    private final String message;

    ErrorState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
