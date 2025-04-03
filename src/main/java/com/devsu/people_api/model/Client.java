package com.devsu.people_api.model;

import jakarta.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name="id_client")
public class Client extends Person {
    @Column(name = "password", length=18, nullable = false)
    private String password;
    @Column(name = "status", nullable = false)
    private boolean status;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
