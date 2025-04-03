package com.devsu.people_api.dto.request;


public class ClientPatch {

    private boolean status;
    private String password;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
