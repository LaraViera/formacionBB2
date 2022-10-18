package com.Bitbox.formacionBB2;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;
    List<StateItem> stateItem = new ArrayList<>();


    @Autowired
    public DatabaseLoader(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.itemRepository.save(new Item(123L, "Item 2", new BigDecimal("800"), stateItem));

    }

}
