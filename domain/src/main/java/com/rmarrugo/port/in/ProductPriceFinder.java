package com.rmarrugo.port.in;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;

import java.time.LocalDateTime;

public interface ProductPriceFinder {

    ProductPrice findByBrandAndProductAndDate(
            Long brandId, Long productId, LocalDateTime date
    ) throws NotFoundException;

}
