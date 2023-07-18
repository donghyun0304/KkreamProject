package kkream.shop.repository;

import kkream.shop.domain.ProductSize;
import kkream.shop.domain.ProductSizePrice;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ProductSizePriceMapper {

    Optional<ProductSizePrice> findById(Long productSizePriceId);

    void save(ProductSizePrice productSizePrice);
}
