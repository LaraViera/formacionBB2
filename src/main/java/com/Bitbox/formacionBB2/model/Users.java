package com.Bitbox.formacionBB2.model;

import lombok.Data;

import javax.persistence.*;


/**
 * @hibernate.class table="users_core" schema="erp" mutable="true"
 *                  dynamic-update="true"
 */
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

    /*/**
     * @return Long;
     * @hibernate.id unsaved-value="null" column="idUsers" type="long"
     * @hibernate.generator class="sequence"
     * @hibernate.param name="sequence" value="erp.user_id_seq"
     * @JsonManagedReference
     * @hibernate.
     */

    public Long getIdUsers() {

        return idUsers;
    }

    public void setIdUsers(Long idUsers) {

        this.idUsers = idUsers;
    }

     /*/**
     * @hibernate.property
     * column="userName"
     * type="string"
     * not-null="true"
     * unique="false"
     * @return String
     */
    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

     /* /**
     * @hibernate.property
     * column="password"
     * type="string"
     * not-null="true"
     * unique="false"
     * @return String
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    /* /**
     * @hibernate.property  column="userTypeEnum"  not-null="true"  unique="false"
     * @hibernate.type  name="com.bbsw.erp.hibernate.GenericEnumUserType"
     * @hibernate.param  name="enumClass" value="com.Bitbox.formacionBB2.userTypeEnum"
     * @hibernate.param  name="identifierMethod" value="getId"
     * @hibernate.param  name="valueOfMethod" value="getFromId"
     * @return
     */
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
