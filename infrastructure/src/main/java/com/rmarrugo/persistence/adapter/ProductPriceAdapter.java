package com.rmarrugo.persistence.adapter;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.persistence.entity.ProductPriceEntity;
import com.rmarrugo.persistence.mapper.ProductPricePersistenceMapper;
import com.rmarrugo.persistence.repository.ProductPriceJpaRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Qualifier("inDatabaseAdapter")
public class ProductPriceAdapter implements ProductPriceRepository {

    private final ProductPriceJpaRepository jpaRepository;
    private final ProductPricePersistenceMapper mapper;

    @Override
    public List<ProductPrice> findByBrandIdAndProductIdAndDare(Long brandId,
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
    public Optional<ProductPrice> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<ProductPrice> findAll() {
        return ((List<ProductPriceEntity>) jpaRepository.findAll())
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

    @Override
    public void update(ProductPrice productPrice) {
        jpaRepository.save(
                mapper.toEntity(productPrice)
        );
    }

}
