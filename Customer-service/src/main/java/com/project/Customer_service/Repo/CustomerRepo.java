package com.project.Customer_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Customer_service.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
