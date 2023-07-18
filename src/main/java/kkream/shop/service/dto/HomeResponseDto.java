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
public class HomeResponseDto {

    private Long productId;
    private String productName;
    private String brandName;
    @NumberFormat(pattern = "###,###원")
    private Integer price;
    private List<ProductImageFile> imageFiles;

    public HomeResponseDto() {
    }

    public HomeResponseDto(Long productId, String productName, String brandName,
                           Integer price, List<ProductImageFile> imageFiles) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
        this.imageFiles = imageFiles;
    }
}
