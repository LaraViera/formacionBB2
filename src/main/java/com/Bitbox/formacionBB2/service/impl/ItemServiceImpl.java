package com.Bitbox.formacionBB2.service.impl;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.repository.ItemRepository;
import com.Bitbox.formacionBB2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    @Override
    public Boolean saveItem(Item item) {
        try {
            itemRepository.save(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
