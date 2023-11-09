package com.rmarrugo.rest.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ProductPriceRequest {

    @NotNull
    Long brandId;

    @NotNull
    LocalDateTime startDate;

    @NotNull
    LocalDateTime endDate;

    @NotNull
    Integer priceList;

    @NotNull
    Long productId;

    @NotNull
    Integer priority;

    @NotNull
    BigDecimal price;

    @NotBlank
    String curr;
}
