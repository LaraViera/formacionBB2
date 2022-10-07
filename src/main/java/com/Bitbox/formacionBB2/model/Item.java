package com.Bitbox.formacionBB2.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//import javax.persistence.Id;
//import javax.persistence.Table;



/* /**
 * @hibernate.class table="item_core" schema="erp" mutable="true" dynamic-update="true"
 */
@Entity
@Table(name = "item", schema = "erp")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name="item_id_seq", sequenceName = "item_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idItem")
    Long idItem;

    @Column(name = "descriptionItem", nullable = false)
    String description;

    @Column(name = "priceItem", precision = 12, scale = 2)
    BigDecimal priceItem;

    @OneToMany(mappedBy = "idPriceReduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "priceReductionItem")
    List<PriceReduction> priceReductionItem;

    @OneToMany(mappedBy = "idStateItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "stateItem")
    List<StateItem> stateItems;

    @Column(name = "creationDateItem")
    LocalDate creationDateItem;

    @Column(name = "idCreatorItem")
    Long idCreatorItem;


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

    public List<StateItem> getStateItems() {
        return stateItems;
    }

    public void setStateItems(List<StateItem> stateItems) {
        this.stateItems = stateItems;
    }

    public LocalDate getCreationDateItem() {
        return creationDateItem;
    }

    public void setCreationDateItem(LocalDate creationDateItem) {
        this.creationDateItem = creationDateItem;
    }

    public Long getIdCreatorItem() {
        return idCreatorItem;
    }

    public void setIdCreatorItem(Long idCreatorItem) {

        this.idCreatorItem = idCreatorItem;
    }


}
