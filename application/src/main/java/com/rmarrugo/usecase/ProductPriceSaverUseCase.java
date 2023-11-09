package com.rmarrugo.usecase;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.port.in.ProductPriceSaver;
import com.rmarrugo.port.out.BrandRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPriceSaverUseCase implements ProductPriceSaver {

    private final ProductPriceRepository repository;
    private final BrandRepository brandRepository;

    @Override
    public void create(ProductPrice productPrice) throws NotFoundException {
        if(!brandRepository.existsById(productPrice.getBrand().getId())) {
            throw new NotFoundException(String.format(
                    "Brand with id %s no fount", productPrice.getBrand().getId()
            ));
        }
        repository.create(productPrice);
    }

}
