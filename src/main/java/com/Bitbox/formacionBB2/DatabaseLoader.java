package com.Bitbox.formacionBB2;

import com.Bitbox.formacionBB2.model.*;
import com.Bitbox.formacionBB2.repository.ItemRepository;
import com.Bitbox.formacionBB2.repository.RoleRepository;
import com.Bitbox.formacionBB2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;
    List<StateItem> stateItem = new ArrayList<>();

    private final RoleRepository roleRepository;
    Set<Role> role = new HashSet<>();


    @Autowired
    public DatabaseLoader(ItemRepository itemRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.itemRepository.save(new Item(123L, "Item 2", new BigDecimal("800"), stateItem));
        this.userRepository.save(new Users("user", "user@user.com", "123456", Collections.singleton(new Role(RoleEnum.USER))));
        this.roleRepository.save(new Role(RoleEnum.ADMIN));
//        this.roleRepository.save(new Role(RoleEnum.USER));
    }

}
