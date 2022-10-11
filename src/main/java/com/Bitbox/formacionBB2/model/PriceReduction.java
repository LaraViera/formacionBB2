package com.Bitbox.formacionBB2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
//@ToString(exclude = "itemPriceReduction")
//@EqualsAndHashCode(exclude = "itemPriceReduction")
@Table(name = "itempricereduction", schema = "erp")
public class PriceReduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricereduction_id_seq")
    @SequenceGenerator(name="pricereduction_id_seq", sequenceName = "pricereduction_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idpricereduction")
    Long idPriceReduction;

    @Column(name = "reducedprice", precision = 12, scale = 2, nullable = false)
    BigDecimal reducedPrice;

    @Column(name = "startdatepricereduction")
    LocalDate startDatePriceReduction;

    @Column(name = "enddatepricereduction")
    LocalDate endDatePriceReduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "priceReductionItem")
    @JoinColumn(name = "itempricereduction_id", referencedColumnName = "iditem", nullable = false)
    Item itemPriceReduction;


    public PriceReduction(Item itemPriceReduction, BigDecimal reducedPrice) {
        this.itemPriceReduction = itemPriceReduction;
        this.reducedPrice = reducedPrice;
        this.startDatePriceReduction = LocalDate.now();
        this.endDatePriceReduction = LocalDate.now();
    }

    public PriceReduction() {
        this.startDatePriceReduction = LocalDate.now();
        this.endDatePriceReduction = LocalDate.now();
    }

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

    @Override
    public String toString() {
        return "PriceReduction{" +
                "idPriceReduction=" + idPriceReduction +
                ", reducedPrice=" + reducedPrice +
                ", startDatePriceReduction=" + startDatePriceReduction +
                ", endDatePriceReduction=" + endDatePriceReduction +
//                ", itemPriceReduction=" + itemPriceReduction +
                '}';
    }
}
