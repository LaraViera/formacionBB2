package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.mapper.ItemMapper;
import com.Bitbox.formacionBB2.mapper.PriceReductionMapper;
import com.Bitbox.formacionBB2.mapper.SupplierMapper;
import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.StateItem;
import com.Bitbox.formacionBB2.repository.ItemRepository;
import com.Bitbox.formacionBB2.service.ItemService;
import com.Bitbox.formacionBB2.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PriceReductionMapper priceReductionMapper;

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierMapper supplierMapper;

    //TODO NO LLEGAN LOS DATOS desde cliente
    /*  Vamos a mantener este pedazo de código hasta que comprobemos que efectivamente no funciona */
   /* @RequestMapping(value = "/saveItem", method = RequestMethod.POST, consumes = "application/json")
    public Boolean saveItem(@RequestBody Item newItem) {
        System.out.println(newItem);
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
                newItem.setPriceReductionItem(itemService.addPriceReductionToItem(newItem));
            }
            return itemService.saveItem(newItem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
*/
    @RequestMapping(value = "/createItem", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
        try {
            Item _item = this.itemRepository.save(new Item(newItem.getItemCode(), newItem.getDescription(), newItem.getPriceItem()));
            List<StateItem> stateItem = new ArrayList<>();
            // TODO no se rea el enlace entre item y stado
            stateItem.add(new StateItem(newItem, true));
            System.out.println("MIAUUUU: " + stateItem);
            _item.setStateItem(stateItem);
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*   // TODO error al añadir un nuevo PR, ya que auqnue lo añade, no pone desactiva el anterior
       @PutMapping(value = "/editItem", consumes = "application/json;charset=UTF-8")
       public ResponseEntity<Object> updateItem(@RequestBody Item editItem) {
           try {
               if (null != editItem.getItemCode()) {
                   Item item = itemService.findItemByItemcode(editItem.getItemCode());
                   // comprobamos que el codeItem existe y que es un item activo
                   if (null != item && (item.getStateItem().get(item.getStateItem().size() - 1).getActive())) {
                       // editamos Price si es =! null
                       if (null != editItem.getPriceItem()) {
                           item.setPriceItem(editItem.getPriceItem());
                       }
                       // editamos Description si es =! null
                       if (null != editItem.getDescription()) {
                           item.setDescription(editItem.getDescription());
                       }
                       //editamos State si es =! null
                       if (null != editItem.getStateItem()) {
                           item.addStateItem(new StateItem(item, editItem.getStateItem().get(item.getStateItem().size() - 1).getActive()));
                       }
                       // editamos PriceReductionItem si es =! null
                       if (null != editItem.getPriceReductionItem()) {
                           // comprobamos si las reducciones de precio existen y si no lo añadimos
                           item.addPriceReductionItem(itemService.addPriceReductionToItem(editItem).get(itemService.addPriceReductionToItem(editItem).size() - 1));

                       }
                       // editamos los suministradores (desplegable, solo se podrá modificar de 1 en 1)
                       if (null != editItem.getSuppliersItem()) {
                           for (Supplier supplier : editItem.getSuppliersItem()) {
                               addSupplier(editItem.getItemCode(), supplier.getName());
                           }
                       }
                   } else {
                       throw new IllegalArgumentException("El codigo del item no existe");
                   }
                   itemService.saveItem(item);

                   return ResponseEntity.ok().build();
               }
               return ResponseEntity.noContent().build();
           } catch (Exception e) {
               throw e;
           }

       }

   */
    @GetMapping("/allItems")
    public List<ItemDto> findAllItems() {
        List<ItemDto> itemDtoList;
        List<Item> itemList = itemService.getAllItems();
        itemDtoList = itemMapper.toItemDtoList(itemList);
        return itemDtoList;
    }
/*
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
    public Boolean addSupplier(@RequestParam(value = "itemCode") Long itemCode
            , @RequestParam(value = "nameSupplier") String nameSupplier) {
        try {
            Set<Supplier> supplierSet = new HashSet<>();
            if (null == itemCode || null == nameSupplier) {
                return null;
            }
            Item item = itemService.findItemByItemcode(itemCode);
            Supplier supplier = supplierService.findSupplierByName(nameSupplier);
            ItemDto itemDto = itemMapper.toItemDto(item);

            Set<SupplierDto> supplierDtoSet;

            for (SupplierDto supplierDtoElement : itemDto.getSuppliersItem()) {
                if (supplierDtoElement.getName() == supplier.getName()) {
                    return null;
                }
            }

            supplierDtoSet = itemDto.getSuppliersItem();
            supplierDtoSet.add(supplierMapper.toSupplierDto(supplier));
            Set<Item> itemSetSupplier = supplier.getItemsSupplier();
            itemSetSupplier.add(new Item(item.getIdItem(), item.getDescription(), item.getItemCode(), item.getPriceItem(), item.getPriceReductionItem(), item.getStateItem(), item.getIdCreatorItem(), item.getSuppliersItem()));

            supplierSet = item.getSuppliersItem();
            supplierSet.add(new Supplier(supplier.getIdSupplier(), nameSupplier, supplier.getCountry(), itemSetSupplier));

            itemDto.setSuppliersItem(supplierDtoSet);
            item.setSuppliersItem(supplierSet);
            itemService.saveItem(item);
            return true;

        } catch (Exception e) {
            throw e;
        }
    }*/
}
