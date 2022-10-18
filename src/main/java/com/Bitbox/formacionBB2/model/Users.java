/*
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
    @Column(name="idUser")
    Long idUsers;

    @Column(name = "user_name", unique = false, nullable = false)
    String username;

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

    */
/*public RoleEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(RoleEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }*//*


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
*/

package com.Bitbox.formacionBB2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS", schema = "erp")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idUser")
    Long idUsers;

    @NotBlank
    @Size(max = 20)
    @Column(name = "user_name", unique = true, nullable = false)
    String username;

    @NotBlank
    @Size(max = 50)
    @Column(name = "user_email", unique = true, nullable = false)
    String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "user_password", nullable = false)
    String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    Set<Role> roles = new HashSet<>();

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

    /*public RoleEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(RoleEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUsers=" + idUsers +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
