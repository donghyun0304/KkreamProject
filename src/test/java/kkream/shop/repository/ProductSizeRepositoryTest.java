package kkream.shop.repository;

import kkream.shop.domain.Brand;
import kkream.shop.domain.ProductSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductSizeRepositoryTest {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Test
    void findByProductSize() {
        //given
        ProductSize productSize = new ProductSize("220");
        productSizeRepository.save(productSize);
        //when
        ProductSize findProductSize = productSizeRepository.findByProductSize(productSize.getProductSize()).get();
        //then
        assertThat(findProductSize.getProductSize()).isEqualTo(productSize.getProductSize());
    }

    @Test
    void save() {
        //given
        ProductSize productSize = new ProductSize("220");
        productSizeRepository.save(productSize);
        //when
        ProductSize findProductSize = productSizeRepository.findById(productSize.getProductSizeId()).get();
        //then
        assertThat(findProductSize.getProductSize()).isEqualTo(productSize.getProductSize());
        assertThat(findProductSize.getProductSizeId()).isEqualTo(productSize.getProductSizeId());

    }
}