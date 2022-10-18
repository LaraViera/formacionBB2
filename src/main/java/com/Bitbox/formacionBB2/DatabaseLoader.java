package com.Bitbox.formacionBB2;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.model.Users;
import com.Bitbox.formacionBB2.repository.ItemRepository;
import com.Bitbox.formacionBB2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;
    List<StateItem> stateItem = new ArrayList<>();


    @Autowired
    public DatabaseLoader(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.itemRepository.save(new Item(123L, "Item 2", new BigDecimal("800"), stateItem));
        this.userRepository.save(new Users("admin", "admin@admin.com", "123456"));

    }

}
