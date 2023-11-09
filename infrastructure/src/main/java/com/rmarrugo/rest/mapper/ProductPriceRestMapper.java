package com.rmarrugo.rest.mapper;


import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.rest.dto.ProductPriceRequest;
import com.rmarrugo.rest.dto.ProductPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductPriceRestMapper {

    @Mapping(target = "brand.id", source = "brandId")
    ProductPrice toDomain(ProductPriceRequest dto);

    @Mapping(target = "brandId", source = "domain.brand.id")
    ProductPriceResponse toResponse(ProductPrice domain);

}
