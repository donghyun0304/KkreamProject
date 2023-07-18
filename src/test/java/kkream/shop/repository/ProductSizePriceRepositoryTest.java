package kkream.shop.repository;

import kkream.shop.domain.Brand;
import kkream.shop.domain.Product;
import kkream.shop.domain.ProductSize;
import kkream.shop.domain.ProductSizePrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductSizePriceRepositoryTest {

    @Autowired
    private ProductSizePriceRepository productSizePriceRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;



    @Test
    void save() {
        //given
        ProductSize productSize = new ProductSize("220");
        productSizeRepository.save(productSize);

        Brand brand = new Brand("NIKE");
        brandRepository.save(brand);


        Product product = new Product(productSize.getProductSizeId(), brand.getBrandId(), 1L,
                "Nike V2K Run Summit White Metallic Silver", "FD0736-100", "2023/06/15",
                "SUMMIT WHITE/METALLIC SILVER", 139000);
        productRepository.save(product);

        ProductSizePrice productSizePrice =
                new ProductSizePrice(product.getProductId(), productSize.getProductSizeId(), 159000);
        productSizePriceRepository.save(productSizePrice);
        //when
        ProductSizePrice findProductSizePrice =
                productSizePriceRepository.findById(productSizePrice.getProductSizePriceId()).get();
        //then
        assertThat(findProductSizePrice.getProductSizePriceId()).isEqualTo(productSizePrice.getProductSizePriceId());

    }
}