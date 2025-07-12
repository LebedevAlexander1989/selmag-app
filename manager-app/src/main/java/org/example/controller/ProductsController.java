package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;
}
