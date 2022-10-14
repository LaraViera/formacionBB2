package com.Bitbox.formacionBB2.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "supplier", schema = "erp")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @SequenceGenerator(name = "supplier_id_seq", sequenceName = "supplier_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idsupplier")
    private Long idSupplier;

    @Column(name = "namesupplier", nullable = false, unique = true)
    private String name;


    @Column(name = "countrysupplier", nullable = false)
    private String country;

    @ManyToMany(mappedBy = "suppliersItem")
    private Set<Item> itemsSupplier;



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

    public Set<Item> getItemsSupplier() {
        return itemsSupplier;
    }

    public void setItemsSupplier(Set<Item> itemsSupplier) {
        this.itemsSupplier = itemsSupplier;
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


