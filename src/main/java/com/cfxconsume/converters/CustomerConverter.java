package com.cfxconsume.converters;

import com.cfxconsume.model.dto.ChangeDiscountByCustomerDto;
import com.cfxconsume.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerConverter {
    @Mapping(target = "individualDiscountOne", source = "dto.individualDiscountOne",
            defaultValue = "1D")
    @Mapping(target = "individualDiscountTwo", source = "dto.individualDiscountTwo",
            defaultValue = "1D")
    Customer toEntity(ChangeDiscountByCustomerDto dto);
}
