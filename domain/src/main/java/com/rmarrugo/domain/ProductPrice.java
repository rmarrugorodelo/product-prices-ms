package com.rmarrugo.domain;

import lombok.Value;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ProductPrice {

    Long id;

    Brand brand;

    LocalDateTime startDate;

    LocalDateTime endDate;

    String priceList;

    Long productId;

    @With
    Integer priority;

    @With
    BigDecimal price;

    String curr;

}
