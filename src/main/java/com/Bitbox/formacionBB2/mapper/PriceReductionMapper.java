package com.Bitbox.formacionBB2.mapper;

import com.Bitbox.formacionBB2.dto.PriceReductionDto;
import com.Bitbox.formacionBB2.model.PriceReduction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceReductionMapper {
    PriceReductionMapper priceReductionDtoToItem = Mappers.getMapper(PriceReductionMapper.class);

    @Mapping(ignore = true, target = "itemPriceReduction")
    PriceReductionDto toPriceReductionDto(PriceReduction priceReduction);

    @Mapping(ignore = true, target = "itemPriceReduction")
    List<PriceReduction> toPriceReductionDtoList(List<PriceReduction> priceReductionList);

}

