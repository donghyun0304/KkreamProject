package kkream.shop.repository;

import kkream.shop.domain.Brand;
import kkream.shop.domain.Product;
import kkream.shop.domain.ProductSize;
import kkream.shop.domain.ProductSizePrice;
import kkream.shop.exception.MyNotFoundProductException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Slf4j
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private ProductSizePriceRepository sizePriceRepository;


    @Test
    @DisplayName("상품 존재")
    void save(){
        //given
        Product product = new Product(1L, 1L, 1L, "나이키",
                "FN6594-001", "2023/07/05", "BLUE", 169000);
        productRepository.save(product);
        //when
        Product findProduct = productRepository.findById(product.getProductId())
                .orElseThrow(() -> new MyNotFoundProductException("상품을 찾을 수 없음"));
        //then
        assertThat(findProduct.getProductId()).isEqualTo(findProduct.getProductId());
    }

    @Test
    @DisplayName("예외 확인")
    void findById(){
        assertThatThrownBy(() -> productRepository.findById(0L)
                .orElseThrow(() -> new MyNotFoundProductException("상품을 찾을 수 없음")))
                .isInstanceOf(MyNotFoundProductException.class)
                .hasMessageContaining("상품을 찾을 수 없음");
    }

    @Test
    void findByIdForProductView(){
        //given
        Brand brand = new Brand("NIKE");
        brandRepository.save(brand);

        ProductSize productSize = new ProductSize("220");
        productSizeRepository.save(productSize);

        Product product = new Product(productSize.getProductSizeId(), brand.getBrandId(), 1L,
                "Nike Air Alpha Force 88 Light Bone and Coconut Milk",
                "FN6594-002", "2023/07/05", "BLUE", 159000);
        productRepository.save(product);

        ProductSizePrice productSizePrice =
                new ProductSizePrice(product.getProductId(), productSize.getProductSizeId(), 100000);
        sizePriceRepository.save(productSizePrice);

        //when
        Product findProduct = productRepository.findByIdForProductView(product.getProductId()).get();

        //then
        assertThat(findProduct.getProductId()).isEqualTo(product.getProductId());
    }


    @Test
    void findAll(){
        //given
        Product product1 = new Product(1L, 1L, 1L, "나이키",
                "FN6594-002", "2023/07/05", "BLUE", 169000);
        Product product2 = new Product(1L, 1L, 1L, "나이키",
                "FN6594-003", "2023/07/05", "BLUE", 169000);
        Product product3 = new Product(1L, 1L, 1L, "나이키",
                "FN6594-004", "2023/07/05", "BLUE", 169000);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        //when
        List<Product> products = productRepository.findAll();
        //then
        assertThat(products.size()).isEqualTo(3);
    }

    @Test
    void findAllWithBrandNameAndLowestPrice(){
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

        //when
        List<Product> products = productRepository.findAllWithBrandNameAndPrice();
        for (Product product : products) {
            log.info("========================");
            log.info("find product={}",product);
        }
        //then
        assertThat(products.size()).isEqualTo(3);
    }

    @Test
    void update(){
        //given
        Product product = new Product(1L, 1L, 1L, "나이키",
                "FN6594-001", "2023/07/05", "BLUE", 169000);
        productRepository.save(product);
        //when
        Product updateParam = new Product(2L, 2L, 2L, "아디다스",
                "a", "2023/07/01", "GREEN", 159000);

        productRepository.update(product.getProductId(), updateParam);
        //then
        Product updateProduct = productRepository.findById(product.getProductId()).get();

        assertThat(updateParam.getBrandId()).isEqualTo(updateProduct.getBrandId());
        assertThat(updateParam.getCategoryId()).isEqualTo(updateProduct.getCategoryId());
        assertThat(updateParam.getProductName()).isEqualTo(updateProduct.getProductName());
        assertThat(updateParam.getModelNumber()).isEqualTo(updateProduct.getModelNumber());
        assertThat(updateParam.getReleaseDate()).isEqualTo(updateProduct.getReleaseDate());
        assertThat(updateParam.getProductColor()).isEqualTo(updateProduct.getProductColor());
        assertThat(updateParam.getProductReleasePrice()).isEqualTo(updateProduct.getProductReleasePrice());
    }

    @Test
    void delete(){
        //given
        Product product = new Product(1L, 1L, 1L, "나이키",
                "FN6594-001", "2023/07/05", "BLUE", 169000);
        productRepository.save(product);
        //when
        productRepository.delete(product.getProductId());
        //then
        char deletedStatus = productRepository.findById(product.getProductId())
                .get().getDeletedStatus();
        assertThat(deletedStatus).isEqualTo('Y');
    }







}
