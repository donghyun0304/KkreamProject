package kkream.shop.repository;

import kkream.shop.domain.Brand;
import kkream.shop.domain.ProductSize;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductSizeRepository {

    private final ProductSizeMapper productSizeMapper;

    public Optional<ProductSize> findById(Long productSizeId){
        return productSizeMapper.findById(productSizeId);
    }

    public Optional<ProductSize> findByProductSize(String productSize){
        return productSizeMapper.findByProductSize(productSize);
    }

    public ProductSize save(ProductSize productSize){
        productSizeMapper.save(productSize);
        log.info("save ProductSize={}", productSize);
        return productSize;
    }
}
