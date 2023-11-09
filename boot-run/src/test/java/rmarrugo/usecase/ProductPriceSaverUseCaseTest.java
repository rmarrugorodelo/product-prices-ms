package rmarrugo.usecase;

import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.exception.NotFoundException;
import com.rmarrugo.port.out.BrandRepository;
import com.rmarrugo.port.out.ProductPriceRepository;
import com.rmarrugo.usecase.ProductPriceSaverUseCase;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductPriceSaverUseCaseTest {

    @Mock
    private ProductPriceRepository repository;

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private ProductPriceSaverUseCase useCase;

    EasyRandom easyRandom = new EasyRandom();

    @Test
    void whenCreate_thenProductPricesShouldBeCreated() throws NotFoundException {
        ProductPrice productPrice = easyRandom.nextObject(ProductPrice.class);
        Mockito.doNothing().when(repository).create(Mockito.any());
        Mockito.when(brandRepository.existsById(Mockito.any()))
                .thenReturn(Boolean.TRUE);
        useCase.create(productPrice);
        Mockito.verify(repository, Mockito.times(1)).create(productPrice);
    }

    @Test
    void whenCreate_givenBrandNoExists_thenShouldThrowException() throws NotFoundException {
        ProductPrice productPrice = easyRandom.nextObject(ProductPrice.class);
        Mockito.when(brandRepository.existsById(Mockito.any()))
                .thenReturn(Boolean.FALSE);
        Assertions.assertThrows(
                NotFoundException.class,
                () -> useCase.create(productPrice)
        );
    }


}
