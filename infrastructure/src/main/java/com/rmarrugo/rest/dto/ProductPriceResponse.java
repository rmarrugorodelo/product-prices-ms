package com.rmarrugo.rest.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductPriceResponse {

    Long id;

    BrandResponse brand;

    LocalDateTime startDate;

    LocalDateTime endDate;

    String priceList;

    Long productId;

    Integer priority;

    BigDecimal price;

    String curr;

}
