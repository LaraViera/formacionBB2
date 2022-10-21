package com.Bitbox.formacionBB2.repository;

import com.Bitbox.formacionBB2.model.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepositoryCustom {
    List<Item> getDetails(Item item);

    @Query(nativeQuery = true, value = "SELECT * FROM ERP.ITEM  AS item WHERE item.itemcode= :itemCode")
    Item findByItemcode(Long itemCode);


    @Query(nativeQuery = true, value = "SELECT * FROM ERP.ITEM as item INNER JOIN ERP.STATEITEM  AS state inner join ERP.ITEMPRICEREDUCTION as pricereduction WHERE item.iditem =state.item_id AND item.itemcode= :itemCode AND item.iditem=pricereduction.itempricereduction_id")
    Item findPriceReductionActivated(Long itemCode);

}
