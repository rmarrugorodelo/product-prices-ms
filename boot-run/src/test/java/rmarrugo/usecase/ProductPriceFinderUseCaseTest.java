package rmarrugo.usecase;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;
import rmarrugo.faker.TestConstant;
import com.rmarrugo.port.out.ProductPriceRepository;
import com.rmarrugo.usecase.ProductPriceFinderUseCase;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductPriceFinderUseCaseTest {

    @Mock
    private ProductPriceRepository repository;

    @InjectMocks
    private ProductPriceFinderUseCase useCase;

    EasyRandom easyRandom = new EasyRandom();

    private static final LocalDateTime DATE = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

    @Test
    void whenFindByBrandIdAndProductIdAndDate_thenProductPricesShouldBeFound() throws NotFoundException {
        final BigDecimal expected = BigDecimal.valueOf(60.90);
        List<ProductPrice> productPrices = List.of(
                buildProductPrice(expected, 3),
                buildProductPrice(BigDecimal.valueOf(55.45), 0),
                buildProductPrice(BigDecimal.valueOf(45.25), 2)
        );
        Mockito.when(repository.findByBrandIdAndProductIdAndDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(productPrices);
        ProductPrice productPrice = useCase.findByBrandAndProductAndDate(
                TestConstant.BRAND_ID,
                TestConstant.PRODUCT_ID,
                DATE
        );
        Assertions.assertEquals(expected, productPrice.getPrice());
    }

    @Test
    void whenFindByBrandIdAndProductIdAndDateWithEqualsPriority_thenProductPricesShouldBeFound() throws NotFoundException {
        final BigDecimal expected = BigDecimal.valueOf(55.45);
        List<ProductPrice> productPrices = List.of(
                buildProductPrice(expected, 2),
                buildProductPrice(BigDecimal.valueOf(45.25), 2),
                buildProductPrice(BigDecimal.valueOf(66.25), 1)
        );
        Mockito.when(repository.findByBrandIdAndProductIdAndDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(productPrices);
        ProductPrice productPrice = useCase.findByBrandAndProductAndDate(
                TestConstant.BRAND_ID,
                TestConstant.PRODUCT_ID,
                DATE
        );
        Assertions.assertEquals(expected, productPrice.getPrice());
    }

    @Test
    void whenFindByBrandIdAndProductIdAndDate_givenEmptyList_thenExceptionShouldBeFound() {
        Mockito.when(repository.findByBrandIdAndProductIdAndDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Collections.emptyList());
        assertThrows(NotFoundException.class, () -> useCase.findByBrandAndProductAndDate(
                        TestConstant.BRAND_ID,
                        TestConstant.PRODUCT_ID,
                        DATE
                )
        );
    }

    private ProductPrice buildProductPrice(BigDecimal price, int priority) {
        ProductPrice productPrice = easyRandom.nextObject(ProductPrice.class);
        return productPrice
                .withPrice(price)
                .withPriority(priority);
    }


}
