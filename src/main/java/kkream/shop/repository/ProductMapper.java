package kkream.shop.repository;

import kkream.shop.domain.Member;
import kkream.shop.domain.Product;
import kkream.shop.repository.dto.UpdateMemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {

    Optional<Product> findById(Long productId);

    List<Product> findAll();

    Optional<Product> findByIdForProductView(Long productId);

    //상품별 사이즈와 관계없이 최저가 상품만 조회
    List<Product> findAllWithBrandNameAndLowestPrice();

    void save(Product product);

    void update(@Param("productId") Long productId, @Param("updateParam") Product updateParam);

    void delete(Long productId);


}
