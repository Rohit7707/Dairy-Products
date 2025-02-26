package com.project.Product_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Product_service.Entity.ProductListing;

@Repository
public interface ProductListingRepo extends JpaRepository<ProductListing, Long> {
}
