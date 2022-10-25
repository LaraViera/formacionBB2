package com.Bitbox.formacionBB2.dto;

import java.util.Set;

public class SupplierDto {
    Long idSupplier;
    String name;
    String country;
    Set<ItemDto> itemsSupplier;

    public SupplierDto() {
    }

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

    public Set<ItemDto> getItemsSupplier() {
        return itemsSupplier;
    }

    public void setItemsSupplier(Set<ItemDto> itemsSupplier) {
        this.itemsSupplier = itemsSupplier;
    }
}
