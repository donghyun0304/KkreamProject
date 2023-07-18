package kkream.shop.repository;

import kkream.shop.domain.Brand;
import kkream.shop.domain.ProductSize;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ProductSizeMapper {

    Optional<ProductSize> findById(Long productSizeId);

    Optional<ProductSize> findByProductSize(String productSize);

    void save(ProductSize productSize);
}
