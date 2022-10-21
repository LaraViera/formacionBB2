package com.Bitbox.formacionBB2.repository.impl;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.repository.ItemRepositoryCustom;

import java.util.List;

public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @Override
    public List<Item> getDetails(Item item) {
        return null;
    }

    @Override
    public Item findByItemcode(Long itemCode) {
        return null;
    }

    public Item findPriceReductionActivated(Long itemCode) {
        return null;
    }

}
