package com.Bitbox.formacionBB2.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="pricereduction", schema="erp")
public class PriceReduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricereduction_id_seq")
    @SequenceGenerator(name="pricereduction_id_seq", sequenceName = "pricereduction_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idPriceReduction")
    Long idPriceReduction;

    @Column(name = "reducedPrice", precision = 12, scale = 2)
    BigDecimal reducedPrice;

    @Column (name="startDate")
    LocalDate startDate;

    @Column (name="endDate")
    LocalDate endDate;

    @ManyToOne()
    @JoinColumn(name="item_id", referencedColumnName = "idItem", nullable = true, unique =false )
    Item item;

    public Long getIdPriceReduction() {
        return idPriceReduction;
    }

    public void setIdPriceReduction(Long idPriceReduction) {
        this.idPriceReduction = idPriceReduction;
    }

    public BigDecimal getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(BigDecimal reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
