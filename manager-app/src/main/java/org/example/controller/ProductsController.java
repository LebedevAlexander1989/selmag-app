package org.example.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.entity.Product;
import org.example.payload.NewProductPayload;
import org.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogue/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping(value = "/list")
    public String getListProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage() {
        return "catalogue/products/new-product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {
        Product product = productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/list";
    }

    @GetMapping("{productId:\\d+}")
    public String getProduct(@PathVariable(name = "productId") int productId, Model model) {
        model.addAttribute("product", productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }
}
