package com.Bitbox.formacionBB2.model;


import javax.persistence.Entity;


@Entity
public class Supplier {

    private Long idSupplier;
    private String username;
    private String password;

    public Long getIdSupplier() {

        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {

        this.idSupplier = idSupplier;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idSupplier=" + idSupplier +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


