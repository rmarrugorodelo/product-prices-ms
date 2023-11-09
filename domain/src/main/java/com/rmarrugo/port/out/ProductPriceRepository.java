package com.rmarrugo.port.out;

import com.rmarrugo.domain.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductPriceRepository {

    List<ProductPrice> findByBrandIdAndProductIdAndDare(Long brandId, Long productId, LocalDateTime date);

    Optional<ProductPrice> findById(Long id);

    List<ProductPrice> findAll();

    void create(ProductPrice productPrice);

    void update(ProductPrice productPrice);


}
