package com.rmarrugo.domain;

import lombok.Value;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ProductPrice {

    @With
    Long id;

    @With
    Brand brand;

    @With
    LocalDateTime startDate;

    @With
    LocalDateTime endDate;

    Integer priceList;

    Long productId;

    @With
    Integer priority;

    @With
    BigDecimal price;

    String curr;

}
