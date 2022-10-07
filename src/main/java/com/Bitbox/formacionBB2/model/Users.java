package com.Bitbox.formacionBB2.model;

import javax.persistence.*;

@Entity
@Table(name="users", schema = "erp")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idUser")
    Long idUsers;

    @Column(name="userName", unique = false)
    String userName;

    @Column(name="password", unique = false)
    String password;

    @Column(name="userTypeEnum")
    @Enumerated(EnumType.STRING)
    UserTypeEnum userTypeEnum;


    public Long getIdUsers() {

        return idUsers;
    }

    public void setIdUsers(Long idUsers) {

        this.idUsers = idUsers;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUsers=" + idUsers +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userTypeEnum=" + userTypeEnum +
                '}';
    }
}
