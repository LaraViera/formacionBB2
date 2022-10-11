package com.Bitbox.formacionBB2.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "item", schema = "erp")
public class Item implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name="item_id_seq", sequenceName = "item_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "iditem")
    Long idItem;

    @Column(name = "descriptionitem", nullable = false)
    String description;

    @Column(name = "priceitem", precision = 12, scale = 2)
    BigDecimal priceItem;

    @OneToMany(mappedBy = "itemPriceReduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "priceReductionItem")
    List<PriceReduction> priceReductionItem;

    @OneToMany(mappedBy = "stateIdItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "stateItems")
    List<StateItem> stateItems;

    @Column(name = "creationdateitem")
    LocalDate creationDateItem;

    @Column(name = "idcreatoritem")
    Long idCreatorItem;

    public Item() {
        this.creationDateItem = LocalDate.now();
    }

    public Item(Long idItem, String description, BigDecimal priceItem, List<PriceReduction> priceReductionItem, List<StateItem> stateItems, Long idCreatorItem) {
        this.idItem = idItem;
        this.description = description;
        this.priceItem = priceItem;
        this.priceReductionItem = priceReductionItem;
        this.stateItems = stateItems;
        this.creationDateItem = LocalDate.now();
        this.idCreatorItem = idCreatorItem;

    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(BigDecimal price) {
        this.priceItem = price;
    }

    public List<PriceReduction> getPriceReductionItem() {
        return priceReductionItem;
    }

    public void setPriceReductionItem(List<PriceReduction> priceReductionItem) {
        this.priceReductionItem = priceReductionItem;
    }

    public void addPriceReductionItem(List<PriceReduction> priceReductionItem) {
        this.priceReductionItem = priceReductionItem;
        priceReductionItem.forEach(priceReductionItemElement -> priceReductionItemElement.setItemPriceReduction(this));
    }

    public List<StateItem> getStateItems() {
        return stateItems;
    }

    public void setStateItems(List<StateItem> stateItems) {
        this.stateItems = stateItems;
    }

    public void addStateItem(List<StateItem> stateItem) {
        this.stateItems = stateItem;
//        stateItem.forEach(stateItem1 -> stateItem1.setIdItem(this));
    }


    public LocalDate getCreationDateItem() {
        return creationDateItem;
    }

    public void setCreationDateItem(LocalDate creationDateItem) {
        this.creationDateItem = LocalDate.now();
    }

    public Long getIdCreatorItem() {
        return idCreatorItem;
    }

    public void setIdCreatorItem(Long idCreatorItem) {

        this.idCreatorItem = idCreatorItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", description='" + description + '\'' +
                ", priceItem=" + priceItem +
                ", priceReductionItem=" + priceReductionItem +
                ", stateItems=" + stateItems +
                ", creationDateItem=" + creationDateItem +
                ", idCreatorItem=" + idCreatorItem +
                '}';
    }
}
