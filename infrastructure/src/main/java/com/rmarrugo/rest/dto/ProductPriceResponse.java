package com.rmarrugo.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.rmarrugo.constant.DateFormat;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductPriceResponse {

    Long brandId;

    @JsonFormat(pattern = DateFormat.DEFAULT_FORMAT)
    LocalDateTime startDate;

    @JsonFormat(pattern = DateFormat.DEFAULT_FORMAT)
    LocalDateTime endDate;

    String priceList;

    Long productId;

    BigDecimal price;

}
