package com.Bitbox.formacionBB2.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ItemDto {
    Long idCreatorItem;
    Boolean stateItems;
    //    List<StateItem> stateItems;
    LocalDate creationDateItem;
    String description;
    Long idItem;
    BigDecimal priceItem;
//    List<PriceReduction> priceReductions;


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

    //    public List<StateItem> getStateItems() {
//        return stateItems;
//    }
//
//    public void setStateItems(List<StateItem> stateItems) {
//        this.stateItems = stateItems;
//    }
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

//    public List<PriceReduction> getPriceReductions() {
//        return priceReductions;
//    }
//
//    public void setPriceReductions(List<PriceReduction> priceReductions) {
//        this.priceReductions = priceReductions;
//    }
}
