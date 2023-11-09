package com.rmarrugo.rest.controller;

import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.port.in.ProductPriceFinder;
import com.rmarrugo.port.in.ProductPriceSaver;
import com.rmarrugo.rest.dto.ProductPriceRequest;
import com.rmarrugo.rest.dto.ProductPriceResponse;
import com.rmarrugo.rest.mapper.ProductPriceRestMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequestMapping("v1/product-prices")
@RestController
public class ProductPriceController {

    private final ProductPriceFinder finder;

    private final ProductPriceSaver saver;

    private final ProductPriceRestMapper mapper;

    public ProductPriceController(ProductPriceFinder finder,
                                  ProductPriceSaver saver,
                                  ProductPriceRestMapper mapper) {
        this.finder = finder;
        this.saver = saver;
        this.mapper = mapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid ProductPriceRequest request) {
        saver.create(
                mapper.toDomain(request)
        );
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid ProductPriceRequest request) throws NotFoundException {
        saver.update(
                id,
                mapper.toDomain(request)
        );
    }

    @GetMapping
    public ProductPriceResponse findByBrandAndProductAndDate(
            @RequestParam(name = "brand_id") Long brandId,
            @RequestParam(name = "product_id") Long productId,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  LocalDateTime date
    ) throws NotFoundException {
        return mapper.toResponse(
                finder.findByBrandAndProductAndDate(brandId, productId, date)
        );
    }

}
