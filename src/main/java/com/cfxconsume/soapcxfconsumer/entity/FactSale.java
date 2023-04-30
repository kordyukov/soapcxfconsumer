package com.cfxconsume.soapcxfconsumer.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "fact_sale")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FactSale extends AbstractEntity{
    @Column(nullable = false)
    private Instant dateSale;
    @Column(nullable = false)
    private Integer receiptNumber;

    @ElementCollection
    @CollectionTable(name = "customer", joinColumns = @JoinColumn(name = "id"))
    private Collection<Customer> customers = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "position", joinColumns = @JoinColumn(name = "id"))
    private Collection<Position> positions = new ArrayList<>();
}
