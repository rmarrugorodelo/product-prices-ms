package com.rmarrugo.usecase;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.port.in.ProductPriceFinder;
import com.rmarrugo.port.out.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ProductPriceFinderUseCase implements ProductPriceFinder {

    private final ProductPriceRepository repository;

    public ProductPrice findByBrandAndProductAndDate(Long brandId, Long productId, LocalDateTime date) throws NotFoundException {
        log.info(
                "ProductPriceFinderUseCase:findByBranchAndProductAndDate with brandId {}, productId {} and date {}",
                brandId,
                productId,
                date
        );
        List<ProductPrice> productPrices = repository.findByBrandIdAndProductIdAndDate(brandId, productId, date);
        Comparator<ProductPrice> priorityComparator = Comparator.comparing(ProductPrice::getPriority);
        return productPrices
                .stream()
                .max(priorityComparator)
                .orElseThrow(() -> {
                    log.warn(
                            "ProductPriceFinderUseCase:findByBranchAndProductAndDate with brandId {}, " +
                                    "productId {} and date {} no fount",
                            brandId,
                            productId,
                            date
                    );
                    return new NotFoundException("Product price not found");
                });
    }


}
