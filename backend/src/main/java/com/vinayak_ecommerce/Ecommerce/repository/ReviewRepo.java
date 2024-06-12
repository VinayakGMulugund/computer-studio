package com.vinayak_ecommerce.Ecommerce.repository;

import com.vinayak_ecommerce.Ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
