package com.cfxconsume.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@XmlAccessorType(XmlAccessType.NONE)
public class Customer {
    @Id
    @GeneratedValue
    public UUID id;
    @XmlElement
    private String customerName;
    @XmlElement
    private Double individualDiscountOne;
    @XmlElement
    private Double individualDiscountTwo;
}
