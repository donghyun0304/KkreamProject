package kkream.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductImageFile {

    private Long fileNumber;
    private Long productId;
    private String uploadFileName;
    private String storeFileName;
    private String createdDate;
    private String deletedStatus;

    public ProductImageFile(Long productId, String uploadFileName, String storeFileName) {
        this.productId = productId;
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
