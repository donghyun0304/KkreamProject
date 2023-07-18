package kkream.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Product {

    private Long productId;
    private Long productSizeId;
    private Long brandId;
    private Long categoryId;
    private String productName;
    private String modelNumber;
    private String releaseDate;
    private String productColor;
    private int productReleasePrice;
    private char deletedStatus;
    private String brandName;
    private List<ProductImageFile> imageFiles;
    private Integer sizePrice;



    public Product() {
    }

    public Product(Long productSizeId, Long brandId, Long categoryId, String productName,
                   String modelNumber, String releaseDate, String productColor,
                   int productReleasePrice) {
        this.productSizeId = productSizeId;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.modelNumber = modelNumber;
        this.releaseDate = releaseDate;
        this.productColor = productColor;
        this.productReleasePrice = productReleasePrice;
    }
}
