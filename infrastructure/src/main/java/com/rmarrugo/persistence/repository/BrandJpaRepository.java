package com.rmarrugo.persistence.repository;

import com.rmarrugo.persistence.entity.BrandEntity;
import org.springframework.data.repository.CrudRepository;

public interface BrandJpaRepository extends CrudRepository<BrandEntity, Long> {

}
