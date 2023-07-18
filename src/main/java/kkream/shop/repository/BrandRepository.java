package kkream.shop.repository;

import kkream.shop.domain.Brand;
import kkream.shop.domain.Member;
import kkream.shop.exception.MyNotFoundMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BrandRepository {

    private final BrandMapper brandMapper;

    public Optional<Brand> findById(Long brandId){
        return brandMapper.findById(brandId);
    }

    public Optional<Brand> findByBrandName(String brandName){
        return brandMapper.findByBrandName(brandName);
    }

    public Brand save(Brand brand){
        brandMapper.save(brand);
        log.info("save Brand={}", brand);
        return brand;
    }


}
