package com.Bitbox.formacionBB2.service;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;

import java.util.List;

public interface ItemService {

    Boolean saveItem(Item newItem);

    List<Item> getAllItems();

    Item findItemByItemcode(Long itemCode);

    Item findPriceReductionActivated(Long itemCode);

    List<PriceReduction> addPriceReductionToItem(Item newItem);

    void checkStatePriceReduction(Item item);


//    List<PriceReduction> getPriceReductionByIdItem(Long idItem);
}
