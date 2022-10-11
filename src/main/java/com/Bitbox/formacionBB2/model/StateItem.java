package com.Bitbox.formacionBB2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
//@ToString(exclude = "stateIdItem")
//@EqualsAndHashCode(exclude = "stateIdItem")
@Table(name = "stateitem", schema="erp")
public class StateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stateitem_id_seq")
    @SequenceGenerator(name="stateitem_id_seq", sequenceName = "stateitem_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idstateitem")
    Long idStateItem;

    @Column(name = "updatestateItem")
    LocalDate updateStateItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "stateItems")
    @JoinColumn(name = "item_id", referencedColumnName = "iditem", nullable = false)
    Item stateIdItem;

    @Column(name = "active", nullable = false)
    Boolean active = Boolean.TRUE;

    @Column (name="description")
    String description;

    public StateItem(Item idItem, Boolean active) {
        this.updateStateItem = LocalDate.now();
        this.stateIdItem = idItem;
        this.active = active;
    }

    public StateItem() {
        this.updateStateItem = LocalDate.now();
    }

    public StateItem(Item idItem) {
        this.updateStateItem = LocalDate.now();
        this.stateIdItem = idItem;
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
        return stateIdItem;
    }

    public void setIdItem(Item idItem) {
        this.stateIdItem = idItem;
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

    @Override
    public String toString() {
        return "StateItem{" +
                "idStateItem=" + idStateItem +
                ", updateStateItem=" + updateStateItem +
//                ", stateIdItem=" + stateIdItem +
                ", active=" + active +
                ", description='" + description + '\'' +
                '}';
    }
}