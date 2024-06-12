package com.vinayak_ecommerce.Ecommerce.controller;


import com.vinayak_ecommerce.Ecommerce.model.Product;
import com.vinayak_ecommerce.Ecommerce.model.utils.ProductCategory;
import com.vinayak_ecommerce.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{type}")
    public List<Product> getProducts(@PathVariable ProductCategory type) {
        return productService.getProduct(type);
    }

    @GetMapping("/")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/{type}/{id}")
    public Product getProduct(@PathVariable ProductCategory type, @PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id" + id + "not found");
        }
        return product.get();
    }

}
