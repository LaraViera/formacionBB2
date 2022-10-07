package com.Bitbox.formacionBB2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS", schema = "erp")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, schema = "erp")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idUser")
    Long idUsers;

    //@Column(name="user_name")
    @Column(name = "user_name", unique = false, nullable = false)
    String username;

    //@Column(name="password")
    @Column(name = "password", unique = false, nullable = false)
    String password;


    public Long getIdUsers() {

        return idUsers;
    }

    public void setIdUsers(Long idUsers) {

        this.idUsers = idUsers;
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

    /*public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }*/

    @Override
    public String toString() {
        return "Users{" +
                "idUsers=" + idUsers +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                // ", userTypeEnum=" + userTypeEnum +
                '}';
    }
}
