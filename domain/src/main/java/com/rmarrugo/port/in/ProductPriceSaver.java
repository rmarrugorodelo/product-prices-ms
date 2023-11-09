package com.rmarrugo.port.in;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;

public interface ProductPriceSaver {

    void create(ProductPrice productPrice);

    void update(Long id, ProductPrice productPrice) throws NotFoundException;

}
