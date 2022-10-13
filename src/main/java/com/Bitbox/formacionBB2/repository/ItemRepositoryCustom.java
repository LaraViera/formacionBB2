package com.Bitbox.formacionBB2.repository;

import com.Bitbox.formacionBB2.model.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepositoryCustom {
    List<Item> getDetails(Item item);

    @Query(nativeQuery = true, value = "SELECT * FROM ERP.ITEM  AS item INNER JOIN ERP.STATEITEM  AS state WHERE item.iditem =state.item_id AND item.itemcode= :itemCode")
    Item findByItemcode(Long itemCode);

//    @Query(nativeQuery = true, value = "SELECT * FROM ERP.ITEM  AS item INNER JOIN ERP.STATEITEM  AS state WHERE item.iditem =state.item_id AND item.itemcode= :itemCode")
//   List<PriceReduction> getPriceReductionByIdItem(Long idItem);

}
