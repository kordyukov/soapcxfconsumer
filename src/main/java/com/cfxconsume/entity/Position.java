package com.cfxconsume.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "fact_sale")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Position {
    @Id
    @GeneratedValue
    public UUID id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Double originalPrice;
    @Column(nullable = false)
    private Double finalPrice;
    @Column(nullable = false)
    private Double finalDiscount;
}
