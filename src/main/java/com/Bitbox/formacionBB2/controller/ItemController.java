package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    //TODO
    @Autowired
//    private ItemMapper itemMapper;
    protected ItemService itemService;

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public Boolean saveItem(@RequestBody Item newItem) throws ServletException {
        try {
            System.out.println(newItem.getStateItems());
            List<StateItem> stateItems = new ArrayList<>();

            if (null != newItem.getStateItems()) {
//            if (newItem.getStateItems() != null) {
                List<StateItem> stateNewItem = newItem.getStateItems();
//                List<StateItem> stateItems = new ArrayList<>();

                for (StateItem state : stateNewItem) {
                    stateItems.add(new StateItem(newItem, state.getActive()));
                }

                newItem.setStateItems(stateItems);
            } else {
                stateItems.add(new StateItem(newItem));
                newItem.setStateItems(stateItems);
            }
            /////////////
            if (null != newItem.getPriceReductionItem()) {
                List<PriceReduction> priceReductionNewItem = newItem.getPriceReductionItem();
                List<PriceReduction> priceReduction = new ArrayList<>();

                for (PriceReduction priceReductionElement : priceReductionNewItem) {
                    priceReduction.add(new PriceReduction(newItem, priceReductionElement.getReducedPrice()));
                }

                newItem.setPriceReductionItem(priceReduction);
            }
            // stateItem.Active por defecto a True


            return itemService.saveItem(newItem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //TODO el enlace entre item y stateItem no se realiza correctamente

   /* @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems().stream().map(
                item -> itemMapper.map(item, ItemDto.class))
                .collect(Collectors.toList());
    }*/


}

