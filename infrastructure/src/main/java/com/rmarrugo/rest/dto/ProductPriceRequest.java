package com.rmarrugo.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.rmarrugo.constant.DateFormat;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductPriceRequest {

    @NotNull
    Long brandId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DEFAULT_FORMAT)
    @NotNull
    LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DEFAULT_FORMAT)
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
