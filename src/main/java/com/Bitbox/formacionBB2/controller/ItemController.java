package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.mapper.ItemMapper;
import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Boolean saveItem(@RequestBody Item newItem) {
        try {
            List<StateItem> stateItems = new ArrayList<>();

            if (null != newItem.getStateItem()) {
                List<StateItem> stateNewItem = newItem.getStateItem();

                for (StateItem state : stateNewItem) {
                    stateItems.add(new StateItem(newItem, state.getActive()));
                }

                newItem.setStateItem(stateItems);
            } else {
                // state True por defecto
                stateItems.add(new StateItem(newItem));
                newItem.setStateItem(stateItems);
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
        List<ItemDto> itemDtoList;
        List<Item> itemList = itemService.getAllItems();
        itemDtoList = itemMapper.toItemDtoList(itemList);
        return itemDtoList;
    }

    @GetMapping("/detailItem")
    public ItemDto findDetailsItem(@RequestParam(value = "itemCode") Long itemCode) {
        try {
            if (null == itemCode) {
                return null;
            }

            ItemDto itemDto;
            Item item = itemService.findItemByItemcode(itemCode);
//            Optional<Item> itemOptional = itemService.getDetailsItemById(idItem);
//            Item itemDetails = itemOptional.get();
            itemDto = itemMapper.toItemDto(item);
            return itemDto;

        } catch (Exception e) {
            throw e;
        }
    }

}
