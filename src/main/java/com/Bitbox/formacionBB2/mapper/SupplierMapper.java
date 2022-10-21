package com.Bitbox.formacionBB2.mapper;

import com.Bitbox.formacionBB2.dto.SupplierDto;
import com.Bitbox.formacionBB2.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierMapper supplierDtoToSupplier = Mappers.getMapper(SupplierMapper.class);


    @Mapping(ignore = true, target = "itemsSupplier")
    SupplierDto toSupplierDto(Supplier supplier);

    @Mapping(ignore = true, target = "itemsSupplier")
    Set<SupplierDto> toSupplierDtoList(Set<Supplier> supplier);

}
