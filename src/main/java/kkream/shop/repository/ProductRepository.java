package kkream.shop.repository;

import kkream.shop.domain.Member;
import kkream.shop.domain.Product;
import kkream.shop.exception.MyNotFoundMemberException;
import kkream.shop.exception.MyNotFoundProductException;
import kkream.shop.repository.dto.UpdateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ProductRepository {

    private final ProductMapper productMapper;

    public Optional<Product> findById(Long productId){
        return productMapper.findById(productId);
    }

    public Optional<Product> findByIdForProductView(Long productId){
        return productMapper.findByIdForProductView(productId);
    }

    public List<Product> findAll(){
        return productMapper.findAll();
    }


    public List<Product> findAllWithBrandNameAndPrice(){
        return productMapper.findAllWithBrandNameAndLowestPrice();
    }

    public Product save(Product product){
        productMapper.save(product);
        Product saveProduct = productMapper.findById(product.getProductId())
                .orElseThrow(() -> new MyNotFoundProductException("상품을 찾을 수 없음"));
        log.info("save Product={}", saveProduct);
        return saveProduct;
    }

    public void update(Long productId, Product updateParam){
        productMapper.update(productId, updateParam);
    }


    public void delete(Long productId){
        productMapper.delete(productId);
    }

}
