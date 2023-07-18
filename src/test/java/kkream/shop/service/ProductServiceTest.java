package kkream.shop.service;

import kkream.shop.domain.*;
import kkream.shop.repository.*;
import kkream.shop.service.dto.HomeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private ProductSizePriceRepository sizePriceRepository;
    @Autowired
    public ProductImageFileRepository productImageFileRepository;

    @Test
    void findAllWithBrandNameAndPrice() {
        productRepositoryTest();
        List<HomeResponseDto> homeResponseDtoList = productService.findAllWithBrandNameAndPrice();
        for (HomeResponseDto homeResponseDto : homeResponseDtoList) {
            log.info("===============================");
            log.info("homeResponseDto={}", homeResponseDto);
        }

        Assertions.assertThat(homeResponseDtoList.size()).isEqualTo(3);

    }

    private void productRepositoryTest() {
        //given
        Brand brand = new Brand("NIKE");
        brandRepository.save(brand);

        ProductSize productSize = new ProductSize("220");
        productSizeRepository.save(productSize);


        Product product1 = new Product(productSize.getProductSizeId(), brand.getBrandId(), 1L,
                "Nike Air Alpha Force 88 Light Bone and Coconut Milk",
                "FN6594-002", "2023/07/05", "BLUE", 159000);
        Product product2 = new Product(productSize.getProductSizeId(), brand.getBrandId(), 1L,
                "Nike V2K Run Summit White Metallic Silver",
                "FN6594-003", "2023/07/05", "BLUE", 149000);
        Product product3 = new Product(productSize.getProductSizeId(), brand.getBrandId(), 1L,
                "(W) Nike Zoom Vomero 5 Cobblestone and Flat Pewter",
                "FN6594-004", "2023/07/05", "BLUE", 219000);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        ProductSizePrice productSizePrice1 =
                new ProductSizePrice(product1.getProductId(), productSize.getProductSizeId(), 100000);
        ProductSizePrice productSizePrice1_1 =
                new ProductSizePrice(product1.getProductId(), productSize.getProductSizeId(), 90000);
        ProductSizePrice productSizePrice2 =
                new ProductSizePrice(product2.getProductId(), productSize.getProductSizeId(), 210000);
        ProductSizePrice productSizePrice3 =
                new ProductSizePrice(product3.getProductId(), productSize.getProductSizeId(), 300000);
        sizePriceRepository.save(productSizePrice1);
        sizePriceRepository.save(productSizePrice1_1);

        sizePriceRepository.save(productSizePrice2);
        sizePriceRepository.save(productSizePrice3);

        List<ProductImageFile> fileList = new ArrayList<>();
        fileList.add(new ProductImageFile(product1.getProductId(), "activity.jpg", "a1.jpg"));
        fileList.add(new ProductImageFile(product1.getProductId(), "shoes.jpg", "a2.jpg"));
        productImageFileRepository.save(fileList);


    }
}