package com.Bitbox.formacionBB2.service;

import com.Bitbox.formacionBB2.model.Item;

import java.util.List;

public interface ItemService {

    Boolean saveItem(Item newItem);

    List<Item> getAllItems();

    Item findItemByItemcode(Long itemCode);

    Item findPriceReductionActivated(Long itemCode);

//    List<PriceReduction> getPriceReductionByIdItem(Long idItem);
}
