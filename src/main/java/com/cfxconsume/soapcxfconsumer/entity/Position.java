package com.cfxconsume.soapcxfconsumer.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "fact_sale")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Position extends AbstractEntity{
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal originalPrice;
    @Column(nullable = false)
    private BigDecimal finalPrice;
    @Column(nullable = false)
    private BigDecimal finalDiscount;
}
