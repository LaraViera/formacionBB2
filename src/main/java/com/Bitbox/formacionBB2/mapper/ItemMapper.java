package com.Bitbox.formacionBB2.mapper;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.dto.PriceReductionDto;
import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.PriceReduction;
import com.Bitbox.formacionBB2.model.StateItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper itemDtoToItem = Mappers.getMapper(ItemMapper.class);

    @Autowired
    PriceReductionMapper priceReductionMapper = null;

    @Mapping(ignore = true, target = "stateItems")
    ItemDto toItemDto(Item item);

    @Mapping(ignore = true, target = "stateItems")
    List<ItemDto> toItemDtoList(List<Item> item);

    List<ItemDto> map(List<Item> items);

    @AfterMapping
    default void addState(@MappingTarget ItemDto itemDto, Item item) {
        List<StateItem> stateItemList = item.getStateItem();
        StateItem stateItemElement = stateItemList.get(stateItemList.size() - 1);
        itemDto.setStateItems(stateItemElement.getActive());
    }

    @AfterMapping
    default void addPriceReduction(@MappingTarget ItemDto itemDto, Item item) {
        List<PriceReduction> priceReductionList = item.getPriceReductionItem();
        List<PriceReductionDto> priceReductionDtoList = null;
        for (PriceReduction priceReductionElement : priceReductionList) {
            // TODO error de null pointer porque PRMapper está inicializada a 0, hay que llamar de un mapper a otro o
            //hacerlo todo en el mismo auqnue no sé si se puede hacer.
            priceReductionDtoList.add(priceReductionMapper.toPriceReductionDto(priceReductionElement));
        }
        itemDto.setPriceReductions(priceReductionDtoList);
    }

//    @AfterMapping
//    default void addPriceReduction(@MappingTarget ItemDto itemDto, Item item) {
//        // lista de todos los priceReductions
//        List<PriceReduction> priceReductionList= item.getPriceReductionItem();
//
//        List<PriceReduction> priceReductionListDto = new ArrayList<>();
//
//        // Recorremos todos los elementos de la lista de Pr y los vamos añadiendo al DTO, sin el campo de itemPriceREduction (?)
//        //TODO recorrer y No tener dos precios rebajados a la vez, que si insertas una rebaja nueva la otra se caduque, en el detalle si muestras todo
//        for (PriceReduction priceReductionElement : priceReductionList){
//            if(priceReductionElement.getStatePriceReduction()){
////                itemDto.setPriceReductions(priceReductionElement.getReducedPrice());
//                priceReductionListDto.add(priceReductionElement);
//            }
//        }
//
//    }
}
