package com.Bitbox.formacionBB2.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="pricereduction", schema="erp")
public class PriceReduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricereduction_id_seq")
    @SequenceGenerator(name="pricereduction_id_seq", sequenceName = "pricereduction_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idPriceReduction")
    Long idPriceReduction;

    @Column (name="reducedPrice")
    BigDecimal reducedPrice;

    @Column (name="startDate")
    Date startDate;

    @Column (name="endDate")
    Date endDate;

    @ManyToOne()
    @JoinColumn(name="item_id", referencedColumnName = "idItem", nullable = true, unique =false )
    Item item;

    /* /**
     * @return Long;
     * @hibernate.id unsaved-value="null" column="idPriceReduction" type="long"
     * @hibernate.generator class="sequence"
     * @hibernate.param name="sequence" value="erp.pricereduction_id_seq"
     * @JsonManagedReference
     * @hibernate.
     */
    public Long getIdPriceReduction() {
        return idPriceReduction;
    }

    public void setIdPriceReduction(Long idPriceReduction) {
        this.idPriceReduction = idPriceReduction;
    }

    /*/**
     * @hibernate.property
     * column="reducedPrice"
     * type="money"
     * not-null="false"
     * unique="false"
     * @return BigDecimal
     */
    public BigDecimal getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(BigDecimal reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    /*/**
     * @hibernate.property
     * column="startDate"
     * type="timestamp"
     * not-null="true"
     * unique="false"
     * @return Date
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /*/**
     * @hibernate.property
     * column="endDate"
     * type="timestamp"
     * not-null="true"
     * unique="false"
     * @return Date
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
