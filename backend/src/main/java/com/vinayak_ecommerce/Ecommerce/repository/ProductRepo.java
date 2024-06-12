package com.vinayak_ecommerce.Ecommerce.repository;

import com.vinayak_ecommerce.Ecommerce.model.Product;
import com.vinayak_ecommerce.Ecommerce.model.utils.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategory(ProductCategory category);
}
