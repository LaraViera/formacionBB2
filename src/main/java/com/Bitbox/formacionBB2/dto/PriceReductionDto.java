package com.Bitbox.formacionBB2.dto;

import com.Bitbox.formacionBB2.model.Item;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PriceReductionDto {

    Long idPriceReduction;
    BigDecimal reducedPrice;
    LocalDate startDatePriceReduction;
    LocalDate endDatePriceReduction;
    Boolean statePriceReduction;
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

    public Boolean getStatePriceReduction() {
        return statePriceReduction;
    }

    public void setStatePriceReduction(Boolean statePriceReduction) {
        this.statePriceReduction = statePriceReduction;
    }

    public Item getItemPriceReduction() {
        return itemPriceReduction;
    }

    public void setItemPriceReduction(Item itemPriceReduction) {
        this.itemPriceReduction = itemPriceReduction;
    }
}
