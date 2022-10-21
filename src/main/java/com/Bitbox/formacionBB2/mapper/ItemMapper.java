package com.Bitbox.formacionBB2.mapper;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.model.Item;
import com.Bitbox.formacionBB2.model.StateItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PriceReductionMapper.class, SupplierMapper.class})
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(ignore = true, target = "stateItems")
    ItemDto toItemDto(Item item);

    @Mapping(ignore = true, target = "stateItems")
    List<ItemDto> toItemDtoList(List<Item> item);

    List<ItemDto> map(List<Item> items);

    @AfterMapping
    default void addState(@MappingTarget ItemDto itemDto, Item item) {
        List<StateItem> stateItemList = item.getStateItem();
        if (stateItemList.size() != 0) {
            StateItem stateItemElement = stateItemList.get(stateItemList.size() - 1);

        itemDto.setStateItems(stateItemElement.getActive());
        }
    }
}
