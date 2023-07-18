package kkream.shop.repository;


import kkream.shop.domain.ProductImageFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductImageFileRepository {

    private final ProductImageFileMapper productImageFileMapper;

    public Optional<ProductImageFile> findById(Long fileNumber){
        return productImageFileMapper.findById(fileNumber);
    }

    public List<ProductImageFile> findAllByProductId(Long productId){
        return productImageFileMapper.findAllByProductId(productId);
    }

    public List<ProductImageFile> save(List<ProductImageFile> productImageFiles){
        for(ProductImageFile file : productImageFiles) {
            productImageFileMapper.save(file);
            log.info("file={}", file);
        }
        return productImageFiles;
    }
}
