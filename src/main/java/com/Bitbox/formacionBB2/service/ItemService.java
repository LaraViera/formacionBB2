package com.Bitbox.formacionBB2.service;

import com.Bitbox.formacionBB2.model.Item;

import java.util.List;

public interface ItemService {

    Boolean saveItem(Item newItem);

    List<Item> getAllItems();
}
