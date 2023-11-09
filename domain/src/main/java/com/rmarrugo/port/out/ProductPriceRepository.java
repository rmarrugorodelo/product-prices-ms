package com.rmarrugo.port.out;

import com.rmarrugo.domain.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPriceRepository {

    List<ProductPrice> findByBrandIdAndProductIdAndDate(Long brandId, Long productId, LocalDateTime date);

    void create(ProductPrice productPrice);


}
