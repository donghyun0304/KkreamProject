package kkream.shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSize {

    private Long productSizeId;
    private String productSize;

    public ProductSize() {
    }

    public ProductSize(String productSize) {
        this.productSize = productSize;
    }
}
