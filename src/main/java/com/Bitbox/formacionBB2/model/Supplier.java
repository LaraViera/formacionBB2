package com.Bitbox.formacionBB2.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SupplierController", schema = "erp")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @SequenceGenerator(name = "supplier_id_seq", sequenceName = "supplier_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idSupplier")
    private Long idSupplier;

    @Column(name = "nameSupplier")
    private String name;


    @Column(name = "countrySupplier")
    private String country;

    public Long getIdSupplier() {

        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {

        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "SupplierController{" +
                "idSupplier=" + idSupplier +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


