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
    List<PriceReductionDto> toPriceReductionDtoList(List<PriceReduction> priceReductionList);


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

