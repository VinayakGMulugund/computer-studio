package com.vinayak_ecommerce.Ecommerce.service;

import com.vinayak_ecommerce.Ecommerce.model.Product;
import com.vinayak_ecommerce.Ecommerce.model.utils.ProductCategory;
import com.vinayak_ecommerce.Ecommerce.repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getProduct(ProductCategory category) {
        return productRepo.findByCategory(category);
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Optional<Product> getProductById(String id) {
        return productRepo.findById(Long.parseLong(id));
    }
}
