package kkream.shop.service.dto;

import kkream.shop.domain.ProductImageFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductResponseDto {

    private String productName;
    private String modelNumber;
    private String releaseDate;
    private String productColor;
    @NumberFormat(pattern = "###,###원")
    private int productReleasePrice;
    private String brandName;
    @NumberFormat(pattern = "###,###원")
    private Integer price;
    private List<ProductImageFile> imageFiles;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String productName, String modelNumber, String releaseDate, String productColor, int productReleasePrice, String brandName, Integer price, List<ProductImageFile> imageFiles) {
        this.productName = productName;
        this.modelNumber = modelNumber;
        this.releaseDate = releaseDate;
        this.productColor = productColor;
        this.productReleasePrice = productReleasePrice;
        this.brandName = brandName;
        this.price = price;
        this.imageFiles = imageFiles;
    }
}
