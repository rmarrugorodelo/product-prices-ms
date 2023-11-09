package com.rmarrugo.usecase;

import com.rmarrugo.port.out.ProductPriceRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductPriceFinderUseCaseTest {

    @Mock
    private ProductPriceRepository repository;

    @InjectMocks
    private ProductPriceFinderUseCase useCase;

   /* @Test
    void testFindByIdentificationInDatabaseOk() throws NotFoundException, PreconditionFailedException {
        EasyRandom easyRandom = new EasyRandom();
        ProductPrice expected = easyRandom.nextObject(ProductPrice.class);
        expected = expected.withIdentificationNumber(TestConstant.IDENTIFICATION_NUMBER);
        Mockito.when(repository.findByIdentification(Mockito.any(), Mockito.any()))
                .thenReturn(Optional.of(expected));
        ProductPrice productPrice = useCase.findByBranchAndProductAndDate(,
                IdentificationType.IDENTIFICATION.getCode(), ,
                expected.getIdentificationNumber(),
        );
        Assertions.assertEquals(expected.getIdentificationNumber(), productPrice.getIdentificationNumber());
    }

    @Test
    void testFindByIdentificationInDatabaseException() {
        Mockito.when(repository.findByIdentification(Mockito.any(), Mockito.any()))
                .thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> useCase.findByBranchAndProductAndDate(,
                        IdentificationType.IDENTIFICATION.getCode(), ,
                        TestConstant.IDENTIFICATION_NUMBER,
                )
        );
    }

    @Test
    void testFindAllInDatabaseOk() {
        EasyRandom easyRandom = new EasyRandom();
        ProductPrice expected = easyRandom.nextObject(ProductPrice.class);
        expected = expected.withIdentificationNumber(TestConstant.IDENTIFICATION_NUMBER);
        Mockito.when(repository.findAll())
                .thenReturn(List.of(expected));
        List<ProductPrice> productPrices = useCase.findAll();
        Assertions.assertEquals(expected.getIdentificationNumber(), productPrices.get(0).getIdentificationNumber());
    }*/

}
