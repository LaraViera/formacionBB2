package com.Bitbox.formacionBB2.mapper;

import com.Bitbox.formacionBB2.dto.ItemDto;
import com.Bitbox.formacionBB2.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper itemDtoToItem = Mappers.getMapper(ItemMapper.class);

    ItemDto toItemDto(Item item);

    List<ItemDto> toItemDtoList(List<Item> item);

    List<ItemDto> map(List<Item> items);
}
