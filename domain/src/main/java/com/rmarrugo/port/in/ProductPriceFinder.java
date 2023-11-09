package com.rmarrugo.port.in;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPriceFinder {

    ProductPrice findByBrandAndProductAndDate(
            Long brandId, Long productId, LocalDateTime date
    ) throws NotFoundException;

    List<ProductPrice> findAll();

}
