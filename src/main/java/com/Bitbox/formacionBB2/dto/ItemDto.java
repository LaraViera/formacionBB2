package com.Bitbox.formacionBB2.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class ItemDto {
    Long idCreatorItem;
    Boolean stateItems;
    Long itemCode;
    //    List<StateItem> stateItems;
    LocalDate creationDateItem;
    String description;
    Long idItem;
    BigDecimal priceItem;
    List<PriceReductionDto> priceReductions;
    Set<SupplierDto> suppliersItem;



    public Long getIdCreatorItem() {
        return idCreatorItem;
    }

    public void setIdCreatorItem(Long idCreatorItem) {
        this.idCreatorItem = idCreatorItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public Boolean getStateItems() {
        return stateItems;
    }

    public void setStateItems(Boolean stateItems) {
        this.stateItems = stateItems;
    }

    public LocalDate getCreationDateItem() {
        return creationDateItem;
    }

    public void setCreationDateItem(LocalDate creationDateItem) {
        this.creationDateItem = creationDateItem;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public BigDecimal getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(BigDecimal price) {
        this.priceItem = price;
    }


    // Price Reduction
    public List<PriceReductionDto> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(List<PriceReductionDto> priceReductions) {
        this.priceReductions = priceReductions;
    }

    // Suppliers

    public Set<SupplierDto> getSuppliersItem() {
        return suppliersItem;
    }

    public void setSuppliersItem(Set<SupplierDto> suppliersItem) {
        this.suppliersItem = suppliersItem;
    }
}
