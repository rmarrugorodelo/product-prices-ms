package com.rmarrugo.port.in;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;

public interface ProductPriceSaver {

    void create(ProductPrice productPrice) throws NotFoundException;

}
