package com.rmarrugo.persistence;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.faker.TestConstant;
import com.rmarrugo.persistence.adapter.ProductPriceAdapter;
import com.rmarrugo.persistence.mapper.ProductPricePersistenceMapper;
import com.rmarrugo.persistence.repository.ProductPriceJpaRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductPriceAdapterTest {

    @Autowired
    private ProductPriceJpaRepository jpaRepository;

    private ProductPriceRepository repository;

    @BeforeEach
    public void setup() {
        ProductPricePersistenceMapper mapper = Mappers.getMapper(ProductPricePersistenceMapper.class);
        repository = new ProductPriceAdapter(jpaRepository, mapper);
    }

    @ParameterizedTest
    @CsvSource({
            "14,10,1",
            "14,16,2",
            "15,21,2",
            "16,21,2"
    })
    void whenFindByBrandIdAndProductIdAndDate_thenOneProductPricesShouldBeFound(Integer day,
                                                                                Integer hour,
                                                                                Integer founds) {
        List<ProductPrice> productPrice = repository.findByBrandIdAndProductIdAndDate(
                TestConstant.BRAND_ID, TestConstant.PRODUCT_ID, LocalDateTime.of(2020, 6, day, hour, 0, 0)
        );
        Assertions.assertEquals(founds, productPrice.size());
    }


}
