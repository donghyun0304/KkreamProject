package kkream.shop.repository;

import kkream.shop.domain.ProductImageFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductImageFileMapper {

    Optional<ProductImageFile> findById(Long fileNumber);

    List<ProductImageFile> findAllByProductId(Long productId);

    void save(ProductImageFile productImageFile);




}
