package com.rmarrugo.persistence.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PRODUCT_PRICES")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    BrandEntity brand;

    @Column(name = "START_DATE", nullable = false)
    LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    Integer priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    Long productId;

    @Column(name = "PRIORITY")
    Integer priority;

    @Column(name = "PRICE", nullable = false)
    BigDecimal price;

    @Column(name = "CURR", nullable = false)
    String curr;


}
