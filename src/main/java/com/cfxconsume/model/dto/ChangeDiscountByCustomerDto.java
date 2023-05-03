package com.cfxconsume.model.dto;

import java.util.UUID;

public record ChangeDiscountByCustomerDto(
        UUID id,
        double individualDiscountOne,
        double individualDiscountTwo
) {
}
