package com.rmarrugo.usecase;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.port.in.ProductPriceSaver;
import com.rmarrugo.port.out.ProductPriceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPriceSaverUseCase implements ProductPriceSaver {

    private final ProductPriceRepository repository;

    @Override
    public void create(ProductPrice productPrice) {
        repository.create(productPrice);
    }

}
