package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.dto.SupplierDto;
import com.Bitbox.formacionBB2.mapper.ItemMapper;
import com.Bitbox.formacionBB2.mapper.PriceReductionMapper;
import com.Bitbox.formacionBB2.mapper.SupplierMapper;
import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.model.Supplier;
import com.Bitbox.formacionBB2.service.ItemService;
import com.Bitbox.formacionBB2.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    protected ItemService itemService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private PriceReductionMapper priceReductionMapper;

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
//    @PostMapping(value = "/saveItem", consumes = "application/json;charset.set=UTF=8")
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

                PriceReduction priceReductionOld = new PriceReduction();

                for (PriceReduction priceReductionElement : priceReductionNewItem) {
                    if (null != priceReductionOld && priceReductionOld.getStatePriceReduction()) {
                        // modificamos el elemento anterior para poner su estado a false
                        priceReduction.get(priceReduction.size() - 1).setStatePriceReduction(false);
                    }
                    priceReduction.add(new PriceReduction(newItem, priceReductionElement.getReducedPrice()
                            , Boolean.TRUE
                            , priceReductionElement.getStartDatePriceReduction()
                            , priceReductionElement.getEndDatePriceReduction()));
                    priceReductionOld = priceReductionElement;
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
            Item item = itemService.findPriceReductionActivated(itemCode);
            itemDto = itemMapper.toItemDto(item);
            itemDto.setPriceReductions(priceReductionMapper.toPriceReductionDtoList(item.getPriceReductionItem()));

            return itemDto;

        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/addSupplier")
    public ItemDto addSupplier(@RequestParam(value = "itemCode") Long itemCode
//    public Boolean addSupplier(@RequestParam(value= "itemCode")  Long itemCode
            , @RequestParam(value = "nameSupplier") String nameSupplier) {
        // recibimos el código del Item y el código del suministrador
        // y comprobamos si existe le item, si existe el suministrador y si el suministrador
        // ya existe en el item, si no lo añadimos
        try {
            Set<Supplier> supplierSet;
            if (null == itemCode || null == nameSupplier) {
                return null;
            }
            Item item = itemService.findItemByItemcode(itemCode);
            Supplier supplier = supplierService.findSupplierByName(nameSupplier);
            SupplierDto supplierDto = supplierMapper.toSupplierDto(supplier);
            ItemDto itemDto = itemMapper.toItemDto(item);

            Set<SupplierDto> supplierDtoSet;

            for (SupplierDto supplierDtoElement : itemDto.getSuppliersItem()) {
                if (supplierDtoElement.getName() == supplier.getName()) {
                    return null;
                }
            }
            supplierDtoSet = itemDto.getSuppliersItem();
            supplierDtoSet.add(supplierDto);

            // TODO COMPROBAR SI FUNCIONA
            itemDto.setSuppliersItem(supplierDtoSet);

            return itemDto;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
//        return false;
    }

}
