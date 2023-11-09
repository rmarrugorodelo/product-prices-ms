package com.rmarrugo.config;

import com.rmarrugo.port.out.ProductPriceRepository;
import com.rmarrugo.usecase.ProductPriceFinderUseCase;
import com.rmarrugo.usecase.ProductPriceSaverUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProductPriceSaverUseCase productPriceSaverUseCase(ProductPriceRepository repository) {
        return new ProductPriceSaverUseCase(repository);
    }

    @Bean
    public ProductPriceFinderUseCase productPriceFinderUseCase(ProductPriceRepository repository) {
        return new ProductPriceFinderUseCase(repository);
    }

}
