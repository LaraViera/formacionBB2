package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    //TODO
    @Autowired
//    private ItemMapper itemMapper;
    protected ItemService itemService;

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public Boolean saveItem(@RequestBody Item newItem) {
        return itemService.saveItem(newItem);
    }

   /* @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems().stream().map(
                item -> itemMapper.map(item, ItemDto.class))
                .collect(Collectors.toList());
    }*/


}

