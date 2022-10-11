package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.mapper.ItemMapper;
import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    protected ItemService itemService;
    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Boolean saveItem(@RequestBody Item newItem) throws ServletException {
        try {
            List<StateItem> stateItems = new ArrayList<>();

            if (null != newItem.getStateItems()) {
                List<StateItem> stateNewItem = newItem.getStateItems();

                for (StateItem state : stateNewItem) {
                    stateItems.add(new StateItem(newItem, state.getActive()));
                }

                newItem.setStateItems(stateItems);
            } else {
                // state True por defecto
                stateItems.add(new StateItem(newItem));
                newItem.setStateItems(stateItems);
            }
            if (null != newItem.getPriceReductionItem()) {
                List<PriceReduction> priceReductionNewItem = newItem.getPriceReductionItem();
                List<PriceReduction> priceReduction = new ArrayList<>();

                for (PriceReduction priceReductionElement : priceReductionNewItem) {
                    priceReduction.add(new PriceReduction(newItem, priceReductionElement.getReducedPrice()));
                }
                newItem.setPriceReductionItem(priceReduction);
            }
            return itemService.saveItem(newItem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @GetMapping("/allItems")
    public List<ItemDto> findAllItems() {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemList = itemService.getAllItems();

        /*for (Item item : itemList) {
            itemDtoList.add(itemMapper.(item));
        }*/
        itemDtoList = itemMapper.toItemDtoList(itemList);
        return itemDtoList;
    }


}

