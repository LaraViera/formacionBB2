package com.Bitbox.formacionBB2.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "item", schema = "erp")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "iditem")
    Long idItem;

    @Column(name = "itemcode", nullable = false, unique = true)
    Long itemCode;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "priceitem", precision = 12, scale = 2)
    BigDecimal priceItem;

    @OneToMany(mappedBy = "stateIdItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "stateItem")
    List<StateItem> stateItem;

    @OneToMany(mappedBy = "itemPriceReduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "priceReductionItem")
    List<PriceReduction> priceReductionItem;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "item_supplier", joinColumns = {@JoinColumn(name = "item_id")}, inverseJoinColumns = {@JoinColumn(name = "supplier_id")}, schema = "erp")
    Set<Supplier> suppliersItem;

    @Column(name = "creationdateitem")
    LocalDate creationDateItem;

    @Column(name = "idcreatoritem")
    Long idCreatorItem;

    public Item() {
        this.creationDateItem = LocalDate.now();
    }

    public Item(Long itemCode, String description, BigDecimal priceItem, List<StateItem> stateItem) {
        this.itemCode = itemCode;
        this.description = description;
        this.priceItem = priceItem;
        this.stateItem = stateItem;
    }

    public Item(Long itemCode, String description, BigDecimal priceItem) {
        this.itemCode = itemCode;
        this.description = description;
        this.priceItem = priceItem;
    }

    public Item(Long idItem, String description, Long itemCode, BigDecimal priceItem, List<PriceReduction> priceReductionItem, List<StateItem> stateItem, Long idCreatorItem, Set<Supplier> suppliersItem) {
        this.idItem = idItem;
        this.itemCode = itemCode;
        this.description = description;
        this.priceItem = priceItem;
        this.priceReductionItem = priceReductionItem;
        this.stateItem = stateItem;
        this.creationDateItem = LocalDate.now();
        this.idCreatorItem = idCreatorItem;
        this.suppliersItem = suppliersItem;
    }


    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
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

    public void addPriceReductionItem(PriceReduction priceReductionItem) {
//    public void addPriceReductionItem(List<PriceReduction> priceReductionItem) {
        this.priceReductionItem.add(priceReductionItem);

        priceReductionItem.setItemPriceReduction(this);
    }

    public List<StateItem> getStateItem() {
        return stateItem;
    }

    public void setStateItem(List<StateItem> stateItem) {
        this.stateItem = stateItem;
    }

    public void addStateItem(StateItem stateItem) {
        this.stateItem.add(stateItem);
        stateItem.setIdItem(this);
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

    public Set<Supplier> getSuppliersItem() {
        return suppliersItem;
    }

    public void setSuppliersItem(Set<Supplier> suppliersItem) {
        this.suppliersItem = suppliersItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", itemCode=" + itemCode +
                ", description='" + description + '\'' +
                ", priceItem=" + priceItem +
                ", priceReductionItem=" + priceReductionItem +
                ", stateItem=" + stateItem +
                ", creationDateItem=" + creationDateItem +
                ", idCreatorItem=" + idCreatorItem +
                ", suppliersItem=" + suppliersItem +
                '}';
    }
}
