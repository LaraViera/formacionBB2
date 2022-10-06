package com.Bitbox.formacionBB2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/*/**
 * @hibernate.class
 *  table="stateitem_core"
 *  schema="erp"
 *  mutable="true"
 *  dynamic-update="true"
 */

@Entity
@Table(name = "stateitem", schema="erp")
public class StateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stateitem_id_seq")
    @SequenceGenerator(name="stateitem_id_seq", sequenceName = "stateitem_id_seq", allocationSize = 1, schema = "erp")
    @Column(name="idStateItem")
    Long idStateItem;

    @Column (name="updateStateItem")
    Date updateStateItem;

    @ManyToOne()
    @JoinColumn(name="item_id")
    Item idItem;

    @Column (name="active")
    Boolean active;

    @Column (name="description")
    String description;



    public StateItem( Long idStateItem, Date updateStateItem, Item idItem, Boolean active, String description) {
        this.idStateItem =idStateItem;
        this.updateStateItem = updateStateItem;
        this.idItem = idItem;
        this.active = active;
        this.description = description;
    }

    /*/**
     * @hibernate.id unsaved-value="null" column="idIdStateItem"
     * @hibernate.generator class="sequence"
     * @hibernate.param name="sequence" value="erp.stateitem_id_seq"
     *  @return Long
     */
//    @Id
    public Long getIdStateItem() {
        return idStateItem;
    }

    public void setIdStateItem(Long idStateItem) {
        this.idStateItem = idStateItem;
    }

    /*/**
     * @hibernate.property
     * column="updatestateitem"
     * type="timestamp"
     * not-null="true"
     * unique="false"
     * @return Date
     */
    public Date getUpdateStateItem() {
        return updateStateItem;
    }

    public void setUpdateStateItem(Date updatestateItem) {
        this.updateStateItem = updateStateItem;
    }

    /*/**
     * @hibernate.many_to_one
     *  column="item_id"
     *  class="com.Bitbox.formacionBB2.model.Item"
     *  not-null="true"
     *  lazy="false"
     */
    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    /*/**
     * @hibernate.property
     * column="active"
     * type="boolean"
     * not-null="true"
     * unique="false"
     * @return Boolean
     */
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public void setDescription(String description) {
        this.description = description;
    }
}