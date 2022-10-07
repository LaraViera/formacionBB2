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

    @Column(name = "startDatePriceReduction")
    LocalDate startDatePriceReduction;

    @Column(name = "endDatePriceReduction")
    LocalDate endDatePriceReduction;

    @ManyToOne()
    @JoinColumn(name="item_id", referencedColumnName = "idItem", nullable = true, unique =false )
    Item itemPriceReduction;

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

    public LocalDate getStartDatePriceReduction() {
        return startDatePriceReduction;
    }

    public void setStartDatePriceReduction(LocalDate startDatePriceReduction) {
        this.startDatePriceReduction = startDatePriceReduction;
    }

    public LocalDate getEndDatePriceReduction() {
        return endDatePriceReduction;
    }

    public void setEndDatePriceReduction(LocalDate endDatePriceReduction) {
        this.endDatePriceReduction = endDatePriceReduction;
    }


    public Item getItemPriceReduction() {
        return itemPriceReduction;
    }

    public void setItemPriceReduction(Item itemPriceReduction) {
        this.itemPriceReduction = itemPriceReduction;
    }
}
