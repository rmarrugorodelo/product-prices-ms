package com.rmarrugo.rest.controller;

import com.rmarrugo.constant.RouteConstant;
import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.port.in.ProductPriceFinder;
import com.rmarrugo.rest.dto.ProductPriceResponse;
import com.rmarrugo.rest.mapper.ProductPriceRestMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping(RouteConstant.V1_PATH)
@RestController
public class ProductPriceReadController {

    private final ProductPriceFinder finder;


    private final ProductPriceRestMapper mapper;

    public ProductPriceReadController(ProductPriceFinder finder,
                                      ProductPriceRestMapper mapper) {
        this.finder = finder;
        this.mapper = mapper;
    }

    @GetMapping
    public ProductPriceResponse findByBrandAndProductAndDate(
            @RequestParam(name = RouteConstant.BRAND_ID) Long brandId,
            @RequestParam(name = RouteConstant.PRODUCT_ID) Long productId,
            @RequestParam(name = RouteConstant.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date
    ) throws NotFoundException {
        return mapper.toResponse(
                finder.findByBrandAndProductAndDate(brandId, productId, date)
        );
    }

}
