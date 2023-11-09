package com.rmarrugo.rest.mapper;


import com.rmarrugo.domain.ProductPrice;
import com.rmarrugo.rest.dto.ProductPriceRequest;
import com.rmarrugo.rest.dto.ProductPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductPriceRestMapper {

    ProductPrice toDomain(ProductPriceRequest dto);

    ProductPriceResponse toResponse(ProductPrice domain);

}
