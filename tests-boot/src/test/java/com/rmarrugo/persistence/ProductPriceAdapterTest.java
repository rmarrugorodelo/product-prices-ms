package com.rmarrugo.persistence;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.enumeration.IdentificationType;
import com.rmarrugo.faker.TestConstant;
import com.rmarrugo.persistence.adapter.ProductPriceAdapter;
import com.rmarrugo.persistence.entity.ProductPriceEntity;
import com.rmarrugo.persistence.mapper.ProductPricePersistenceMapper;
import com.rmarrugo.persistence.repository.ProductPriceJpaRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductPriceAdapterTest {

    @Autowired
    private ProductPriceJpaRepository jpaRepository;

    private ProductPriceRepository repository;

    @BeforeEach
    public void setup() {
        ProductPricePersistenceMapper mapper = Mappers.getMapper( ProductPricePersistenceMapper.class );
        repository = new ProductPriceAdapter(jpaRepository, mapper);
        jpaRepository.deleteAll();
    }

    @Test
    void testFindByIdentificationOk() {
        EasyRandom easyRandom = new EasyRandom();
        ProductPriceEntity entity = easyRandom.nextObject(ProductPriceEntity.class);
        entity.setId(null);
        entity.setIdentificationType(IdentificationType.IDENTIFICATION);
        entity.setStartDate(TestConstant.IDENTIFICATION_NUMBER);
        jpaRepository.save(entity);
        Optional<ProductPrice> productPrice = repository.findByIdentification(
                IdentificationType.IDENTIFICATION, TestConstant.IDENTIFICATION_NUMBER
        );
        Assertions.assertFalse(productPrice.isEmpty());
    }

    @Test
    void testFindByIdentificationEmpty() {
        Optional<ProductPrice> productPrice = repository.findByIdentification(
                IdentificationType.IDENTIFICATION, TestConstant.IDENTIFICATION_NUMBER
        );
        Assertions.assertTrue(productPrice.isEmpty());
    }

}
