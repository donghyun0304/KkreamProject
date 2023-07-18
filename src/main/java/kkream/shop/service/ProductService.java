package kkream.shop.service;

import kkream.shop.domain.Product;
import kkream.shop.exception.MyNotFoundProductException;
import kkream.shop.repository.ProductImageFileRepository;
import kkream.shop.repository.ProductRepository;
import kkream.shop.service.dto.HomeResponseDto;
import kkream.shop.service.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageFileRepository productImageFileRepository;

    public Product findById(Long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new MyNotFoundProductException("상품을 찾을 수 없음"));
    }

    public ProductResponseDto findByIdForProductView(Long productId){
        Product product = productRepository.findByIdForProductView(productId)
                .orElseThrow(() -> new MyNotFoundProductException("상품을 찾을 수 없음"));

        return new ProductResponseDto(product.getProductName(), product.getModelNumber(),
                product.getReleaseDate(), product.getProductColor(), product.getProductReleasePrice(),
                product.getBrandName(), product.getSizePrice(),
                productImageFileRepository.findAllByProductId(product.getProductId())
            );

    }
    
    public List<Product> findAll(){
        if(productRepository.findAll() != null){
            return productRepository.findAll();
        } else {
            throw new MyNotFoundProductException("상품을 찾을 수 없음");
        }
    }

    public List<HomeResponseDto> findAllWithBrandNameAndPrice(){
        if(productRepository.findAllWithBrandNameAndPrice() != null){
            List<Product> products = productRepository.findAllWithBrandNameAndPrice();
            insertImageFilesInProducts(products);

            return mapToHomeResponseDto(products);

        } else {
            throw new MyNotFoundProductException("상품을 찾을 수 없음");
        }

    }

    private static List<HomeResponseDto> mapToHomeResponseDto(List<Product> products) {
        return products.stream()
                .map(product -> new HomeResponseDto(
                        product.getProductId(), product.getProductName(), product.getBrandName(),
                        product.getSizePrice(), product.getImageFiles())
                ).collect(Collectors.toList());
    }

    private void insertImageFilesInProducts(List<Product> products) {
        products.stream()
                .forEach(product -> {
                    product.setImageFiles(
                            productImageFileRepository.findAllByProductId(product.getProductId())
                    );
                });
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void update(){
    }

    public void delete(Long productId){
        productRepository.delete(productId);
    }


}
