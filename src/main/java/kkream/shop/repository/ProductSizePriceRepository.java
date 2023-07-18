package kkream.shop.repository;

import kkream.shop.domain.ProductSize;
import kkream.shop.domain.ProductSizePrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductSizePriceRepository {

    private final ProductSizePriceMapper productSizePriceMapper;

    public Optional<ProductSizePrice> findById(Long productSizePriceId){
        return productSizePriceMapper.findById(productSizePriceId);
    }

    public ProductSizePrice save(ProductSizePrice productSizePrice){
        productSizePriceMapper.save(productSizePrice);
        log.info("save ProductSizePrice={}", productSizePrice);
        return productSizePrice;
    }
}
