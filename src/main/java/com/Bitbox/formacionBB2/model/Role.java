package com.Bitbox.formacionBB2.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idrole")
    Long idRole;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    RoleEnum nameRole;

    public Role() {
    }

    public Role(RoleEnum roleEnum) {
        this.nameRole = roleEnum;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public RoleEnum getNameRole() {
        return nameRole;
    }

    public void setNameRole(RoleEnum nameRole) {
        this.nameRole = nameRole;
    }
}
