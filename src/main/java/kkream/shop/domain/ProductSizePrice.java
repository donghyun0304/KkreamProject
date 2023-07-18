package kkream.shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSizePrice {

    private Long productSizePriceId;
    private Long productId;
    private Long productSizeId;
    private Integer price;

    public ProductSizePrice() {
    }

    public ProductSizePrice(Long productId, Long productSizeId, Integer price) {
        this.productId = productId;
        this.productSizeId = productSizeId;
        this.price = price;
    }
}
