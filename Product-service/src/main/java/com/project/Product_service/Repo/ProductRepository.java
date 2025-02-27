package com.project.Product_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Product_service.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
