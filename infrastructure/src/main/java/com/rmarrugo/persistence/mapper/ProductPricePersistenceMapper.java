package com.rmarrugo.persistence.mapper;


import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.persistence.entity.ProductPriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductPricePersistenceMapper {

    ProductPrice toDomain(ProductPriceEntity entity);

    ProductPriceEntity toEntity(ProductPrice domain);

}
