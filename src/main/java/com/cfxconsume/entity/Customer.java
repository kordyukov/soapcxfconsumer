package com.cfxconsume.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Customer {
    @Id
    @GeneratedValue
    public UUID id;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private Double individualDiscount1;
    @Column(nullable = false)
    private Double individualDiscount2;
}
