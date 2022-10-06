package com.Bitbox.formacionBB2.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



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

    @Column (name="price")
    BigDecimal price;

    @OneToMany(mappedBy = "idPriceReduction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "priceReduction")
    List<PriceReduction> priceReduction;

    @OneToMany(mappedBy = "idStateItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "stateItem")
    List<StateItem> stateItems;

    @Column (name="creationDate")
    Date creationDate;

    @Column (name="creator_id")
    Long creator_id;  // idUser o el usuario tal cual?

   /* /**
     * @hibernate.id unsaved-value="null" column="idItem" type="long"
     * @hibernate.generator class="sequence"
     * @hibernate.param name="sequence" value="erp.item_id_seq"
     * @JsonManagedReference
     * @hibernate.
     * @return Long;
     */

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    /*/**
     * @hibernate.property
     * column="description"
     * type="string"
     * not-null="true"
     * unique="false"
     * @return String
     */

    public String getDescription() {
        return description;
    }

    /*/**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /* /**
     * @hibernate.property
     * column="price"
     * type="money"
     * not-null="false"
     * unique="false"
     * @return BigDecimal
     */

    public BigDecimal getPrice() {
        return price;
    }

    /* /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /* /**
     * @hibernate.set name="pricereduction" cascade="all-delete-orphan" lazy="true"
     *                inverse="false"
     * @hibernate.key column="idPriceReduction"
     * @JsonBackReference
     *@hibernate.one-to-many class="com.Bitbox.formacionBB2.model.PriceReduction"
     */

    public List<PriceReduction> getPriceReduction() {
        return priceReduction;
    }

   /* /**
     * @param priceReduction
     */
    public void setPriceReduction(List<PriceReduction> priceReduction) {
        this.priceReduction = priceReduction;
    }

    /*/**
     * @hibernate.set name="stateItem" cascade="all-delete-orphan" lazy="true"
     *                inverse="false"
     * @hibernate.key column="idStateItem"
     * @JsonBackReference
     *@hibernate.one-to-many class="com.Bitbox.formacionBB2.model.StateItem"
     */
    public List<StateItem> getStateItems() {
        return stateItems;
    }

   /* /**
     * @param stateItems
     */
    public void setStateItems(List<StateItem> stateItems) {
        this.stateItems = stateItems;
    }

    /*/**
     * @hibernate.property
     * column="creationdate"
     * type="timestamp"
     * not-null="true"
     * unique="false"
     * @return Date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /*/**
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /* /**
     * @hibernate.property column="creator_id" type="Long" not-null="true"
     *                     unique="false"
     * @return Long
     */
    public Long getCreator_id() {
        return creator_id;
    }

    /* /**
     * @param creator_id
     */
    public void setCreator_id(Long creator_id) {

        this.creator_id = creator_id;
    }


}
