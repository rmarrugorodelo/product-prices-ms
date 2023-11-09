package com.rmarrugo.domain;

import lombok.Value;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ProductPrice {
    @With
    Long id;

    Brand brand;

    LocalDateTime startDate;

    LocalDateTime endDate;

    String priceList;

    Long productId;

    Integer priority;

    BigDecimal price;

    String curr;

}
