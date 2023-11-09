package com.rmarrugo.rest.controller;

import com.rmarrugo.constant.RouteConstant;
import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.port.in.ProductPriceSaver;
import com.rmarrugo.rest.dto.ProductPriceRequest;
import com.rmarrugo.rest.mapper.ProductPriceRestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody @Valid ProductPriceRequest request) throws NotFoundException {
        saver.create(
                mapper.toDomain(request)
        );
    }

}
