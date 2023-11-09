package rmarrugo.persistence;

import com.rmarrugo.Application;
import com.rmarrugo.domain.Brand;
import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.persistence.adapter.ProductPriceAdapter;
import com.rmarrugo.persistence.mapper.ProductPricePersistenceMapper;
import com.rmarrugo.persistence.repository.ProductPriceJpaRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import rmarrugo.faker.TestConstant;

import java.time.LocalDateTime;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
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
    void whenFindByBrandIdAndProductIdAndDate_thenProductPricesShouldBeFound(Integer day,
                                                                             Integer hour,
                                                                             Integer founds) {
        List<ProductPrice> productPrices = repository.findByBrandIdAndProductIdAndDate(
                TestConstant.BRAND_ID, TestConstant.PRODUCT_ID, LocalDateTime.of(2020, 6, day, hour, 0, 0)
        );
        Assertions.assertEquals(founds, productPrices.size());
    }

    @Test
    void whenCreate_thenPricesShouldBeSaved() {
        EasyRandom easyRandom = new EasyRandom(
                new EasyRandomParameters().stringLengthRange(5, 20)
        );
        ProductPrice productPrice = easyRandom.nextObject(ProductPrice.class)
                .withBrand(Brand.builder().id(TestConstant.BRAND_ID).build())
                .withStartDate(LocalDateTime.of(2020, 6, 14, 5, 0, 0))
                .withEndDate(LocalDateTime.of(2020, 6, 14, 9, 0, 0))
                .withId(null);
        repository.create(productPrice);
        List<ProductPrice> productPrices = repository.findByBrandIdAndProductIdAndDate(
                TestConstant.BRAND_ID, TestConstant.PRODUCT_ID, LocalDateTime.of(2020, 6, 14, 10, 0, 0)
        );
        Assertions.assertEquals(1, productPrices.size());
    }

}
