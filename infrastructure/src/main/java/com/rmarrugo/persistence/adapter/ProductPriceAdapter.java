package com.rmarrugo.persistence.adapter;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.persistence.mapper.ProductPricePersistenceMapper;
import com.rmarrugo.persistence.repository.ProductPriceJpaRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ProductPriceAdapter implements ProductPriceRepository {

    private final ProductPriceJpaRepository jpaRepository;
    private final ProductPricePersistenceMapper mapper;

    @Override
    public List<ProductPrice> findByBrandIdAndProductIdAndDate(Long brandId,
                                                               Long productId,
                                                               LocalDateTime date) {
        return jpaRepository.findByBrandIdAndProductIdAndDate(
                        brandId, productId, date
                )
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void create(ProductPrice productPrice) {
        jpaRepository.save(
                mapper.toEntity(productPrice)
        );
    }

}
