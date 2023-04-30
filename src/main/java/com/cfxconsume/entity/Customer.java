package com.cfxconsume.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Customer {
    @Id
    public UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer individual_discount_1;
    @Column(nullable = false)
    private Integer individual_discount_2;
}
