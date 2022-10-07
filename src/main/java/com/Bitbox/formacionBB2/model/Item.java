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
@Table(name="item", schema = "erp")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name="item_id_seq", sequenceName = "item_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idItem")
    Long idItem;

    @Column (name="description")
    String description;

    @Column(name = "price", precision = 12, scale = 2)
    BigDecimal price;

    @OneToMany(mappedBy = "idPriceReduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "priceReduction")
    List<PriceReduction> priceReduction;

    @OneToMany(mappedBy = "idStateItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "stateItem")
    List<StateItem> stateItems;

    @Column (name="creationDate")
    LocalDate creationDate;

    @Column (name="creator_id")
    Long creator_id;


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


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<PriceReduction> getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(List<PriceReduction> priceReduction) {
        this.priceReduction = priceReduction;
    }

    public List<StateItem> getStateItems() {
        return stateItems;
    }

    public void setStateItems(List<StateItem> stateItems) {
        this.stateItems = stateItems;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Long creator_id) {

        this.creator_id = creator_id;
    }


}
