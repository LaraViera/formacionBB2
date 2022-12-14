package com.Bitbox.formacionBB2.service.impl;

import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;
import com.Bitbox.formacionBB2.repository.ItemRepository;
import com.Bitbox.formacionBB2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    @Override
    public Boolean saveItem(Item item) {
        try {
            itemRepository.save(item);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getDetailsItemById(Long id) {
        return itemRepository.findById(id.toString());
    }

    public Item findItemByItemcode(Long itemCode) {
        return itemRepository.findByItemcode(itemCode);
    }


    public Item findPriceReductionActivated(Long itemCode) {
        return itemRepository.findPriceReductionActivated(itemCode);
    }

    @Override
    public List<PriceReduction> addPriceReductionToItem(Item newItem) {
        List<PriceReduction> priceReductionNewItem = newItem.getPriceReductionItem();
        PriceReduction priceReductionOld = new PriceReduction();
        List<PriceReduction> priceReduction = new ArrayList<>();


        /*for (PriceReduction priceReductionElement : priceReductionNewItem) {
            if (null != priceReductionOld && priceReductionOld.getStatePriceReduction() && priceReductionElement.getStatePriceReduction()) {
                // modificamos el elemento anterior para poner su estado a false
                priceReduction.get(priceReduction.size() - 1).setStatePriceReduction(false);
            }
            priceReduction.add(new PriceReduction(newItem, priceReductionElement.getReducedPrice()
                    , priceReductionElement.getStatePriceReduction()
//                    , Boolean.TRUE
                    , priceReductionElement.getStartDatePriceReduction()
                    , priceReductionElement.getEndDatePriceReduction()));
            priceReductionOld = priceReductionElement;
        }*/
        for (PriceReduction priceReductionElement : priceReductionNewItem) {
            if (null != priceReductionOld && priceReductionOld.getStatePriceReduction() && priceReductionElement.getStatePriceReduction()) {
                // modificamos el elemento anterior para poner su estado a false
                priceReduction.get(priceReduction.size() - 1).setStatePriceReduction(false);
            }
            priceReduction.add(new PriceReduction(newItem, priceReductionElement.getReducedPrice()
                    , priceReductionElement.getStatePriceReduction()
//                    , Boolean.TRUE
                    , priceReductionElement.getStartDatePriceReduction()
                    , priceReductionElement.getEndDatePriceReduction()));
            if (priceReductionElement.getStatePriceReduction()) {
                priceReductionOld = priceReductionElement;
            }
        }

        return priceReduction;
    }

    @Override
    public void checkStatePriceReduction(Item item) {
        PriceReduction priceReductionOld = new PriceReduction();
        List<PriceReduction> priceReduction = new ArrayList<>();

        for (PriceReduction priceReductionElement : item.getPriceReductionItem()) {
            if (null != priceReductionOld && priceReductionOld.getStatePriceReduction() && priceReductionElement.getStatePriceReduction()) {
                priceReductionOld.setStatePriceReduction(false);
                priceReductionOld.setItemPriceReduction(item);
            }
            if (priceReductionElement.getStatePriceReduction()) {
                priceReductionOld = priceReductionElement;
            }
        }
    }


//    public List<PriceReduction> getPriceReductionByIdItem(Long idItem) {
//        return itemRepository.getPriceReductionByIdItem(idItem);
//    }


}
