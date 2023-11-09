package com.rmarrugo.persistence.repository;

import com.rmarrugo.persistence.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPriceJpaRepository extends CrudRepository<ProductPriceEntity, Long> {

    @Query("SELECT pp FROM ProductPriceEntity pp  JOIN pp.brand b " +
            "WHERE b.id = :brandId AND pp.productId = :productId AND :date >= pp.startDate AND :date <= pp.endDate")
    List<ProductPriceEntity> findByBrandIdAndProductIdAndDate(
            Long brandId, Long productId, LocalDateTime date
    );
}
