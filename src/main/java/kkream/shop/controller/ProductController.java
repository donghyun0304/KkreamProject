package kkream.shop.controller;

import kkream.shop.service.ProductService;
import kkream.shop.service.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping("{productId}")
    public String product(@PathVariable Long productId, Model model){
        ProductResponseDto product = productService.findByIdForProductView(productId);
        model.addAttribute("product", product);
        return "product/product";
    }




}
