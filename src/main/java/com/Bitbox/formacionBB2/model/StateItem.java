package com.Bitbox.formacionBB2.model;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "stateitem", schema="erp")
public class StateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stateitem_id_seq")
    @SequenceGenerator(name="stateitem_id_seq", sequenceName = "stateitem_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idStateItem")
    Long idStateItem;

    @Column (name="updateStateItem")
    LocalDate updateStateItem;

    @ManyToOne()
    @JoinColumn(name="item_id")
    Item idItem;

    @Column (name="active")
    Boolean active;

    @Column (name="description")
    String description;


    public StateItem(Long idStateItem, LocalDate updateStateItem, Item idItem, Boolean active, String description) {
        this.idStateItem =idStateItem;
        this.updateStateItem = updateStateItem;
        this.idItem = idItem;
        this.active = active;
        this.description = description;
    }

    public Long getIdStateItem() {
        return idStateItem;
    }

    public void setIdStateItem(Long idStateItem) {
        this.idStateItem = idStateItem;
    }

    public LocalDate getUpdateStateItem() {
        return updateStateItem;
    }

    public void setUpdateStateItem(LocalDate updatestateItem) {
        this.updateStateItem = updateStateItem;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}