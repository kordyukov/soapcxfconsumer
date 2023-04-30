package com.cfxconsume.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "fact_sale")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FactSale {
    @Id
    @GeneratedValue
    public UUID id;
    @Column(nullable = false)
    private Instant dateSale;
    @Column(nullable = false)
    private String receiptNumber;

    @ElementCollection
    @CollectionTable(name = "customer", joinColumns = @JoinColumn(name = "id"))
    private Collection<Customer> customers = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "position", joinColumns = @JoinColumn(name = "id"))
    private Collection<Position> positions = new ArrayList<>();

}
