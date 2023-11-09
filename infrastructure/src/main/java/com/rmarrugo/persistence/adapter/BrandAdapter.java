package com.rmarrugo.persistence.adapter;

import com.rmarrugo.persistence.repository.BrandJpaRepository;
import com.rmarrugo.port.out.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BrandAdapter implements BrandRepository {

    private final BrandJpaRepository jpaRepository;

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
