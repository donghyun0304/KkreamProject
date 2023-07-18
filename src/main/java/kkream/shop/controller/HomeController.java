package kkream.shop.controller;

import kkream.shop.service.ProductService;
import kkream.shop.service.dto.HomeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String home(Model model){
        List<HomeResponseDto> homeResponseDtos = productService.findAllWithBrandNameAndPrice();
        model.addAttribute("homeResponseDtos", homeResponseDtos);
        return "home";
    }



}
