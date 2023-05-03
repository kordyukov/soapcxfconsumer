package com.cfxconsume.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "fact_sale")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@XmlAccessorType(XmlAccessType.NONE)
public class Position {
    @Id
    @GeneratedValue
    public UUID id;
    @XmlElement
    private Integer quantity;
    @XmlElement
    private Double originalPrice;
    @XmlElement
    private Double finalPrice;
    @XmlElement
    private Double finalDiscount;
}
