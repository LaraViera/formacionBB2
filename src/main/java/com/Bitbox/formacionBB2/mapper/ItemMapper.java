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

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper itemDtoToItem = Mappers.getMapper(ItemMapper.class);

    @Mapping(ignore = true, target = "stateItems")
    ItemDto toItemDto(Item item);

    @Mapping(ignore = true, target = "stateItems")
    List<ItemDto> toItemDtoList(List<Item> item);

    List<ItemDto> map(List<Item> items);

    @AfterMapping
    default void addState(@MappingTarget ItemDto itemDto, Item item) {
        List<StateItem> stateItemList = item.getStateItems();
        StateItem stateItemElement = stateItemList.get(stateItemList.size() - 1);
        itemDto.setStateItems(stateItemElement.getActive());
    }
    /*@Mapping(target = "stateItems", qualifiedByName = "addStateItemDto")
    ItemDto addStateItemDTO(ItemDto itemDto, Item item);

    @Named("addStateItemDto")
    static void addStateItemDto(ItemDto itemDto, Boolean state){
        itemDto.setStateItems(state);
    }*/
}
