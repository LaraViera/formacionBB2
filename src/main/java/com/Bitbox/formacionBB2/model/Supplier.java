package com.Bitbox.formacionBB2.model;

import lombok.Data;


/**
 * @hibernate.class table="supplier_core" schema="erp" mutable="true"
 *                  dynamic-update="true"
 */
@Data
public class Supplier {

    private Long idSupplier;
    private String username;
    private String password;

    /**
     * @return Long;
     * @hibernate.id unsaved-value="null" column="idSupplier" type="long"
     * @hibernate.generator class="sequence"
     * @hibernate.param name="sequence" value="erp.user_id_seq"
     * @JsonManagedReference
     * @hibernate.
     */
    public Long getIdSupplier() {

        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {

        this.idSupplier = idSupplier;
    }

    /**
     * @hibernate.property
     * column="username"
     * type="string"
     * not-null="true"
     * unique="false"
     * @return String
     */
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    /**
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

    @Override
    public String toString() {
        return "Users{" +
                "idSupplier=" + idSupplier +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


