package com.rmarrugo.usecase;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;
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

    @Override
    public void update(Long id, ProductPrice productPrice) throws NotFoundException {
        exists(id);
        repository.update(
                productPrice.withId(id)
        );
    }

    public void exists(Long id) throws NotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product price not found"));
    }
}
