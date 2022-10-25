package com.Bitbox.formacionBB2.repository;

import com.Bitbox.formacionBB2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, String>, ItemRepositoryCustom {

}
