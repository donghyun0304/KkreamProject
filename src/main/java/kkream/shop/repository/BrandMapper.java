package kkream.shop.repository;

import kkream.shop.domain.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BrandMapper {

    Optional<Brand> findById(Long brandId);

    Optional<Brand> findByBrandName(String brandName);

    void save(Brand brand);
}
