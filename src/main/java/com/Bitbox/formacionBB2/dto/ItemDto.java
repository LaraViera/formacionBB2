package com.Bitbox.formacionBB2.dto;

public class ItemDto {
    Long idCreatorItem;
    //    List<StateItem> stateItems;
//    LocalDate creationDateItem;
    String description;
//    Long idItem;


    public Long getIdCreatorItem() {
        return idCreatorItem;
    }

    public void setIdCreatorItem(Long idCreatorItem) {
        this.idCreatorItem = idCreatorItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
