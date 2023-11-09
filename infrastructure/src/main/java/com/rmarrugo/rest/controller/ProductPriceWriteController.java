package com.rmarrugo.rest.controller;

import com.rmarrugo.constant.RouteConstant;
import com.rmarrugo.port.in.ProductPriceSaver;
import com.rmarrugo.rest.dto.ProductPriceRequest;
import com.rmarrugo.rest.mapper.ProductPriceRestMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(RouteConstant.V1_PATH)
@RestController
public class ProductPriceWriteController {

    private final ProductPriceSaver saver;

    private final ProductPriceRestMapper mapper;

    public ProductPriceWriteController(ProductPriceSaver saver,
                                       ProductPriceRestMapper mapper) {
        this.saver = saver;
        this.mapper = mapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid ProductPriceRequest request) {
        saver.create(
                mapper.toDomain(request)
        );
    }

}
