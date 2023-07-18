package kkream.shop.repository;

import kkream.shop.domain.Brand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void findByBrandName() {
        //given
        Brand brand = new Brand("NIKE");
        brandRepository.save(brand);
        //when
        Brand findBrand = brandRepository.findByBrandName(brand.getBrandName()).get();
        //then
        assertThat(findBrand.getBrandName()).isEqualTo(brand.getBrandName());
    }

    @Test
    void save() {
        //given
        Brand brand = new Brand("NIKE");
        brandRepository.save(brand);
        //when
        Brand findBrand = brandRepository.findById(brand.getBrandId()).get();
        //then
        assertThat(findBrand.getBrandName()).isEqualTo(brand.getBrandName());
        assertThat(findBrand.getBrandId()).isEqualTo(brand.getBrandId());

    }
}