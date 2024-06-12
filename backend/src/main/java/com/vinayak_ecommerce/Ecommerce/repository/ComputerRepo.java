package com.vinayak_ecommerce.Ecommerce.repository;

import com.vinayak_ecommerce.Ecommerce.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepo extends JpaRepository<Computer, Long> {
}
