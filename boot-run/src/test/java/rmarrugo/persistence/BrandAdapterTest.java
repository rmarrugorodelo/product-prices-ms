package rmarrugo.persistence;

import com.rmarrugo.Application;
import com.rmarrugo.persistence.repository.BrandJpaRepository;
import com.rmarrugo.port.out.BrandRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class BrandAdapterTest {

    @Autowired
    private BrandJpaRepository jpaRepository;

    @Autowired
    private BrandRepository repository;


    @ParameterizedTest
    @CsvSource({
            "1,true",
            "14,false"
    })
    void whenFindByBrandIdAndProductIdAndDate_thenProductPricesShouldBeFound(Long brandId,
                                                                             boolean expected) {
        boolean exists = repository.existsById(brandId);
        Assertions.assertEquals(expected, exists);
    }


}
